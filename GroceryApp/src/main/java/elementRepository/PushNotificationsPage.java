package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}

	@FindBy(name = "titlep")
	WebElement titleTooltip;
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//li[7]//a[1]")
	WebElement pushNotifications;
	@FindBy(id = "title")
	WebElement title;
	@FindBy(id = "description")
	WebElement description;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetButton;

	public void clickNotificationsTab() {
		pushNotifications.click();
	}

	public String verifyTitleToolTipValue(String str) {
		return gu.verifyElementToolTipValue(titleTooltip, str);
	}

	public void enterTitle(String titl) {
		title.sendKeys(titl);
	}

	public void enterDescription(String des) {
		description.sendKeys(des);
	}

	public void clickSendButton() {
		sendButton.click();
	}

	public void clickResetButton() {
		resetButton.click();
	}

	public String verifySuccessfulAlertMessage() {
		return gu.getElementText(alertMessage);
	}
}
