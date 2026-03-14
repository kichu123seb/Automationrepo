
package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	@Test(priority = 1, groups = { "regression" },description = "TestCase to upadte the adress in the ManageFooter page")
	public void verifyTheUserIsAbleToUpadteManageFooter() throws IOException {

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(getDriver());
		ManageFooterPage managefooter = new ManageFooterPage(getDriver());
		loginpage.login(username, password);

		Assert.assertTrue(managefooter.isManageFooterDisplayed());

		managefooter.moreInfo();
		managefooter.idButton();
		managefooter.EnterText("sample Address");
		managefooter.updateButton();
		Assert.assertTrue(managefooter.isAlertDisplayed());

	}

}
