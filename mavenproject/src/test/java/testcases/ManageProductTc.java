package testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LogintoApp;
import elementRepository.ManageProduct;
import testcases.BaseClass;

public class ManageProductTc extends BaseClass {

	ManageProduct mp;
	LogintoApp gp;

	@Test
	public void verifyBgColorofNewicon() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actualResult = mp.bgColourofNewButton();
		String expectedResult = "rgba(220, 53, 69, 1)";
		assertEquals(actualResult, expectedResult, Constant.ERRORMISMATCHBACKGROUNDCOLOUR);

	}

	@Test
	public void verifyTheBrderColorofNewicon() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actualResult = mp.bgColourofNewButton();
		String expectedResult = "rgba(220, 53, 69, 1)";
		assertEquals(actualResult, expectedResult, Constant.ERRORMISMATCHBORDERCOLOUR);

	}

	@Test
	public void getTheListOfItemsWithValeRedMeatInList() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		boolean actualresult = mp.getTheListOfItemsWithValeRedMeat();
		Assert.assertTrue(actualresult, Constant.ERRORGETTINGVALUEFROMLIST);

	}

	public void verifyTheVegButtonIsSelected()

	{
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		mp.Newicons();
		boolean actualString = mp.vegIconselection();
		Assert.assertTrue(actualString, Constant.ERRORONCHECKINGCHECKBOX);

	}

	@Test
	public void verifyFileUpload() throws AWTException {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		mp.clickInfo();
		mp.clickEdit();
		mp.clickChooseFile();
		mp.fileUploadImage();
		mp.clickUpdate();
		boolean actual = mp.fileUploadImage();
		Assert.assertTrue(actual, Constant.ERRORONFILEUPLOAD);

	}

	@Test
	public void tocheckWeatherTheElementIsPresentOrNot()

	{
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		boolean actual = mp.toCheckThePresenceOfElement();
		boolean expeccted = true;
		Assert.assertEquals(actual, expeccted, Constant.ERRORONELEMENTISPRESENT);
	}

	@Test
	public void selectCatagortyListOfproductnManage() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actual = mp.selectCatagortyListOfproduct();
		String expected = "Grocery&Staples";
		Assert.assertEquals(actual, expected, Constant.ERRORONCATAGORYSELECTION);

	}

	@Test
	public void getTheListOfItemsWithValueMangoAndDelete() {
		gp = new LogintoApp(driver);
		gp.loginConsole(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProduct(driver);
		mp.clickManageProduct();
		String actualresult = mp.SearchMangoandDelete();
		String expected = "value deleted";
		Assert.assertEquals(actualresult, expected, Constant.ERRORONCATAGORYSELECTIONANDDELETE);
	}
}
