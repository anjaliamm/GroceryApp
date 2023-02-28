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

	@Test
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
		String expectedResult ="https://groceryapp.uniqassosiates.com/admin/expense-category";
		Assert.assertEquals(actualResult, expectedResult, "First selected option does not match");

	}

	@Test
	public void verifyCategorySearchListProductsDropdown() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		hp.clickManageProductTab();
		hp.clickListProductSearchButton();
		String actualResult = hp.verifyFirstSelectedOptionOfCategoryDropdownList(1);
		String expectedResult = "Grocery & Staples";
		Assert.assertEquals(actualResult, expectedResult, "First selected option does not match");
	}

	@Test
	public void verifySubCategoryListProductsDropdown() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		hp.clickManageProductTab();
		hp.clickListProductSearchButton();
		hp.verifyFirstSelectedOptionOfCategoryDropdownList(1);
		hp.clickSubCategoryDropdown();
		String actualResult = hp.verifySelectedOptionOfSubCategoryDropdownList("14");
		String expectedResult = "Atta & Flours";
		Assert.assertEquals(actualResult, expectedResult, "First selected option does not match");
	}

	@Test
	public void verifyFunctionalityOfLogOutButton() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickAdminButton();
		hp.clickLogoutOption();
		String actualResult = lp.URLAfterSignIn();
		String expectedResult = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void isSelectedVegProductTypeRadioButton() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickManageProductTab();
		hp.clickNewButton();
		boolean expectedResult = hp.isSelectedProductTypeRadioButton();
		boolean actualResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyTextonAlertExpenseCategoryWhenDeleteButtonClicked() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickManageExpenseDropdown();
		hp.clickExpenseCategory();
		hp.clickDeleteButton();
		String expectedResult = "Do you want to delete this Category?";
		String actualResult = hp.verifytextonalertofDeleteButton();
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyManageFooterTextDropdownValueIsSelected() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		hp = new HomePage(driver);
		hp.clickManageContentTile();
		hp.clickManageFooterTextRadioButton();
		String actualResult = hp.verifyclickManageFooterTextRadioButton();
		String expectedResult = "https://groceryapp.uniqassosiates.com/admin/list-footertext";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}
}
