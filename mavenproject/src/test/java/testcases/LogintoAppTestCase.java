package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import elementRepository.LogintoApp;
import utilities.ExcelRead;

public class LogintoAppTestCase extends BaseClass {

	LogintoApp gp;
	ExcelRead eRead;

	@Test
	public void verifyThetextelementofsigninbutton() throws IOException {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		String Actualresultofsigin = gp.verifyTheTextofSignin();
		eRead = new ExcelRead();
		System.out.println(eRead.readFromExcelFile(0, 0));
		String Expectedresultofsigin = eRead.readFromExcelFile(0, 0);
		Assert.assertEquals(Actualresultofsigin, Expectedresultofsigin, "sign in error");

	}

	@Test
	public void verifyCheckbox() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		gp.rememberMe();
		boolean actualResult = gp.rememberMeIsEnabled();
		boolean expectedResult = true;
		assertEquals(actualResult, expectedResult, "the check is failed");

	}
}
