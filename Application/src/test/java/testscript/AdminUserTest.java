package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class AdminUserTest extends Base {
	public HomePage homepage;
	public AdminUserPage adminpage;
	@Test(priority = 1, groups = { "regression" },description = "TestCase to Add new users")
	public void verifyTheUserIsAbleToCreateAdminUserDetails() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		homepage = loginpage.EnterTheUserName(username)
                .EnterThePassword(password)
                .ClickOnSigninButton();
		//AdminUserPage adminpage = new AdminUserPage(getDriver());
		
		
		/*String userName = ExcelUtilities.getStringData(1, 0, Constant.ADMIN_SHEET);
		String confirmUserName = ExcelUtilities.getStringData(1, 1, Constant.ADMIN_SHEET);
		int userType = Integer.parseInt(ExcelUtilities.getIntData(1, 2, Constant.ADMIN_SHEET));*/
		
		
		String userName = ExcelUtilities.getStringDataFromFile(Constant.ADMIN_DATA_FILE, "adminpage", 1, 1);
		String confirmUserName = ExcelUtilities.getStringDataFromFile(Constant.ADMIN_DATA_FILE, "adminpage", 1, 2);
		int userType = ExcelUtilities.getIntDataFromFile(Constant.ADMIN_DATA_FILE, "adminpage", 1, 3);

		
		adminpage = homepage.AdminMoreInfo()
			    .NewButton()
			    .EnterText(userName)
			    .EnterText1(confirmUserName)
			    .selectUserType(userType)
			    .SaveButton();
		
		/*loginpage.EnterTheUserName(username);
		loginpage.EnterThePassword(password);
		loginpage.ClickOnSigninButton();
		adminpage.AdminMoreInfo();
		adminpage.NewButton();
		adminpage.EnterText("kichu12");
		adminpage.EnterText1("kichu12");
		adminpage.selectUserType(2);
		adminpage.SaveButton();*/
		Assert.assertTrue(adminpage.isAlertDisplayed());

	}

}
