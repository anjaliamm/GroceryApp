package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestCases extends baseClass {
	LoginPage lp;
	HomePage hp;

	@Test(groups="Sanity")
	public void verifySelectValueFromManageExpenseDropdown() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp.clickManageExpenseDropdown();
		hp.clickExpenseCategory();
		String actualResult = lp.URLAfterSignIn();
		String expectedResult =Constant.EXPENSECATEGORYURL;
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE);

	}

	@Test(groups="Regression")
	public void verifyCategorySearchListProductsDropdown() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp.clickManageProductTab();
		hp.clickListProductSearchButton();
		String actualResult = hp.verifyFirstSelectedOptionOfCategoryDropdownList(1);
		String expectedResult =Constant.ITEMNAME;
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE);
	}

	@Test(groups="Smoke")
	public void verifySubCategoryListProductsDropdown() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp.clickManageProductTab();
		hp.clickListProductSearchButton();
		hp.verifyFirstSelectedOptionOfCategoryDropdownList(1);
		hp.clickSubCategoryDropdown();
		String actualResult = hp.verifySelectedOptionOfSubCategoryDropdownList("14");
		String expectedResult =Constant.ITEMDROPDOWNLIST;
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE);
	}

	@Test(groups="Smoke")
	public void verifyFunctionalityOfLogOutButton() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickAdminButton();
		hp.clickLogoutOption();
		String actualResult = lp.URLAfterSignIn();
		String expectedResult =Constant.LOGINURL;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test(groups="Sanity")
	public void isSelectedVegProductTypeRadioButton() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickManageProductTab();
		hp.clickNewButton();
		boolean expectedResult = hp.isSelectedProductTypeRadioButton();
		boolean actualResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test(groups="Regression")
	public void verifyTextonAlertExpenseCategoryWhenDeleteButtonClicked() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickManageExpenseDropdown();
		hp.clickExpenseCategory();
		hp.clickDeleteButton();
		String expectedResult =Constant.DELETEMESSAGE;
		String actualResult = hp.verifytextonalertofDeleteButton();
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test(groups="Regression")
	public void verifyManageFooterTextDropdownValueIsSelected() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickManageContentTile();
		hp.clickManageFooterTextRadioButton();
		String actualResult = hp.verifyclickManageFooterTextRadioButton();
		String expectedResult =Constant.FOOTERTEXTURL;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}
}
