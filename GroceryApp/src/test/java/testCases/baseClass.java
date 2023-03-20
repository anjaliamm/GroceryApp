package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class baseClass {

	public static Properties prop;
	ScreenshotUtility ss;

	public static void testBasic() throws IOException {
		prop = new Properties();          //object creation of properties class
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+
				Constant.CONFIGPROPERTIESFILEPATH);
		prop.load(ip);                  //Using load method we can load the properties file into the project
	}

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void beforeMethod(String browsername) throws IOException { 
		testBasic();

		if(browsername.equals(Constant.CHROMEBROWSER)) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\vivek\\Downloads\\chromedriver_win32\\chromedriver.exe\\");
			System.setProperty("webdriver.http.factory","jdk-http-client");
			driver=new ChromeDriver();
			ChromeOptions ops=new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
		}
		else if(browsername.equals(Constant.EDGEBROWSER)) {
			driver=new EdgeDriver();
		}
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
