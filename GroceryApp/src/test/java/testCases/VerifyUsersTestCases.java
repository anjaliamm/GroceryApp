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

	@Test
	public void selectStatusAsActiveFromDropdown() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		vp = new VerifyUsersPage(driver);
		vp.clickVerifyUsersTile();
		vp.clickSearchButton();
		vp.clickStatusDropdown();
		String actualResult = vp.verifyActiveUserOption("active");
		String expectedResult = "Active";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

	@Test
	public void alertMessageResultNotFound() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		vp = new VerifyUsersPage(driver);
		vp.clickVerifyUsersTile();
		vp.clickSearchButton();
		vp.enterName("Anjali");
		vp.enterEmail("ritaanjali.01@gmail.com");
		vp.enterPhoneNumber("9947636408");
		vp.clickStatusDropdown();
		vp.verifyActiveUserOption("active");
		vp.clickSecondSearchButtonOfVerifyUsers();
		String actualResult = vp.alertResultNotFound();
		String expectedResult = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

}
