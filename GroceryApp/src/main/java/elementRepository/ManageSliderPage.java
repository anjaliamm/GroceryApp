package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageSliderPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelRead er = new ExcelRead();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'])[1]")
	WebElement manageSliderPageTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="main_img")
	WebElement chooseFile;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageSuccesful;
	@FindBy(id="link")
	WebElement link;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	public void clickManageSliderPageTile() {
		manageSliderPageTile.click();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void clickChooseFile() {
		chooseFile.click();
	}
	public void imageUpload() throws AWTException {
		gu.fileUploadingElement(driver,chooseFile,System.getProperty("user.dir")+ "\\src\\main\\resources\\UploadFiles\\one.jpg");

	}
	public void enterLink(String httpslink ) {
		link.sendKeys(httpslink);
	}
	public void clickSubmitButton() {
		submitButton.click();
	}
	public String alertMessage() {
		return gu.getElementText(alertMessageSuccesful);
	}
}
