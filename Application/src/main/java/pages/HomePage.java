package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class HomePage {

	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	// pagefactory to find elements using @findby
	@FindBy(xpath = "//a[.//img and contains(.,'Admin')]")
	WebElement Admin;
	@FindBy(xpath = "//a[contains(.,'Logout')]")
	WebElement logout;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;
	
	

	public HomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);

	}

	public void Admin() {
		//clicks the Admin dropdown
		Admin.click();
	}

	public void logout() {
		//clicks the Logout link
		logout.click();
	}
	
	public boolean isSigninDisplayed() {
		return signinbutton.isDisplayed();
	}

}
