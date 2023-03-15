package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LogintoApp;
import elementRepository.ManageExpenses;
import testcases.BaseClass;

public class ManageExpensesTC extends BaseClass {

	LogintoApp gp;
	ManageExpenses me;

	@Test
	public void getTheFontOfResetButton() {

		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		me = new ManageExpenses(driver);
		String actual = me.fontOfResetButton();
		String expected = "";
		Assert.assertEquals(actual, expected, Constant.ERRORGETTINGFONTCOLOR);

	}

	@Test
	public void weatherTheElementIsEnabledOrNot() {

		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		me = new ManageExpenses(driver);
		boolean result = me.elementIsEnabledOrNot();
		Assert.assertTrue(result, Constant.ERRORELEMENTISNOTPRESENT);

	}
	@Test
	public void clickOnPushMenu() {

		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		me = new ManageExpenses(driver);
		//boolean actual=me.clickPushMenu();
	}

	
}
