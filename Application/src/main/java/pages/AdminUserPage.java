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

public class AdminUserPage {

	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	// pagefactory to find elements using @findby

	@FindBy(xpath = "//p[normalize-space()='Admin Users']/ancestor::div[@class='small-box bg-info']")
	WebElement AdminUsers;
	//@FindBy(xpath = "//p[normalize-space()='Admin Users']/ancestor::div[contains(@class,'small-box')]//a")
	//WebElement adminmoreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement adminnewbutton;
	@FindBy(xpath = "//input[@id=\"username\"]")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordfield;
	@FindBy(xpath = "//select[@id=\"user_type\"]")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAdminUserDisplayed() {
		return AdminUsers.isDisplayed();
	}

	/*public AdminUserPage AdminMoreInfo() {
		adminmoreinfo.click();
		return this;
	}*/

	public AdminUserPage NewButton() {
		adminnewbutton.click();
		return this;

	}

	public AdminUserPage EnterText(String text) {
		usernamefield.sendKeys(text);
		return this;
	}

	public AdminUserPage EnterText1(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public AdminUserPage selectUserType(int userType2) {
	    PageUtilities.selectByIndex(usertype, userType2);
	    return this;
	}

	public AdminUserPage SaveButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", save);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		return this;

	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
