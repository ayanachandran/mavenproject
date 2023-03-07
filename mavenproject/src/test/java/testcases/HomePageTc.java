package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogintoApp;
import testcases.BaseClass;

public class HomePageTc extends BaseClass {

	LogintoApp gp;
	HomePage hp;

	@Test(groups = { "High", "Critical" }, priority = 1)
	public void gettitleofManageSlider() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		hp = new HomePage(driver);
		String actualResult = hp.titleOfNotify();
		String expectResult = "Push Notifications";
		assertEquals(actualResult, expectResult, Constant.ERRORONGETTINGPAGETITLE);
	}

	@Test(groups = { "High" }, priority = 2)
	public void verifytagNameofUserTag() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		hp = new HomePage(driver);
		hp.tagofVerifyUser();
		String actualResult = hp.TagNameofVerifyUserTab();
		String expectedResult = "a";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORGETTINGPAGETAG);
	}

	@Test
	public void pageScrollOfAnyTab() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		hp = new HomePage(driver);
		String actualResult = hp.pageScroll();
		String expectedResult = "Admin";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORONPAGESCROLL);
	}

	@Test
	public void verifyTheCurrentUrl() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		hp = new HomePage(driver);
		String actualResult = hp.getTheCurrentUrl();
		String expectedResult = "";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORURLMISMATCH);
	}

	@Test
	public void verifyTheLogout() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		hp = new HomePage(driver);
		String actualResult = hp.logoutFromTheApplication();
		String expectedResult = "Login | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORFAILEDUSERLOGOUT);
	}
}
