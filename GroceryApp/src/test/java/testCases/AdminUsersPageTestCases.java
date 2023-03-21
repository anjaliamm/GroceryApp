package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersPageTestCases extends baseClass {
	LoginPage lp;
	AdminUsersPage au;
	
 @Test(groups="Sanity")
  public void selectDropdownValueOfUserType() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  au.enterUsername(Constant.USERNAMEENTEREDINADMINUSERS);
	  au.enterPasswordInAdminUsers(Constant.PASSWORDENTEREDINADMINUSERS);
	  String actualResult=au.chooseUserTypeFromDropdown(Constant.USERNAME);
      String expectedResult=Constant.USERNAMEINCAPS;
      Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);

  }
  @Test(groups="Regression")
  public void alertMessageSuccessfulWhenNewUserIsAdded() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  au.enterUsernameInAdminUsers(Constant.NEWADMINUSER);
	  au.enterPasswordInAdminUsers(Constant.NEWADMINPASS);
	  au.chooseUserTypeFromDropdown(Constant.USERNAME);
	  au.clickSaveButton();
	  boolean actualResult=au.alertMessageSuccessfulWhenNewUserIsAdded(Constant.USERCREATEDSUCCESSFULMESSAGE);
	  Assert.assertTrue(actualResult, Constant.ASSERTMESSAGE);
  }
  @Test(groups="Sanity")
  public void usernameAlreadyExists() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  au.enterUsername(Constant.USERNAMEENTEREDINADMINUSERS);
	  au.enterPasswordInAdminUsers(Constant.PASSWORDENTEREDINADMINUSERS);
	  au.chooseUserTypeFromDropdown(Constant.USERNAME);
	  au.clickSaveButton();
	  boolean actualResult=au.usernameAlreadyExistsMessage(Constant.USERNAMEEXISTSMESSAGE);
	  Assert.assertTrue(actualResult, Constant.ASSERTMESSAGE);
  }
  @Test(groups="Regression")
  public void getBackgroundColourOfNewButton() {
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.USERNAME);
	  lp.enterPassword(prop.getProperty("Password"));
	  lp.clickLogin();
	  au=new AdminUsersPage(driver);
	  au.clickAdminUsersTile();
	  au.clickNewButton();
	  String actualResult =au.verifyBackgroundColorOfNewButtonInAdminUsersPage();
	  String expectedResult =Constant.COLOURCODING;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
  }
  
}
