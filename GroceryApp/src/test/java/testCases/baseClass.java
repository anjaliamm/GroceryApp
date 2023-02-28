package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenshotUtility;

public class baseClass {

	public static Properties prop;
	ScreenshotUtility ss;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\vivek\\eclipse-workspace\\GroceryApp\\src\\main\\resources\\Config.properties");
		prop.load(ip);
	}

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void beforeMethod(String browsername) throws IOException { 
		testBasic();

		if(browsername.equals("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browsername.equals("Edge")) {
			driver=new EdgeDriver();
		}
		driver=new ChromeDriver();
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {

		if (itestResult.getStatus() == ITestResult.FAILURE) {
			ss = new ScreenshotUtility();
			ss.captureFailureScreenShot(driver, itestResult.getName());
		}

		driver.quit();
	}
}
