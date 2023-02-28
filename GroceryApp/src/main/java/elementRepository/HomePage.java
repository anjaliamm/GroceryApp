package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement AdminButton;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement LogoutOption;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement ManageExpensedropdown;
	@FindBy(xpath = "//ul[@class='nav nav-treeview']//li//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement firstOption;
	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement ManageProductTab;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement ListProductSearchButton;
	@FindBy(id = "cat_id")
	WebElement CategoryDropdown;
	@FindBy(id = "sb")
	WebElement subCategoryDropdown;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")
	WebElement NewButton;
	@FindBy(xpath = "//input[@value='Veg']")
	WebElement ProductTypeRadioButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Expense/cat_delete?del=765&page_ad=1']")
	WebElement deleteButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement titleExpenseCategoryNamesLocator;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement ManageContentTile;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	WebElement ManageFooterTextRadioButton;

	public void clickAdminButton() {
		AdminButton.click();
	}

	public void clickLogoutOption() {
		LogoutOption.click();
	}

	public void verifyLogoutFunction() {
		gu.getCurrentURLofCurrentPage(driver);
	}

	public void clickManageExpenseDropdown() {
		ManageExpensedropdown.click();
	}

	public void clickExpenseCategory() {
		firstOption.click();
	}

	public String verifyFirstSelectedOptionFromManageExpensesDropdown(int value) {

		return gu.selectElementValueFromDropdown(ManageExpensedropdown, value);
	}

	public void clickManageProductTab() {
		ManageProductTab.click();
	}

	public void clickListProductSearchButton() {
		ListProductSearchButton.click();
	}

	public String verifyFirstSelectedOptionOfCategoryDropdownList(int number) {
		CategoryDropdown.click();
		return gu.selectElementValueFromDropdown(CategoryDropdown, number);

	}

	public void clickSubCategoryDropdown() {
		subCategoryDropdown.click();
	}

	public String verifySelectedOptionOfSubCategoryDropdownList(String str1) {

		return gu.selectElementValueFromDropdownUsingSelectByValue(subCategoryDropdown, str1);
	}

	public void clickNewButton() {
		NewButton.click();
	}

	public boolean isSelectedProductTypeRadioButton() {
		ProductTypeRadioButton.click();
		return gu.isSelectedElementRadioButton(ProductTypeRadioButton);

	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public String verifytextonalertofDeleteButton() {
		return gu.verifyTextOfAlertElement(driver);

	}

	public void clickManageContentTile() {
		ManageContentTile.click();
	}

	public void clickManageFooterTextRadioButton() {
		ManageFooterTextRadioButton.click();
	}

	public String verifyclickManageFooterTextRadioButton() {

		return gu.getCurrentURLofCurrentPage(driver);

	}

}
