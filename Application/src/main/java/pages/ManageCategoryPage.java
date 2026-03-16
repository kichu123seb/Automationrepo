package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;
import utilities.FileUploadUtilities;
import utilities.PageUtilities;

public class ManageCategoryPage {
	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	// pagefactory to find elements using @findby

	@FindBy(xpath = "//p[normalize-space()='Manage Category']/ancestor::div[contains(@class,'small-box')]")
	WebElement ManageCategory;
	@FindBy(xpath = "//p[normalize-space()='Manage Category']/ancestor::div[contains(@class,'small-box')]//a")
	WebElement manageinfomore;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement managenew;
	@FindBy(xpath = "//input[@name='category']")
	WebElement entercategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@type='file']")
	WebElement fileinput;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	
	

	public ManageCategoryPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public boolean isManageCategoryDisplayed() {
		return ManageCategory.isDisplayed();
	}

	public void moreinfo() {
		manageinfomore.click();
	}

	public void newbutton() {
		managenew.click();

	}

	public void enterCategory(String text) {
		entercategory.sendKeys(text);

	}

	public void discount() {
		discount.click();

	}

	public void fileInput() {
		FileUploadUtilities upload = new FileUploadUtilities();
		upload.fileUploaduUsingSendKeys(fileinput, Constant.FILEINPUT);

	}

	public void savebutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", save);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
