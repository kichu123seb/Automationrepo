package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class AdminUserTest extends Base {
	@Test(priority = 1, groups = { "regression" },description = "TestCase to Add new users")
	public void verifyTheUserIsAbleToCreateAdminUserDetails() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		AdminUserPage adminpage = new AdminUserPage(getDriver());

		loginpage.login(username, password);
		adminpage.MoreInfo();
		adminpage.NewButton();
		adminpage.EnterText("kichu12");
		adminpage.EnterText1("kichu12");
		adminpage.selectUserType(2);
		adminpage.SaveButton();
		Assert.assertTrue(adminpage.isAlertDisplayed());

	}

}
