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
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickLogin();
		pp = new PushNotificationsPage(driver);
		pp.clickNotificationsTab();
		pp.enterTitle("Hello This is Title");
		pp.enterDescription("This is description");
		pp.clickSendButton();
		String actualResult = pp.verifySuccessfulAlertMessage();
		String expectedResult = "×\n" + "Alert!\n" + "Message send successfully";
		Assert.assertEquals(actualResult, expectedResult, Constant.ASSERTMESSAGE);
	}

}
