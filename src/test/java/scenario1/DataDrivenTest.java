package scenario1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.ExtentITestNGListeners.class)
public class DataDrivenTest {

	public static WebDriver driver;

	@Test(dataProvider = "Excel", dataProviderClass = CustomData.class)
	public void testdatadriven(String username, String password) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Fail");
		System.out.println("Login Successfull");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		System.out.println("Logout Succesfull");


	}

	public void captureScreenshot(Object filename ) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+ "\\screenshot\\" + filename);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		Reporter.log("ScreenShot captured!", true);
	}

}
