package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LogintoApp;

public class HomePageTc extends BaseClass {

	LogintoApp gp;
	HomePage hp;

	@Test
	public void gettitleofManageSlider() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		hp = new HomePage(driver);
		String actualResult = hp.titleOfNotify();
		String expectResult = "Push Notifications";
		assertEquals(actualResult, expectResult, "title is not as expected");
	}

	@Test
	public void verifytagNameofUserTag() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		hp = new HomePage(driver);
		hp.tagofVerifyUser();
		String actualResult = hp.TagNameofVerifyUserTab();
		String expectedResult = "a";
		Assert.assertEquals(actualResult, expectedResult, "Tags are invalid");
	}

	@Test
	public void verifyTheCurrentUrl() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		hp = new HomePage(driver);
		String actualResult = hp.getTheCurrentUrl();
		String expectedResult = "";
		Assert.assertEquals(actualResult, expectedResult, "URL is not expected");
	}

	@Test
	public void verifyTheLogout() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		hp = new HomePage(driver);
		String actualResult = hp.logoutFromTheApplication();
		String expectedResult = "Login | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, "Logout activity gets failed");
	}
}
