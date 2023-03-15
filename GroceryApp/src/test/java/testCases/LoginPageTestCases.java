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
		String expectedResult =Constant.SIGNIN;
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
		String expectedResult=Constant.SUPERMARKETNAME;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
				
	}

	@Test(dataProvider="dataProvider",dataProviderClass=DataProviderTest.class )
	public void verifyInValidCredentials(String user,String pass) {
		lp = new LoginPage(driver);
		lp.enterUsername(user);
		lp.enterPassword(pass);
		lp.clickLogin();
		String actualResult = lp.verifyInvalidUsernamePasswordErrorMessage();
		String expectedResult =Constant.INVALIDUSERNAMEPASSWORDMESSAGE;
		Assert.assertEquals(actualResult, expectedResult,Constant.PASSWORDANDUSERNAMEMATCHES);

	}

	@Test(groups= {"High"} )
	public void verifyTheBackgroundColorOfSignInButton() {
		lp = new LoginPage(driver);
		String actualResult = lp.verifyTheBackgroundColorOfSignInButtonInLoginPage();
		String expectedResult =Constant.COLOURCODE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyValidCredentials() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData((prop.getProperty("DataProviderSheet")), 1, 0));
		lp.enterPassword(ExcelRead.readStringData((prop.getProperty("DataProviderSheet")), 1, 1));
		lp.clickLogin();
		String actualResult = lp.URLAfterSignIn();
		String expectedResult =Constant.ADMINURL;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
