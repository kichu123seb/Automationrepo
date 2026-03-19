package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class ManageNewsPage {
	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	// pagefactory to find elements using @findby

	@FindBy(xpath = "//section[@class='content']//p[text()='Manage News']")
	WebElement managenews;
	//@FindBy(xpath = "//p[text()='Manage News']/ancestor::div[contains(@class,'small-box')]//a")
	//WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement textfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isMangeNewsDisplayed() {
		return managenews.isDisplayed();

	}

	/*public ManageNewsPage ManageNewsMoreInfo() {
		managenewsmoreinfo.click();
		return this;
	}*/

	public ManageNewsPage NewButton() {
		newbutton.click();
		return this;

	}

	public ManageNewsPage EnterText(String text) {
		textfield.sendKeys(text);
		return this;
	}

	public ManageNewsPage SaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}

}
