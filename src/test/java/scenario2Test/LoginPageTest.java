package scenario2Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class LoginPageTest extends BaseClass {
	@Test(priority = 1)
	public void verifyTitle() {

		String act = lp.getAppTitle();
		Assert.assertTrue(act.contains("HRM"), "Error-Title not match");
		Reporter.log("Title match!", true);
	}

	@Test(priority = 2)
	public void verifyLogin() {
		lp.doLogin("Admin", "admin123");
	}

	@Test(priority = 3)
	public void verifyCurrentUrl() {
		Reporter.log("Title is: "+lp.getAppUrl(), true);
	}

}
