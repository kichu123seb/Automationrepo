package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base {

	@Test(priority = 1, groups = { "regression" }, description = "To logout from the page")
	public void verifyTheUserIsAbleToLogout() throws IOException {
		// String username = "admin";
		// String password ="admin";
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(getDriver());
		// Object creation
		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton();
		 */

		HomePage homepagee = loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();

		homepagee.Admin();
		homepagee.logout();
		Assert.assertTrue(homepagee.isSigninDisplayed());

		// System.out.println(username);
		// System.out.println(password);

	}
}
