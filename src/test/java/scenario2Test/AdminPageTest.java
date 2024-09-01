package scenario2Test;

import org.testng.annotations.Test;

public class AdminPageTest extends BaseClass {
	@Test(priority = 1)
	public void getAllMenu() {
		ap.getMenu();
	}

	@Test(priority = 2)
	public void VerifySearchWithUsername() {
		ap.searchEmpByUsername("Admin");
	}

	@Test(priority = 3)
	public void VerifySerchWithUserRole() {
		ap.searchEmpByUserRole("Admin");
	}

	@Test(priority = 4)
	public void VerifySerchWithUserStatus() {
		ap.searchEmpByStatus("Enabled");
	}

}
