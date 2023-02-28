package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class VerifyUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public VerifyUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}

	@FindBy(id = "st")
	WebElement status;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/verify-users']//i[@class='nav-icon fas fa-user-check']")
	WebElement VerifyUsersTile;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement name;
	@FindBy(id = "ut")
	WebElement email;
	@FindBy(id = "ph")
	WebElement phoneNumber;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement secondSearchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center")
	WebElement resultNotFoundAlertMessage;
	@FindBy(xpath = "//a[@type='button']")
	WebElement resetButton;

	public void clickVerifyUsersTile() {
		VerifyUsersTile.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickStatusDropdown() {
		status.click();
	}

	public String verifyActiveUserOption(String value) {
		return gu.selectElementValueFromDropdownUsingSelectByValue(status, value);

	}

	public void enterName(String usrname) {
		name.sendKeys(usrname);
	}

	public void enterEmail(String usremail) {
		email.sendKeys(usremail);
	}

	public void enterPhoneNumber(String num) {
		phoneNumber.sendKeys(num);
	}

	public void clickSecondSearchButtonOfVerifyUsers() {
		secondSearchButton.click();
	}

	public String alertResultNotFound() {
		return gu.getElementText(resultNotFoundAlertMessage);
	}

	public void clickResetButton() {
		resetButton.click();
	}

}
