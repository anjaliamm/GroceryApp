package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.PushNotificationsPage;

public class PushNotificationTestCases extends baseClass {
	LoginPage lp;
	HomePage hp;
	PushNotificationsPage pp;

	@Test
	public void verifyAlertMessageSuccesssful() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.USERNAME);
		lp.enterPassword(prop.getProperty("Password"));
		lp.clickLogin();
		pp = new PushNotificationsPage(driver);
		pp.clickNotificationsTab();
		pp.enterTitle(Constant.TITLE);
		pp.enterDescription(Constant.DESCRIPTION);
		pp.clickSendButton();
		String actualResult = pp.verifySuccessfulAlertMessage();
		String expectedResult =Constant.MESSAGESENTSUCCESSFULLY;
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
