package testcases;

import java.io.IOException;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class BaseClass {
	ScreenshotUtility scr;
	WebDriver driver;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();// create object for properties
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
		prop.load(ip);//
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		testBasic();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE)
			;
		{
			scr = new ScreenshotUtility();
			scr.captureFailedScreenshot(driver, itestresult.getName());
		}
		driver.close();

	}
}
