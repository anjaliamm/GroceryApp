package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;

public class ManageSliderPageTestCases extends baseClass {
	LoginPage lp;
	ManageSliderPage ms;
  @Test
  public void verifyAlertMessageIsShownWhenFileUploadedSuccessfully() throws IOException, AWTException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		ms=new ManageSliderPage(driver);
		ms.clickManageSliderPageTile();
		ms.clickNewButton();
		ms.imageUpload();
		ms.enterLink(Constant.GOOGLE);
		ms.clickSubmitButton();
		String actualResult=ms.alertMessage();
		String expectedResult=Constant.SLIDERCREATEDSUCCESSFULMESSAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);		

  }
}
