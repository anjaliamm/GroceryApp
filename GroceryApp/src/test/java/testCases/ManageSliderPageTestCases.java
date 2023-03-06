package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;
import utilities.ExcelRead;

public class ManageSliderPageTestCases extends baseClass {
	LoginPage lp;
	ManageSliderPage ms;
  @Test
  public void verifyAlertMessageIsShownWhenFileUploadedSuccessfully() throws IOException, AWTException {
	  lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		ms=new ManageSliderPage(driver);
		ms.clickManageSliderPageTile();
		ms.clickNewButton();
		ms.imageUpload();
		ms.enterLink("https://www.google.com");
		ms.clickSubmitButton();
		String actualResult=ms.alertMessage();
		String expectedResult="�\n"
				+ "Alert!\n"
				+ "Slider Created Successfully";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);		

  }
}
