package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

//TestNG is a open source testing framework NG-refers to NEXT generation
//executes in structured way
//uses- manages test case organization,create test reports
//no object creation and main method instead uses instance method
//use @test denotation then not need to use object creation or main method.

public class Base {
	public Properties properties;
	public FileInputStream fileInputStream;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {
		return driver.get();
	}

//public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserInitialization(@Optional("chrome") String browser) throws Exception {
		try {
			properties=new Properties();
			fileInputStream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileInputStream);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			// driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			// driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			// driver = new EdgeDriver();

		} else {
			throw new Exception("invalid browser");
		}
		// Creates a reference variable driver of type WebDriver (interface).

		// new ChromeDriver() launches a new Chrome browser.
		// driver.get("https://groceryapp.uniqassosiates.com/admin");
		
		getDriver().get(properties.getProperty("url"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		//getDriver().get("https://groceryapp.uniqassosiates.com/admin");
		// Opens the given URL (Flipkart) in the Chrome browser.
		// using get method and url given as string
		// driver.manage().window().maximize();
		getDriver().manage().window().maximize();

		// manage() → used to manage browser settings
		// window() → controls the browser window
		// maximize() → maximizes the browser window

	}

	@AfterMethod(alwaysRun = true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE) {
			ScreenShotUtility screenshot=new ScreenShotUtility();
			screenshot.getScreenshot(driver, iTestResult.getName());
		}
		
		getDriver().quit();
	/*public void browserQuiteandClose() {
		getDriver().quit();
		driver.remove();*/

//driver.close(); // to close current window
//driver.quit();
//quite for closing all tabs in the window

	}
}