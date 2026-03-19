package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
//assertion used for validation
//hard assertion- if assertion fail execution stop and soft assertion- if fails continue all the case at end assertall.create object.

public class LoginTest extends Base {
	@Test(priority = 1, groups = { "regression" }, description = "TestCase for checking valid login ")
	public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException {
		// String username = "admin";
		// String password ="admin";
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(getDriver());
		// Object creation

		HomePage homepage = loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();
		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton();
		 */
		//Assert.assertTrue(homepage.isSigninDisplayed());
		Assert.assertTrue(new LoginPage(getDriver()).isDashBoardDisplayed());
		// System.out.println(username);
		// System.out.println(password);

	}

	@Test(priority = 2, groups = { "regression" }, description = "TestCase for checking invalid username login ")
	public void verifyTheUserIsAbleToLoginWithInvalidUserName() throws IOException {
		// String username = "admin56";
		// String password ="admin";
		String username = ExcelUtilities.getStringData(2, 0, "loginpage");
		String password = ExcelUtilities.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(getDriver());
		// LoginPage loginpage = new LoginPage(driver);
		// Object creation
		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton(); boolean home = loginpage.invalidLogin();
		 * Assert.assertTrue(home);
		 */
		loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();

		Assert.assertTrue(loginpage.invalidLogin());

	}

	@Test(priority = 3, description = "TestCase for checking invalid password login ")
	public void verifyTheUserIsAbleToLoginWithInvalidPassword() throws IOException {
		// String username = "admin";
		// String password ="admin123";
		String username = ExcelUtilities.getStringData(3, 0, "loginpage");
		String password = ExcelUtilities.getStringData(3, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		// Object creation
		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton(); boolean homep = loginpage.invalidLogin();
		 * Assert.assertTrue(homep);
		 */
		loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();

		Assert.assertTrue(loginpage.invalidLogin());

	}

	@Test(priority = 4, description = "TestCase for checking invalid username and password login ")
	public void verifyTheUserIsAbleToLoginWithInvalidUserNameAndPassword() throws IOException {
		// String username = "admin123";
		// String password ="admin123";
		String username = ExcelUtilities.getStringData(4, 0, "loginpage");
		String password = ExcelUtilities.getStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(getDriver());
		// Object creation
		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton(); boolean homeee = loginpage.invalidLogin();
		 * Assert.assertTrue(homeee);
		 */
		loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();

		Assert.assertTrue(loginpage.invalidLogin());

	}

}
