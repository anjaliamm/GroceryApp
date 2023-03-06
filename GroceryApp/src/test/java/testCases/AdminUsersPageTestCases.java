package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersPageTestCases extends baseClass {
	LoginPage lp;
	AdminUsersPage au;
  @Test
  public void selectDropdownValueOfUserType() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  au.enterUsernameInAdminUsers("Vivek");
	  au.enterPasswordInAdminUsers("vivek1234");
	  String actualResult=au.chooseUserTypeFromDropdown("admin");
      String expectedResult="Admin";
      Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

  }
  @Test
  public void alertMessageSuccessfulWhenNewUserIsAdded() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  au.enterUsernameInAdminUsers("Sheeba");
	  au.enterPasswordInAdminUsers("sheeba1234");
	  au.chooseUserTypeFromDropdown("admin");
	  au.clickSaveButton();
	  String actualResult=au.alertMessageSuccessful();
	  String expectedResult="×\n"
				+ "Alert!\n"
				+ "User Created Successfully";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
  }
  @Test
  public void usernameAlreadyExists() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  au.enterUsernameInAdminUsers("Vivek");
	  au.enterPasswordInAdminUsers("Vivek1234");
	  au.chooseUserTypeFromDropdown("admin");
	  au.clickSaveButton();
	  String actualResult=au.usernameAlreadyExistsMessage();
	  String expectedResult="×\n"
				+ "Alert!\n"
				+ "Username already exists.";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
  }
  
}
