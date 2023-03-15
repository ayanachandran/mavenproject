package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browsername) throws IOException {
		testBasic();
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();

			// driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			driver.get(prop.getProperty("BaseURL"));
			driver.manage().window().maximize();
		}
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
