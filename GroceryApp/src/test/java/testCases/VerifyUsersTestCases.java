package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.VerifyUsersPage;

public class VerifyUsersTestCases extends baseClass {
	LoginPage lp;
	HomePage hp;
	VerifyUsersPage vp;

	@Test(groups="Sanity")
	public void selectStatusAsActiveFromDropdown() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		vp = new VerifyUsersPage(driver);
		vp.clickVerifyUsersTile();
		vp.clickSearchButton();
		vp.clickStatusDropdown();
		String actualResult = vp.verifyActiveUserOption(Constant.ACTIVESTATUSDROPDOWN);
		String expectedResult =Constant.ACTIVEDROPDOWN;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

	@Test(groups="Regression")
	public void alertMessageResultNotFound() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		vp = new VerifyUsersPage(driver);
		vp.clickVerifyUsersTile();
		vp.clickSearchButton();
		vp.enterName(Constant.TYPENAME);
		vp.enterEmail(Constant.TYPEEMAIL);
		vp.enterPhoneNumber(Constant.TYPEPHONENUMBER);
		vp.clickStatusDropdown();
		vp.verifyActiveUserOption(Constant.ACTIVESTATUSDROPDOWN);
		vp.clickSecondSearchButtonOfVerifyUsers();
		String actualResult = vp.alertResultNotFound();
		String expectedResult =Constant.RESULTNOTFOUNDMESSAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}
	

}
