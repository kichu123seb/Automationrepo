package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test(priority = 1, groups = {
			"regression" }, description = "TestCase to upadte the email in the ManageContact page")

	public void verifyTheUserIsAbleToUpadteManageContactPage() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		ManageContactPage managecontact = new ManageContactPage(getDriver());

		loginpage.login(username, password);

		Assert.assertTrue(managecontact.isManageContactDispalyed());

		managecontact.moreInfo();
		managecontact.actionButton();
		managecontact.updateEmail();
		managecontact.upadte();

		Assert.assertTrue(managecontact.isAlertDisplayed());

	}

}
