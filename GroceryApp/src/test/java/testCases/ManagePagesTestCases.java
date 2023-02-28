package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManagePages;
import utilities.ExcelRead;

public class ManagePagesTestCases extends baseClass {
	LoginPage lp;
	ManagePages mp;

	@Test(enabled=false)
	public void verifyTooltipValueOfStyleDescription() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		mp = new ManagePages(driver);
		mp.clickManagePagesTile();
		mp.clickNewButton();
		String actualResult = mp.verifyTooltipValueOfStyleInDescription("aria-label");
		String expectedResult = "Style";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}
	@Test
	public void verifyAlertMessageShownAfterImageUploadedSuccessfully() throws IOException, AWTException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		mp = new ManagePages(driver);
		mp.clickManagePagesTile();
		mp.clickNewButton();
		mp.enterTitleInTextbox("HelloWorld");
		mp.enterDescriptionInTextbox("This is a sample image");
		mp.enterPageInTextBox("kids");
		mp.clickImgFile();
		mp.imageUpload();
		mp.clickSaveButton();
		String actualResult=mp.getAlertMessageWhenFileUploadedSuccessfully();
		String expectedResult="\"×\\n\" + \"Alert!\\n\" + \"Page Created Successfully\\n\"";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}
}
