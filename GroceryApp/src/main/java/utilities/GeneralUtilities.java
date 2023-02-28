package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class GeneralUtilities {
	public String getElementText(WebElement element) {
		String text = element.getText(); // utility-reusable components kept in a common class.
		return text;
	}

	public boolean verifyElementisUnchecked(WebElement element) {

		boolean bl = element.isSelected(); // returns boolean value of checkbox if its selected true or false
		return bl;

	}

	public String selectElementValueFromDropdown(WebElement element, int i) {
		Select obj = new Select(element);
		obj.selectByIndex(i);
		WebElement selectedValue = obj.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;
	}

	public String verifyErrorMessageElementInvalidCredential(WebElement element) {
		String errorMessage = element.getText();
		return errorMessage;

	}

	public String selectElementValueFromDropdownUsingSelectByValue(WebElement element, String str) {
		Select obj = new Select(element);
		obj.selectByValue(str);
		WebElement selectedValue = obj.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;
	}

	public String getBackgroundColor(WebElement element) {
		String bgcolor = element.getCssValue("background-color");
		return bgcolor;
	}

	public String getCurrentURLofCurrentPage(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}

	public boolean isSelectedElementRadioButton(WebElement element) {
		boolean r1 = element.isSelected();
		return r1;
	}

	public String verifyTextOfAlertElement(WebDriver driver) {

		return driver.switchTo().alert().getText();
	}

	public void acceptAlertElement(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String verifyElementToolTipValue(WebElement element, String value) {
		String tool = element.getAttribute(value);
		return tool;

	}

	public void mouseHoverElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void fileUploadingElement(WebDriver driver, WebElement element, String filepath) throws AWTException {
		Robot file = new Robot();
		Actions obj1 = new Actions(driver);
		obj1.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		file.keyPress(KeyEvent.VK_CONTROL);
		file.keyPress(KeyEvent.VK_V);
		file.delay(250);
		file.keyRelease(KeyEvent.VK_CONTROL);
		file.keyRelease(KeyEvent.VK_V);
		file.delay(250);
		file.keyPress(KeyEvent.VK_ENTER);
		file.keyRelease(KeyEvent.VK_ENTER);

	}

	

	public boolean getTableColumnValue(List<WebElement> element, String text) {
		boolean value = true;
		for (int i = 0; i < element.size(); i++) {
			if (!element.get(i).getText().equals(text)) {
				value = false;
				break;
			}
		}
		return value;
	}

	public int getTableLocatorValue(List<WebElement> element, String text) {
		int index = 0;
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(text)) {
				index = i;
				break;
			}
		}
		return index;
	}
}
