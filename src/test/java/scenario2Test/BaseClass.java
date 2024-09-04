package scenario2Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import scenario2Pages.AdminPage;
import scenario2Pages.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AdminPage ap;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Maximize the window
		driver.manage().window().maximize();

		lp = new LoginPage(driver);
		ap = new AdminPage(driver);

	}

	/*@BeforeClass
	public void pageSetup() {
		System.out.println("Login Test");
		lp.doLogin("Admin", "admin123");

	}*/

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000); // Wait for 5 sec before quit
		driver.quit();
		
	}

}
