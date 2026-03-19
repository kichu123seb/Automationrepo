package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base {
	public HomePage homepage;
	public ManageCategoryPage managecategorypage;

	@Test(priority = 1, groups = { "regression" }, description = "To add new category in the ManageCategory dashboard")
	public void verifyTheUserIsAbleToCreateAdminUserDetails() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		homepage = loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();

		// ManageCategoryPage managecategory = new ManageCategoryPage(getDriver());

		/*
		 * loginpage.EnterTheUserName(username); loginpage.EnterThePassword(password);
		 * loginpage.ClickOnSigninButton();
		 */

		managecategorypage = homepage.ManageCategorymoreinfo().newbutton().enterCategory("appleandapple").discount()
				.fileInput().savebutton();
		/*
		 * managecategory.newbutton(); managecategory.enterCategory("appleandapple");
		 * managecategory.discount(); managecategory.fileInput();
		 * managecategory.savebutton();
		 */
		Assert.assertTrue(managecategorypage.isAlertDisplayed());

	}
}
