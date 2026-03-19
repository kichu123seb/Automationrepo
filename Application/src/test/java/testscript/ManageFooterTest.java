
package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	public HomePage homepage;
	public ManageFooterPage managefooterpage;
	@Test(priority = 1, groups = { "regression" },description = "TestCase to upadte the adress in the ManageFooter page")
	public void verifyTheUserIsAbleToUpadteManageFooter() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		homepage = loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();
		
		//ManageFooterPage managefooter = new ManageFooterPage(getDriver());
		/*loginpage.EnterTheUserName(username);
		loginpage.EnterThePassword(password);
		loginpage.ClickOnSigninButton();
		Assert.assertTrue(managefooter.isManageFooterDisplayed());*/
		
		managefooterpage = homepage.ManageFootermoreInfo().idButton().EnterText("sample Address").updateButton();

		/*managefooter.ManageFootermoreInfo();
		managefooter.idButton();
		managefooter.EnterText("sample Address");
		managefooter.updateButton();*/
		Assert.assertTrue(managefooterpage.isAlertDisplayed());

	}

}
