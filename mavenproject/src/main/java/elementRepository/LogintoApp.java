package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LogintoApp {

	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public LogintoApp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Signinbutton;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(linkText = "Remember Me")
	WebElement remembermeElement;

	public void rememberMe() {
		remembermeElement.click();
	}

	public String verifyTheTextofSignin() {
		return gu.verifyTheTextofelements(Signinbutton);

	}

	public void loginConsole(String name, String pass) {
		// gu.loginToApplication(username, password, Signinbutton, name,pass);
		username.sendKeys(name);
		password.sendKeys(pass);
		Signinbutton.click();
	}

	public boolean rememberMeIsEnabled() {
		return gu.RememberMeCheckboxselectionenableornot(remembermeElement);
	}

}
