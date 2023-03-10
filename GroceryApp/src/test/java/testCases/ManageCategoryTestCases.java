package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;
import utilities.RetryUtils;

public class ManageCategoryTestCases extends baseClass {
	LoginPage lp;
	ManageCategoryPage mc;

	@Test(retryAnalyzer=RetryUtils.class)
	public void verifyTheTextOfAlertWhileClickingDeleteButtonInSubCategoryTable() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		mc = new ManageCategoryPage(driver);
		mc.clickManageCategoryTab();
		mc.clickManageSubCategoryTab();
		String locator = mc.getLocatorToDelete();
		WebElement deleteButton = driver.findElement(By.xpath(locator));
		deleteButton.click();
		String actualResult = mc.verifyDeleteAlertText();
		String expectedResult =Constant.SUBCATEGORYDELETEMESSAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

	}
	
}
