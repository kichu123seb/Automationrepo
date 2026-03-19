package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtilities;

public class ManageContactPage {
	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

	// pom with pagefactory
	// pagefactory to find elements using @findby

	@FindBy(xpath = "//p[normalize-space()='Manage Contact']/ancestor::div[contains(@class,'small-box')]")
	WebElement ManageContact;
	//@FindBy(xpath = "//p[normalize-space()='Manage Contact']/ancestor::div[contains(@class,'small-box')]//a")
	//WebElement managecontactinfomore;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement actionbutton;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement upadatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isManageContactDispalyed() {
		return ManageContact.isDisplayed();
	}

	/*public ManageContactPage ManageContactmoreInfo() {
		managecontactinfomore.click();
		return this;

	}*/

	public ManageContactPage actionButton() {
		actionbutton.click();
		return this;
	}

	public ManageContactPage updateEmail() {
		emailfield.clear();
		emailfield.sendKeys("kichu@123");
		return this;
	}

	public ManageContactPage upadte() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(upadatebutton));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upadatebutton);
		wait.until(ExpectedConditions.elementToBeClickable(upadatebutton)).click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
