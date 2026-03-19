package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenshot(ThreadLocal<WebDriver> driver,String failedtestcases) throws IOException {
		//convert webdriver to screenshot mode
		TakesScreenshot scrShot = (TakesScreenshot) driver.get(); 
		//to capture the screenshot
	    File screenShot=scrShot.getScreenshotAs(OutputType.FILE);
	    //create date and time
	    //Date class- to get date
	    String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"). format(new Date());
	    //to create a folder
	    File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");
	    if(!f1.exists()) {
	    	f1.mkdirs();
	    }
	    String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedtestcases + timeStamp + ".png";
	    File finalDestination = new File(destination);
	    FileHandler.copy(screenShot, finalDestination);
	}

}
