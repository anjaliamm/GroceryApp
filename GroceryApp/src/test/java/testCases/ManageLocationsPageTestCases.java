package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocationsPage;

public class ManageLocationsPageTestCases extends baseClass {
	LoginPage lp;
	ManageLocationsPage mlp;

	@Test
	public void verifyCountryDropdownIsSelected() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickCountryDropdown();
		String actualResult = mlp.verifyUnitedKingdomIsSelected(Constant.VALUEOFUK);
		String expectedResult =Constant.UK;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyStateDropdownIsSelected() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickStateDropdown();
		String actualResult = mlp.verifyStateDropdownIsSelected(Constant.VALUEOFSTATEDROPDOWN);
		String expectedResult =Constant.CAMBRIDGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

	@Test
	public void verifyTableIsShownWithResults() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickCountryDropdown();
		mlp.verifyUnitedKingdomIsSelected(Constant.VALUEOFUK);
		mlp.clickStateDropdown();
		mlp.verifyStateDropdownIsSelected(Constant.VALUEOFSTATEDROPDOWN);
		mlp.enterLocation(Constant.CAMBRIDGEUNIVERSITY);
		mlp.clickSearchButtonInSearchPage();
	}

	@Test
	public void verifyNoResultsMessageShownWhenInvalidSearchIsDone() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickCountryDropdown();
		mlp.verifyUnitedKingdomIsSelected(Constant.VALUEOFUK);
		mlp.clickStateDropdown();
		mlp.verifyStateDropdownIsSelected(Constant.VALUEOFSTATEDROPDOWN);
		mlp.enterLocation(Constant.LOCATION);
		mlp.clickSearchButtonInSearchPage();
		String actualResult = mlp.verifyResultNotFoundMessage();
		String expectedResult =Constant.RESULTNOTFOUNDMESSAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
