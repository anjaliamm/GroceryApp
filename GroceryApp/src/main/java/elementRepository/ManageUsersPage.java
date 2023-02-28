package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageUsersPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelRead er = new ExcelRead();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'])[1]")
	WebElement manageUsersTile;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement name;
	@FindBy(id = "ut")
	WebElement email;
	@FindBy(id = "ph")
	WebElement phoneNumber;
	@FindBy(id = "st")
	WebElement statusDropdown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchButtonInSearchPage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center")
	WebElement resultNotFoundTable;

	public void clickManageUsersTile() {
		manageUsersTile.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void typeName(String nam) {
		name.sendKeys(nam);
	}

	public void typeEmail(String emai) {
		email.sendKeys(emai);
	}

	public void typePhoneNumber(String num) {
		phoneNumber.sendKeys(num);
	}

	public String verifyActiveStatusDropdown(String status) {
		return gu.selectElementValueFromDropdownUsingSelectByValue(statusDropdown, status);
	}

	public void clickSearchButtonInSearchPage() {
		searchButtonInSearchPage.click();
	}

	public String getResultNotFoundErrorMessage() {
		return gu.getElementText(resultNotFoundTable);
	}
}
