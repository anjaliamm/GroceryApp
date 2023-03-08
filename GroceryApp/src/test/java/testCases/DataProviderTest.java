package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
  @Test
  public void f(Integer n,String s) {
	 
  }
  @DataProvider(name="dataProvider")
  public Object[][] dpmethod()
  {
	  return new Object[][]
			  {
		      {"adwin","version"},
		      {"adwin","5463"},
		      {"anjali","12345"},
			  };
  }
}
