package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public void dropDownVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(WebElement element, int userType2) {
		Select select = new Select(element);
		select.selectByIndex(userType2);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
}
