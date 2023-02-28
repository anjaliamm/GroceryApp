package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelRead er = new ExcelRead();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// points to current driver class variables,static method

	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//div[@class='icheck-dark']//input")
	WebElement rememberMeCheckbox;
	@FindBy(xpath = "//input[@type='text']")
	WebElement username;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
    WebElement title;
	public String getTextOfSignInButton() {
		// String text=signInButton.getText(); //utility-reusable components kept in a
		// common class.to get reusability
		// return text;
		return gu.getElementText(signInButton);

	}

	public boolean verifythecheckboxisunselected() {

		return gu.verifyElementisUnchecked(rememberMeCheckbox);

	}

	public void enterUsername(String usrname) {
		username.sendKeys(usrname);
	}

	public void enterPassword(String psd) {
		password.sendKeys(psd);
	}

	public void clickLogin() {
		signInButton.click();
	}

	public String verifyInvalidUsernamePasswordErrorMessage() {
		return gu.verifyErrorMessageElementInvalidCredential(alertMessage);
	}

	public String verifyTheBackgroundColorOfSignInButtonInLoginPage() {
		return gu.getBackgroundColor(signInButton);
	}

	public String URLAfterSignIn() {
		return gu.getCurrentURLofCurrentPage(driver);

	}

	public void performLogin(String uname, String pwd) {
		enterUsername(uname);
		enterPassword(pwd);
		clickLogin();
	}

	public String getTitleOfPage() {
		return gu.getElementText(title);
	}
}
