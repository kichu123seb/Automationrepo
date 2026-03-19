package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	public HomePage homepage;
	public ManageNewsPage managenewspage;

	@Test(priority = 1, groups = {
			"regression" }, description = "To enter new informations or news in the manage news Dashboard")
	public void verifyTheUserIsAbleToCreateNews() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		homepage = loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();

		// ManageNewsPage managepage = new ManageNewsPage(getDriver());

		// Login
		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton();
		 */

		// Navigate to Manage News

		managenewspage = homepage.ManageNewsMoreInfo().NewButton().EnterText("Offer Closes Soon").SaveButton();

		/*
		 * managepage.ManageNewsMoreInfo(); managepage.NewButton();
		 * 
		 * // Enter news managepage.EnterText("Offer Closes Soon");
		 * managepage.SaveButton();
		 */

		// Validate alert
		Assert.assertTrue(managenewspage.isAlertDisplayed());
	}

}
