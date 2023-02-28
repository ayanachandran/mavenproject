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

	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement loggedadmin;

	@FindBy(linkText = "Logout")
	WebElement logoutbutton;

	@FindBy(linkText = "Push Notifications")
	WebDriver Pushnotification;

	@FindBy(linkText = "Admin")
	WebElement admintab;

	public void tagofVerifyUser() {
		admintab.click();
	}

	public String titleOfNotify() {
		return gu.verifyTitleOfTab(Pushnotification);
	}

	public String TagNameofVerifyUserTab() {
		return gu.verifyTagofAnyTab(admintab);
	}

	public String getTheCurrentUrl() {
		return gu.getTheCurrentPageUrl(Pushnotification);

	}
	public String logoutFromTheApplication()
	{
		gu.clickButton(loggedadmin);
		gu.clickButton(logoutbutton);
		return gu.verifyTitleOfTab(driver);
	}

}
