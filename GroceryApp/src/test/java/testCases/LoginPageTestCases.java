package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.DataProviderUtility;

import java.io.IOException;
import org.testng.Assert;

public class LoginPageTestCases extends baseClass { // inheritance

	LoginPage lp;

	@Test(groups= {"Critical"} )
	public void verifyTextOfSignInButton() {
		lp = new LoginPage(driver);
		String actualResult = lp.getTextOfSignInButton();
		String expectedResult =Constant.SIGNIN;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

	@Test
	public void verifyRemembermeCheckbxIsUnselected() {
		lp = new LoginPage(driver);
		boolean actualResult = false;
		boolean expectedResult = lp.verifythecheckboxisunselected();
		Assert.assertEquals(actualResult, expectedResult, Constant.REMEMBERMECHECKBOXERRORMESSAGE);

	}
	@Test(groups= {"Critical"} )
	public void verifyTheTextOfLoginPageTitle() {
		lp = new LoginPage(driver);
		String actualResult=lp.getTitleOfPage();
		String expectedResult=Constant.SUPERMARKETNAME;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
				
	}

	@Test(dataProvider="dataProvider",dataProviderClass=DataProviderUtility.class )
	public void verifyInValidCredentials(String user,String pass) {
		lp = new LoginPage(driver);
		lp.enterUsername(user);
		lp.enterPassword(pass);
		lp.clickLogin();
		boolean actualResult = lp.getErrorMessage(Constant.INVALIDUSERNAMEPASSWORDMESSAGE);
		
		Assert.assertTrue(actualResult,Constant.PASSWORDANDUSERNAMEMATCHES);

	}

	@Test(groups= {"High"} )
	public void verifyTheBackgroundColorOfSignInButton() {
		lp = new LoginPage(driver);
		String actualResult = lp.verifyTheBackgroundColorOfSignInButtonInLoginPage();
		String expectedResult =Constant.COLOURCODE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test(groups= {"Critical"} )
	public void verifyValidCredentials() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		String actualResult = lp.URLAfterSignIn();
		String expectedResult =Constant.ADMINURL;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
