package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	@Test(priority = 1, groups = {"regression"})
	public void verifyTheUserIsAbleToCreateNews() throws IOException {

	    String username = ExcelUtilities.getStringData(1, 0, "loginpage");
	    String password = ExcelUtilities.getStringData(1, 1, "loginpage");

	    LoginPage loginpage = new LoginPage(getDriver());
	    ManageNewsPage managepage = new ManageNewsPage(getDriver());

	    // Login
	    loginpage.login(username, password);
	    // Navigate to Manage News
	    managepage.MoreInfo();
	    managepage.NewButton();

	    // Enter news
	    managepage.EnterText("Offer Closes Soon");
	    managepage.SaveButton();

	    // Validate alert
	    Assert.assertTrue(managepage.isAlertDisplayed());
	}

	
	
	
	
	/*@Test(priority = 1,groups={"regression"})
	public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException {
		//String  username = "admin";
		//String password ="admin";
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		ManageNewsPage Managepage = new ManageNewsPage(getDriver());
        // Object creation
		Managepage.EnterTheUserName(username);
		Managepage.EnterThePassword(password);
		Managepage.ClickOnSigninButton();
        boolean homepage = Managepage.isMangeNewsDisplayed();
        Assert.assertTrue(homepage);
        //boolean homepage = loginpage.isDashBoardDisplayed();
        //Assert.assertTrue(homepage);
        //System.out.println(username);
        //System.out.println(password);
		Managepage.MoreInfo();
		Managepage.NewButton();
		ManageNewsPage managePage = new ManageNewsPage(getDriver());
		managePage.EnterText("Offer Closes Soon");
		managePage.SaveButton();
        boolean homep = managePage.isAlertDisplayed();
        Assert.assertTrue(homep);*/


		


}
	
	
	


