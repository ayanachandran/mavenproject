package utilities;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.Flow.Publisher;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class GeneralUtilities {

	public String verifyTheTextofelements(WebElement elements) {
		String text = elements.getText();
		return text;

	}

	public void loginToApplication(WebElement userName, WebElement Password, WebElement Signinbutton, String name,
			String pass) {
		userName.sendKeys(name);
		Signinbutton.click();
	}

	public String verifyStyleProperty(WebElement elements, String Propertyvalue) {
		String colour = elements.getCssValue(Propertyvalue);

		return colour;

	}

	public String verifyTagofAnyTab(WebElement elements) {
		String tagname = elements.getTagName();
		return tagname;

	}

	public String addNewExpenseInExpenseCatagory(WebElement element, WebElement element1, WebElement element2,
			String value) {
		element.sendKeys(value);
		element2.click();
		String text = element2.getText();
		return text;
	}

	public boolean isElementEnabled(WebElement element) {
		boolean result = element.isEnabled();
		return result;
	}

	public String verifyTitleOfTab(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	public boolean RememberMeCheckboxselectionenableornot(WebElement element) {
		boolean result = element.isSelected();
		return result;
	}

	public String selectValueFromDropDown(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByValue(value);
		WebElement dropdown = obj.getFirstSelectedOption();
		String text = dropdown.getText();
		return text;

	}

	public String addUsersToAdmnTab(WebElement element1, WebElement element2, WebElement usertype, WebElement searchtab,
			String value, WebElement alert) {
		element1.sendKeys(value);
		element2.sendKeys(value);
		selectValueFromDropDown(usertype, value);
		searchtab.click();
		String alerttext = alert.getText();
		return alerttext;
	}

	public boolean verifyTheCheckboxSelection(WebElement element) {
		boolean radiobuttonisselected = element.isSelected();
		return radiobuttonisselected;

	}

	public boolean checkWeatherProductListedWhileSearch(List<WebElement> list, WebElement title, WebElement searcbox,
			String text) {
		boolean result = true;
		for (int k = 0; k < list.size(); k++) {
			String listedlement = list.get(k).getText();
			if (listedlement.contains(text))

			{
				result = false;
			}

		}
		return result;

	}

	public boolean fileUpload(WebDriver driver, String filepath, WebElement element) throws AWTException {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot obj = new Robot();
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.delay(250);
		obj.keyPress(KeyEvent.VK_V);
		obj.keyRelease(KeyEvent.VK_V);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
		return false;

	}

	public boolean checkWeatherTheElementIsPresentOrNot(WebElement element) {
		boolean result = element.isDisplayed();
		return result;

	}

	public String checkWeatherProductListedWhileSearchAndDelete(WebDriver driver, List<WebElement> list1,
			WebElement element1, WebElement element2, String searchvalue, String enteredvalue) {
		element1.sendKeys(searchvalue);
		element2.click();
		String locator = null;
		for (int i = 0; i < list1.size(); i++) {
			String text = list1.get(i).getText();
			if (text.contains(enteredvalue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\" + (i+1) + \"]//td[9]//a[2]";
				break;
			}
		}
		WebElement deleteutton = driver.findElement(By.xpath(locator));
		deleteutton.click();
		String alert = driver.switchTo().alert().getText();
		return alert;
	}

	public String getTheCurrentPageUrl(WebDriver driver) {
		String currentpageurl = driver.getCurrentUrl();
		return currentpageurl;
	}

	public void clickButton(WebElement element) {
		element.click();
	}

	public String getTheLoggedUser(WebElement element) {
		String textString = element.getText();
		return textString;

	}

	public String ScrollPage(WebDriver driver, WebElement pagetobescrolled) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,1000)");
		String result = pagetobescrolled.getText();
		return result;

	}

	public boolean getStatusOfTheAddedUserInTheUserTab(WebDriver driver, List<WebElement> list2,
			WebElement usernameelElement, String searchvalue, WebElement subsearchbutton) {

		usernameelElement.click();
		usernameelElement.sendKeys(searchvalue);
		subsearchbutton.click();
		boolean result1 = false;
		for (int i = 0; i < list2.size(); i++) {

			String searchname = list2.get(i).getText();
			if (searchname.contains(searchvalue))
				;
			{

				result1 = true;
				break;
			}

		}
		return result1;

	}
}
