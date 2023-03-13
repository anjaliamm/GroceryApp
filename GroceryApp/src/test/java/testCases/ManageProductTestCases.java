package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductTestCases extends baseClass {
	LoginPage lp;
	ManageProductPage mpp;

	@Test
	public void verifyWeightRadioButtonSelectedInPriceType() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mpp = new ManageProductPage(driver);
		mpp.clickManageProductPage();
		mpp.clickNewButton();
		mpp.clickWeightRadioButton();
		boolean actualResult = mpp.isSelectedradioButtonValueOfPriceType();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyGroupSelectedInDropdown() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mpp = new ManageProductPage(driver);
		mpp.clickManageProductPage();
		mpp.clickNewButton();
		mpp.clickGroupDropdown();
		String actualResult = mpp.verifyGroupSelectedInDropdown(Constant.GROUPSELECTED);
		String expectedResult =Constant.GROUPSELECTEDINWORDS;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyWeightUnitSelectedInDropdown() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mpp = new ManageProductPage(driver);
		mpp.clickManageProductPage();
		mpp.clickNewButton();
		mpp.clickWeightUnitDropdown();
		String actualResult = mpp.verifyWeightUnitSelectedInDropdown(2);
		String expectedResult =Constant.KILOGRAMS;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyUnlimitedStockCheckboxisSelected() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mpp = new ManageProductPage(driver);
		mpp.clickManageProductPage();
		mpp.clickNewButton();
		boolean actualResult = mpp.isCheckedUnlimitedStockCheckbox();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}
    

}
