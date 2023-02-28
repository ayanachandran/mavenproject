package utilities;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

//public void loginToApplication(WebElement userName, WebElement Password,WebElement Signinbutton,String name, String pass) {
//	
//		userName.sendKeys(name);
//		Password.sendKeys(pass);
//		Signinbutton.click();
//		 
//	}

	public String verifyStyleProperty(WebElement elements, String Propertyvalue) {
		String colour = elements.getCssValue(Propertyvalue);

		return colour;

	}

	public String verifyTagofAnyTab(WebElement elements) {
		String tagname = elements.getTagName();
		return tagname;

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
}
