package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	public HomePage homepage;
	public ManageContactPage managecontactpage;
	@Test(priority = 1, groups = {
			"regression" }, description = "TestCase to upadte the email in the ManageContact page")

	public void verifyTheUserIsAbleToUpadteManageContactPage() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		
		homepage = loginpage.EnterTheUserName(username).EnterThePassword(password).ClickOnSigninButton();
		//ManageContactPage managecontact = new ManageContactPage(getDriver());

		/*loginpage.EnterTheUserName(username);
		loginpage.EnterThePassword(password);
		loginpage.ClickOnSigninButton();
		Assert.assertTrue(managecontact.isManageContactDispalyed());*/
		
		managecontactpage = homepage.ManageContactmoreInfo().actionButton().updateEmail().upadte();

		/*managecontact.ManageContactmoreInfo();
		managecontact.actionButton();
		managecontact.updateEmail();
		managecontact.upadte();*/

		Assert.assertTrue(managecontactpage.isAlertDisplayed());

	}

}
