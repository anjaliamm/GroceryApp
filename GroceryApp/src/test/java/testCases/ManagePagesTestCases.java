package testCases;

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

	@Test
	public void verifyTooltipValueOfStyleDescription() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData((prop.getProperty("DataProviderSheet")), 1, 0));
		lp.enterPassword(ExcelRead.readStringData((prop.getProperty("DataProviderSheet")), 1, 1));
		lp.clickLogin();
		mp = new ManagePages(driver);
		mp.clickManagePagesTile();
		mp.clickNewButton();
		String actualResult = mp.verifyTooltipValueOfStyleInDescription(Constant.TOOLTIPVALUE);
		String expectedResult =Constant.STYLE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}
	
}
