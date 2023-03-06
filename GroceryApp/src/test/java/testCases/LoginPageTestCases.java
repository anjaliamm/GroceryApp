package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

import java.io.IOException;
import org.testng.Assert;

public class LoginPageTestCases extends baseClass { // inheritance

	LoginPage lp;

	@Test(groups= {"Critical"} )
	public void verifyTextOfSignInButton() {
		lp = new LoginPage(driver);
		String actualResult = lp.getTextOfSignInButton();
		String expectedResult = "Sign In";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

	@Test(groups= {"Critical"} )
	public void verifyRemembermeCheckbxIsUnselected() {
		lp = new LoginPage(driver);
		boolean actualResult = false;
		boolean expectedResult = lp.verifythecheckboxisunselected();
		Assert.assertEquals(actualResult, expectedResult, Constant.REMEMBERMECHECKBOXERRORMESSAGE);

	}
	@Test
	public void verifyTheTextOfLoginPageTitle() {
		lp = new LoginPage(driver);
		String actualResult=lp.getTitleOfPage();
		String expectedResult="7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
				
	}

	@Test(groups= {"High"} )
	public void verifyInValidCredentials() {
		lp = new LoginPage(driver);
		lp.enterUsername("adwin");
		lp.enterPassword("1234");
		lp.clickLogin();
		String actualResult = lp.verifyInvalidUsernamePasswordErrorMessage();
		String expectedResult =   "×\n"
				+ "Alert!\n"
				+ "Invalid Username/Password";    
		Assert.assertEquals(actualResult, expectedResult, "Username and password matches");

	}

	@Test
	public void verifyTheBackgroundColorOfSignInButton() {
		lp = new LoginPage(driver);
		String actualResult = lp.verifyTheBackgroundColorOfSignInButtonInLoginPage();
		String expectedResult = "rgba(52, 58, 64, 1)";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyValidCredentials() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		String actualResult = lp.URLAfterSignIn();
		String expectedResult = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
