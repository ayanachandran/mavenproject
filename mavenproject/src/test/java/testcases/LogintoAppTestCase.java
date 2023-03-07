package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LogintoApp;
import utilities.ExcelRead; 
import testcases.BaseClass;

public class LogintoAppTestCase extends BaseClass {

	LogintoApp gp;
	ExcelRead eRead;

	@Test
	public void verifyThetextelementofsigninbutton() throws IOException {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		String Actualresultofsigin = gp.verifyTheTextofSignin();
		eRead = new ExcelRead();
		System.out.println(eRead.readFromExcelFile(0, 0));
		String Expectedresultofsigin = eRead.readFromExcelFile(0, 0);
		Assert.assertEquals(Actualresultofsigin, Expectedresultofsigin, Constant.ERRORINSIGNTEXT);

	}

	@Test
	public void verifyCheckbox() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		gp.rememberMe();
		boolean actualResult = gp.rememberMeIsEnabled();
		eRead = new ExcelRead();
		boolean expectedResult = true;
		assertEquals(actualResult, expectedResult, Constant.ERRORONCHECKINGCHECKBOX);

	}

	@Test(dataProvider = "data-provider")
	public void MultpleUsersLogin(String username, String password) {
		gp = new LogintoApp(driver);
		gp.loginConsole(username, password);
		String actual = gp.ReadLoggedUser();
		String expected = "admin";
		Assert.assertEquals(actual, expected, Constant.ERRORINMULTIPLEUSERLOGIN);

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "admin" }, { "user2233", "user2233" }, { "user2211", "user2211" } };
	}
}
