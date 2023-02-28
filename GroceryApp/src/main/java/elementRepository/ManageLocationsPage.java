package elementRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageLocationsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelRead er = new ExcelRead();

	public ManageLocationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	WebElement manageLocationsPage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(id = "country_id")
	WebElement countryDropdown;
	@FindBy(id = "st_id")
	WebElement stateDropdown;
	@FindBy(id = "location")
	WebElement location;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix align-center']")
	WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center")
	WebElement listTable;

	public void clickManageLocationsPage() {
		manageLocationsPage.click();
	}

	public void clickSearchButton() {
		search.click();
	}

	public void clickCountryDropdown() {
		countryDropdown.click();
	}

	public String verifyUnitedKingdomIsSelected(String str) {
		return gu.selectElementValueFromDropdownUsingSelectByValue(countryDropdown, str);
	}

	public void clickStateDropdown() {
		stateDropdown.click();
	}

	public String verifyStateDropdownIsSelected(String value) {
		return gu.selectElementValueFromDropdownUsingSelectByValue(stateDropdown, value);

	}

	public void enterLocation(String locator) {
		location.sendKeys(locator);
	}

	public void clickSearchButtonInSearchPage() {
		searchButton.click();
	}

	public String verifyResultNotFoundMessage() {
		return gu.getElementText(listTable);
	}

}
