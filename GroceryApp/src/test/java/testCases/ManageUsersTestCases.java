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
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		mu = new ManageUsersPage(driver);
		mu.clickManageUsersTile();
		mu.clickSearchButton();
		mu.typeName("Anjali");
		mu.typeEmail("ritaanjali@gmail.com");
		mu.typePhoneNumber("9947636408");
		String actualResult = mu.verifyActiveStatusDropdown("active");
		String expectedResult = "Active";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyErrorMessageShownWhenInvalidDetailsGiven() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		mu = new ManageUsersPage(driver);
		mu.clickManageUsersTile();
		mu.clickSearchButton();
		mu.typeName("Anjali");
		mu.typeEmail("ritaanjali@gmail.com");
		mu.typePhoneNumber("9947636408");
		mu.verifyActiveStatusDropdown("active");
		mu.clickSearchButtonInSearchPage();
		String actualResult = mu.getResultNotFoundErrorMessage();
		String expectedResult = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}
}
