package testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LogintoApp;
import elementRepository.ManageProduct;

public class ManageProductTc extends BaseClass {

	ManageProduct mp;
	LogintoApp gp;

	@Test
	public void verifyBgColorofNewicon() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actualResult = mp.bgColourofNewButton();
		String expectedResult = "rgba(220, 53, 69, 1)";
		assertEquals(actualResult, expectedResult, "not expected bg color");

	}

	@Test
	public void verifyTheBrderColorofNewicon() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actualResult = mp.bgColourofNewButton();
		String expectedResult = "rgba(220, 53, 69, 1)";
		assertEquals(actualResult, expectedResult, "not expected border color");

	}

	@Test
	public void getTheListOfItemsWithValeRedMeatInList() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		boolean actualresult = mp.getTheListOfItemsWithValeRedMeat();
		Assert.assertTrue(actualresult, "error");

	}

	public void verifyTheVegButtonIsSelected()

	{
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		mp.Newicons();
		boolean actualString = mp.vegIconselection();
		Assert.assertTrue(actualString, "the returned string is not expected");

	}

	@Test
	public void verifyFileUpload() throws AWTException {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		mp.clickInfo();
		mp.clickEdit();
		mp.clickChooseFile();
		mp.fileUploadImage();
		mp.clickUpdate();
		boolean actual = mp.fileUploadImage();
		Assert.assertTrue(actual, "file upload failed");

	}

	@Test
	public void tocheckWeatherTheElementIsPresentOrNot()

	{
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		boolean actual = mp.toCheckThePresenceOfElement();
		boolean expeccted = true;
		Assert.assertEquals(actual, expeccted, "element is not present");
	}

	@Test
	public void fselectCatagortyListOfproductnManage() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actual = mp.selectCatagortyListOfproduct();
		String expected = "Grocery&Staples";
		Assert.assertEquals(actual, expected, "The catagory tab is not selected");

	}

	@Test
	public void getTheListOfItemsWithValueMangoAndDelete() {
		gp = new LogintoApp(driver);
		gp.loginConsole("admin", "admin");
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actualresult = mp.SearchMangoandDelete();
		String expected = "value deleted";
		Assert.assertEquals(actualresult, expected, "unable to delte value");
	}
}
