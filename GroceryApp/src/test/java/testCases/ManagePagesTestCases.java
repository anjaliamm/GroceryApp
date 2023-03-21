package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManagePages;

public class ManagePagesTestCases extends baseClass {
	LoginPage lp;
	ManagePages mp;

	@Test(groups="Sanity")
	public void verifyTooltipValueOfStyleDescription() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mp = new ManagePages(driver);
		mp.clickManagePagesTile();
		mp.clickNewButton();
		String actualResult = mp.verifyTooltipValueOfStyleInDescription(Constant.TOOLTIPVALUE);
		String expectedResult =Constant.STYLE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}
	
}
