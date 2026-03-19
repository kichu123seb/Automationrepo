package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class ManageFooterPage {
	public WebDriver driver;
	PageUtilities obj = new PageUtilities();

//pom with pagefactory
	// pagefactory to find elements using @findby

	@FindBy(xpath = "//p[normalize-space()='Manage Footer Text']/ancestor::div[contains(@class,'small-box')]")
	WebElement ManageFooter;
	//@FindBy(xpath = "//p[normalize-space()='Manage Footer Text']/ancestor::div[contains(@class,'small-box')]//a")
	//WebElement managefooterinfomore;
	@FindBy(xpath = "(//a[contains(@href,'Footertext/edit')])[1]")
	WebElement managefootereditbutton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement addressfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement Alert;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isManageFooterDisplayed() {
		return ManageFooter.isDisplayed();
	}

	/*public ManageFooterPage ManageFootermoreInfo() {
		managefooterinfomore.click();
		return this;
	}*/

	public ManageFooterPage idButton() {
		managefootereditbutton.click();
		return this;
	}

	public ManageFooterPage EnterText(String text) {
		addressfield.clear();
		addressfield.sendKeys(text);
		return this;
	}

	public ManageFooterPage updateButton() {
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return Alert.isDisplayed();
	}

}
