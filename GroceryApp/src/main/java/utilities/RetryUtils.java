package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtils implements IRetryAnalyzer{
	int initialCount=0;
	int maxRetryCount=3;
	@Override
	public boolean retry(ITestResult result) {
		if(initialCount < maxRetryCount) {
			initialCount++;
			return true;
		}
		return false;
	}

}
