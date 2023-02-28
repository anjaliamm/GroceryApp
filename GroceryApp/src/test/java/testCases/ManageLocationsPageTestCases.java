package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocationsPage;
import utilities.ExcelRead;

public class ManageLocationsPageTestCases extends baseClass {
	LoginPage lp;
	ManageLocationsPage mlp;

	@Test
	public void verifyCountryDropdownIsSelected() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickCountryDropdown();
		String actualResult = mlp.verifyUnitedKingdomIsSelected("230");
		String expectedResult = "United Kingdom";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

	@Test
	public void verifyStateDropdownIsSelected() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickStateDropdown();
		String actualResult = mlp.verifyStateDropdownIsSelected("3817");
		String expectedResult = "Cambridge";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}

	@Test
	public void verifyTableIsShownWithResults() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickCountryDropdown();
		mlp.verifyUnitedKingdomIsSelected("230");
		mlp.clickStateDropdown();
		mlp.verifyStateDropdownIsSelected("3817");
		mlp.enterLocation("Cambridge University");
		mlp.clickSearchButtonInSearchPage();
	}

	@Test
	public void verifyNoResultsMessageShownWhenInvalidSearchIsDone() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickLogin();
		mlp.clickManageLocationsPage();
		mlp.clickSearchButton();
		mlp.clickCountryDropdown();
		mlp.verifyUnitedKingdomIsSelected("230");
		mlp.clickStateDropdown();
		mlp.verifyStateDropdownIsSelected("3817");
		mlp.enterLocation("Bangladesh");
		mlp.clickSearchButtonInSearchPage();
		String actualResult = mlp.verifyResultNotFoundMessage();
		String expectedResult = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
