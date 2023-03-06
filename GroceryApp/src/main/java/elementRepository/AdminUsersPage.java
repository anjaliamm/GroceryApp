package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	WebElement adminUsersTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="username")
	WebElement enterusername;
	@FindBy(id="password")
	WebElement enterpassword;
	@FindBy(id="user_type")
	WebElement userTypeDropdown;
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alerMessage;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement usernameExistsAlert;

	public void clickAdminUsersTile() {
		adminUsersTile.click();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void enterUsernameInAdminUsers(String user) {
		enterusername.sendKeys(user);
	}
	public void enterPasswordInAdminUsers(String pass) {
		enterpassword.sendKeys(pass);
	}
	public String chooseUserTypeFromDropdown(String value) {
		return gu.selectElementValueFromDropdownUsingSelectByValue(userTypeDropdown, value);	
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public String alertMessageSuccessful() {
		return gu.getElementText(alerMessage);
		
	}
	public String usernameAlreadyExistsMessage() {
		return gu.getElementText(usernameExistsAlert);
	}
	
}
