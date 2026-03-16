package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base {
	@Test(priority = 1, groups = { "regression" },description = "To add new category in the ManageCategory dashboard")
	public void verifyTheUserIsAbleToCreateAdminUserDetails() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		ManageCategoryPage managecategory = new ManageCategoryPage(getDriver());

		loginpage.login(username, password);

		managecategory.isManageCategoryDisplayed();
		managecategory.moreinfo();
		managecategory.newbutton();
		managecategory.enterCategory("applean");
		managecategory.discount();
		managecategory.fileInput();
		managecategory.savebutton();
		Assert.assertTrue(managecategory.isAlertDisplayed());

	}
}
