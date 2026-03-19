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
	@FindBy(xpath = "//p[normalize-space()='Admin Users']/ancestor::div[contains(@class,'small-box')]//a")
	WebElement adminmoreinfo;
	@FindBy(xpath = "//p[normalize-space()='Manage Category']/ancestor::div[contains(@class,'small-box')]//a")
	WebElement managecategoryinfomore;
	@FindBy(xpath = "//p[normalize-space()='Manage Contact']/ancestor::div[contains(@class,'small-box')]//a")
	WebElement managecontactinfomore;
	@FindBy(xpath = "//p[normalize-space()='Manage Footer Text']/ancestor::div[contains(@class,'small-box')]//a")
	WebElement managefooterinfomore;
	@FindBy(xpath = "//p[text()='Manage News']/ancestor::div[contains(@class,'small-box')]//a")
	WebElement managenewsmoreinfo;
	
	

	public HomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);

	}

	public AdminUserPage Admin() {
		//clicks the Admin dropdown
		Admin.click();
		return new AdminUserPage(driver);
	}
	
	public AdminUserPage AdminMoreInfo() {
		adminmoreinfo.click();
		return new AdminUserPage(driver);
	}
	
	public ManageCategoryPage ManageCategorymoreinfo() {
		managecategoryinfomore.click();
		return new ManageCategoryPage(driver) ;
	}
	
	
	public ManageContactPage ManageContactmoreInfo() {
		managecontactinfomore.click();
		return new ManageContactPage(driver);

	}
	public ManageFooterPage ManageFootermoreInfo() {
		managefooterinfomore.click();
		return new ManageFooterPage(driver);
	}
	public ManageNewsPage ManageNewsMoreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public LoginPage logout() {
		//clicks the Logout link
		logout.click();
		return new LoginPage(driver);
	}
	
	public boolean isSigninDisplayed() {
		return signinbutton.isDisplayed();
	}

}
