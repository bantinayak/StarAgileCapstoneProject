package scenario2Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// initialize driver
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	// locators
	private By uname = By.name("username");
	private By pass = By.name("password");
	private By btn = By.xpath("//button[@type='submit']");

	// method

	public void doLogin(String un, String psw) {
		driver.findElement(uname).sendKeys(un);
		driver.findElement(pass).sendKeys(psw);
		driver.findElement(btn).click();
	}

	public String getAppTitle() {
		return driver.getTitle();
	}

	public String getAppUrl() {
		return driver.getCurrentUrl();
	}
}
