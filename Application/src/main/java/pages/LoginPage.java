package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class LoginPage {
	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	// pagefactory to find elements using @findby
	@FindBy(xpath = "//input[@name = 'username']")
	WebElement username1;
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password1;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;
	@FindBy(xpath = "//p[(text()='Dashboard')]")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement Alert;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void login(String user, String pass) {
		username1.sendKeys(user);
		password1.sendKeys(pass);
		signin.click();
	}*/

	public LoginPage EnterTheUserName(String username) {
		username1.sendKeys(username);
		return this;

	}

	public LoginPage EnterThePassword(String password) {
		password1.sendKeys(password);
		return this;

	}

	/*
	 * public void dropdown() { //PageUtility obj = new PageUtility();(if multiple
	 * declare public) obj.dropDownVisibleText(element, text); }
	 */
	public HomePage ClickOnSigninButton() {
		signin.click();
		return new HomePage(driver);
	}

	public boolean isDashBoardDisplayed() {
		return dashboard.isDisplayed();

	}

	public boolean invalidLogin() {
		return Alert.isDisplayed();

	}

}
