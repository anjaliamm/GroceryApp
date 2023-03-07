package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManagePages {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelRead er = new ExcelRead();
	ExplicitWait ew = new ExplicitWait();

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}

	@FindBy(xpath = "(//a[@href= 'https://groceryapp.uniqassosiates.com/admin/list-page'])[2]")
	WebElement managePagesTile;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//button[@aria-label='Style']")
	WebElement styleTooltip;
	@FindBy(xpath = "(//input[@type='file'])[2]")
	WebElement imgFile;
	@FindBy(id = "title")
	WebElement enterTitle;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement enterDescription;
	@FindBy(id = "page")
	WebElement enterPage;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageSuccessful;

	public void clickManagePagesTile() {
		managePagesTile.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public String verifyTooltipValueOfStyleInDescription(String value) {
		return gu.verifyElementToolTipValue(styleTooltip, value);
	}


}
