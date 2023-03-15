package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils implements ITestListener {           //interface-without method body 
	ExtentSparkReporter sparkReporter;                               //main classes used
	ExtentReports reports;                                            //customizable HTML report for pie chart representation
	ExtentTest test;
	public static Properties prop;
	
	public static void testBasic() throws IOException {
		prop=new Properties();		
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");	
		prop.load(ip);
	}

	public void configureReport() throws IOException {
		testBasic();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss"); //display the date and time taken for each test case execution
		String strDate = formatter.format(date);

		File reportPath = new File(System.getProperty("user.dir") + prop.getProperty("ExtentReport"));

		if (!reportPath.exists()) {
			reportPath.mkdir();
		}

		// create file
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

		// System details
		reports.setSystemInfo("PC Name", "ANJALIVIVEK");
		reports.setSystemInfo("OS", "Windows 10");
		sparkReporter.config().setDocumentTitle("Extent Report Sample");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext context) {//executing preconditions of a test case
		try {
			configureReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {     //executing post conditions
		reports.flush(); //report file gets generated
	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,                               //log method to log the status of each step
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));

	}

	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

}
