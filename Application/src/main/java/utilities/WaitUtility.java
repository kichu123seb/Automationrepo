package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	//wait- provide an wait
	//implicit wait explicit wait and fluent wait
	//implicit wait(global or static wait) - given in the base class after url load and give only one time
	//explicit- give wait for specific element(dynamic or intelligent).Works based on given condition.
	//fluent-similar to explicit,in fluent i can customize
	public static final int IMPLICITWAIT=5;
	public static final int EXPLICITWAIT=10;
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
