package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminUserPage {
	
	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	//pagefactory to find elements using @findby
	
	@FindBy(xpath = "//p[normalize-space()='Admin Users']/ancestor::div[@class='small-box bg-info']")WebElement AdminUsers;
	@FindBy(xpath ="//p[normalize-space()='Admin Users']/ancestor::div[contains(@class,'small-box')]//a")WebElement adminmoreinfo;
	@FindBy(xpath ="//a[@onclick='click_button(1)']")WebElement adminnewbutton;
	@FindBy(xpath ="//input[@id=\"username\"]")WebElement usernamefield;
	@FindBy(xpath ="//input[@id=\"password\"]")WebElement passwordfield;
	@FindBy(xpath ="//select[@id=\"user_type\"]")WebElement usertype;
	@FindBy(xpath ="//button[@name='Create']")WebElement save;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement alert;

	
	

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAdminUserDisplayed() {
		return AdminUsers.isDisplayed();
	}
	public void MoreInfo() {
		adminmoreinfo.click();
	}
	public void NewButton() {
		adminnewbutton.click();
		
	}
	public void EnterText(String text) {
		usernamefield.sendKeys(text);
	}
	public void EnterText1(String password) {
		passwordfield.sendKeys(password);
	}
	

	public void selectUserType(int index) {
	    Select select = new Select(usertype);
	    select.selectByIndex(index);
	}
	
	public void SaveButton() {
		save.click();
		
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
