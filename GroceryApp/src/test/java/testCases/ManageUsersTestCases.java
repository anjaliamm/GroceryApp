package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;

public class ManageUsersTestCases extends baseClass {
	LoginPage lp;
	ManageUsersPage mu;

	@Test
	public void verifyActiveStatusSelectedInDropdown() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mu = new ManageUsersPage(driver);
		mu.clickManageUsersTile();
		mu.clickSearchButton();
		mu.typeName(Constant.TYPENAME);
		mu.typeEmail(Constant.TYPEEMAIL);
		mu.typePhoneNumber(Constant.TYPEPHONENUMBER);
		String actualResult = mu.verifyActiveStatusDropdown(Constant.ACTIVESTATUSDROPDOWN);
		String expectedResult =Constant.ACTIVEDROPDOWN;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyErrorMessageShownWhenInvalidDetailsGiven() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mu = new ManageUsersPage(driver);
		mu.clickManageUsersTile();
		mu.clickSearchButton();
		mu.typeName(Constant.TYPENAME);
		mu.typeEmail(Constant.TYPEEMAIL);
		mu.typePhoneNumber(Constant.TYPEPHONENUMBER);
		mu.verifyActiveStatusDropdown(Constant.ACTIVESTATUSDROPDOWN);
		mu.clickSearchButtonInSearchPage();
		String actualResult = mu.getResultNotFoundErrorMessage();
		String expectedResult =Constant.RESULTNOTFOUNDMESSAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}
}
