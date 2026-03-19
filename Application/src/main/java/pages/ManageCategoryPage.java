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
	//@FindBy(xpath = "//p[normalize-space()='Manage Category']/ancestor::div[contains(@class,'small-box')]//a")
	//WebElement managecategoryinfomore;
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

	/*public ManageCategoryPage ManageCategorymoreinfo() {
		managecategoryinfomore.click();
		return this;
	}*/

	public ManageCategoryPage newbutton() {
		managenew.click();
		return this;

	}

	public ManageCategoryPage enterCategory(String text) {
		entercategory.sendKeys(text);
		return this;

	}

	public ManageCategoryPage discount() {
		discount.click();
		return this;

	}

	public ManageCategoryPage fileInput() {
		FileUploadUtilities upload = new FileUploadUtilities();
		upload.fileUploaduUsingSendKeys(fileinput, Constant.FILEINPUT);
		return this;

	}

	public ManageCategoryPage savebutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", save);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(alert));
	        return alert.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

}
