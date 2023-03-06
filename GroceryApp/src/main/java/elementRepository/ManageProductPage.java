package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	WebElement ManageProductTab;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(id = "purpose")
	WebElement weightRadioButton;
	@FindBy(id = "grp_id")
	WebElement GroupDropdown;
	@FindBy(id = "w_unit")
	WebElement weightUnitDropdown;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement unlimitedStockCheckbox;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchSecondButton;
	@FindBy(id="cat_id")
	WebElement category;
	@FindBy(id="sb")
    WebElement subCategory;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
	List<WebElement> tableCategory;
	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickSearchSecondButtonInList() {
		searchSecondButton.click();
	}
	public void selectCategory() {
		gu.selectElementValueFromDropdownUsingSelectByValue(category,"3");
	}
	public void selectSubCategory() {
		gu.selectElementValueFromDropdownUsingSelectByValue(subCategory,"18");
	}

	public void clickManageProductPage() {
		ManageProductTab.click();
	}

	public void clickNewButton() {
		NewButton.click();
	}

	public void clickWeightRadioButton() {
		weightRadioButton.click();
	}

	public boolean isSelectedradioButtonValueOfPriceType() {
		return gu.isSelectedElementRadioButton(weightRadioButton);
	}

	public void clickGroupDropdown() {
		GroupDropdown.click();
	}

	public String verifyGroupSelectedInDropdown(String value) {
		return gu.selectElementValueFromDropdownUsingSelectByValue(GroupDropdown, value);
	}

	public void clickWeightUnitDropdown() {
		weightUnitDropdown.click();
	}

	public String verifyWeightUnitSelectedInDropdown(int index) {
		return gu.selectElementValueFromDropdown(weightUnitDropdown, index);
	}

	public void clickUnlimitedStockCheckbox() {
		unlimitedStockCheckbox.click();
	}

	public boolean isCheckedUnlimitedStockCheckbox() {

		return gu.verifyElementisUnchecked(unlimitedStockCheckbox);

	}
	

}
