package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProduct {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Manage Product")
	WebElement ManageProduct;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement Newicon;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchElement;

	@FindBy(xpath = "//input[@name='un']")
	WebElement headertitlrElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> titlecolumnElements;

	@FindBy(xpath = "//label[@class='radio-inline']")
	WebElement vegbuttonElement;
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/list-page'])[1]")
	WebElement moreinfoElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-edit']")
	WebElement editbuttonElement;
	@FindBy(id = "main_imgzz")
	WebElement choosefile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatElement;

	@FindBy(id = "cat_id")
	WebElement catagorytab;

	public void clickInfo() {
		moreinfoElement.click();
	}

	public void clickEdit() {
		editbuttonElement.click();//dynamic table
	}

	public void clickChooseFile() {
		choosefile.click();
	}

	public void clickUpdate() {
		updatElement.click();

	}

	public boolean fileUploadImage() throws AWTException {
		return gu.fileUpload(driver,
				"System.getProperty(\"user.dir\")" + "src\\main\\resources\\UploadImage\\upload1.png",
				editbuttonElement);
	}

	public void clickManageProduct() {
		ManageProduct.click();
	}

	public void Newicons() {
		Newicon.click();
	}

	public void catagorytab() {
		catagorytab.click();
	}

	public String bgColourofNewButton() {
		// return Newicon.getCssValue("bckground-color");
		return gu.verifyStyleProperty(Newicon, "background-color");

	}

	public String fontfamilyStyleOfSearch() {
		return gu.verifyStyleProperty(searchElement, "font-family");
	}

	public String borderColourofNewButton() {

		return gu.verifyStyleProperty(ManageProduct, "border-color");

	}

	public boolean getTheListOfItemsWithValeRedMeat() {
		return gu.checkWeatherProductListedWhileSearch(titlecolumnElements, headertitlrElement, searchElement,
				"Red Meat");
	}

	public boolean vegIconselection() {
		return gu.verifyTheCheckboxSelection(vegbuttonElement);
	}

	public boolean toCheckThePresenceOfElement() {
		return gu.checkWeatherTheElementIsPresentOrNot(catagorytab);
	}

	public String selectCatagortyListOfproduct() {
		return gu.selectValueFromDropDown(catagorytab, "Grocery&Staples");
	}

	public String SearchMangoandDelete() {
		return gu.checkWeatherProductListedWhileSearchAndDelete(driver, titlecolumnElements, headertitlrElement,
				searchElement, "Mango", "Maaza Mango Drink");
	}
}
