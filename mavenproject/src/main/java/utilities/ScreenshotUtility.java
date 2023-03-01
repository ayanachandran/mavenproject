package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.IIOException;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v107.input.model.DragData;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void captureFailedScreenshot(WebDriver driver, String name) throws IOException {
		// interface and method for screenshot capture
		TakesScreenshot scrshot = (TakesScreenshot) driver; // TakesScreenshot is an interface
		File screenshot = scrshot.getScreenshotAs(OutputType.FILE); // screenshot wi store in temporary file path

		File f1 = new File(System.getProperty("user.dir") + "\\OutputsScreenshots"); // generating folder using java

		if (!f1.exists()) {
			f1.mkdirs(); // mkdir..>will create folder using java

		}

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); // capture date and time

		File finalDestnation = new File(
				System.getProperty("user.dir") + "\\OutputsScreenshots\\" + name + "_" + timeStamp + ".png");
		FileHandler.copy(screenshot, finalDestnation); // copy screenshot from temp to project folder
	}
}