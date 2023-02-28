package elementRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageCategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelRead er = new ExcelRead();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//li[12]//a[1]//i[@class='nav-icon fas fa-list-alt']")
	WebElement managecategorytab;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[1]")
	WebElement subcategoryoption;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> listSubCategory;
   

	public void clickManageCategoryTab() {
		managecategorytab.click();
	}

	public void clickManageSubCategoryTab() {
		subcategoryoption.click();
	}
	

	public String getLocatorToDelete() {
		int index = gu.getTableLocatorValue(listSubCategory, "abcd");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tr[" + (index + 1)
				+ "]//td[5]//a[2]";
		return locator;
	}

	public String verifyDeleteAlertText() {
		return gu.verifyTextOfAlertElement(driver);

	}
	
}
