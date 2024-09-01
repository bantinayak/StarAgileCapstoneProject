package scenario2Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class AdminPage {
	private WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	// locator
	private By menu = By.xpath("//ul[@class='oxd-main-menu']//li//span");
	private By uname = By.xpath("//form[@class='oxd-form']//input[@class='oxd-input oxd-input--active']");
	private By userrole = By
			.xpath("(//form[@class='oxd-form']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
	private By status = By
			.xpath("(//form[@class='oxd-form']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
	private By searchbtn = By.cssSelector("button[type='submit']");
	private By recordmsg = By
			.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]");
	private By userROptions = By.xpath("(//span[normalize-space()='Admin'])[2]");
	private By statustext = By.xpath("//div[@role='option']//span");

	// methods
	public void getMenu() {
		List<WebElement> allMenu = driver.findElements(menu);
		//Reporter.log("allElements are: " + allElements, true);
		Reporter.log("Total menu options are: " + allMenu.size(), true);

		for (WebElement element : allMenu) {
			Reporter.log(element.getText(), true);
			if (element.getText().contains("Buzz")) {
				element.click();
				break;
			}
		}
	}

	public void searchEmpByUsername(String name) {
		driver.findElement(uname).sendKeys(name);

		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log(driver.findElement(recordmsg).getText(), true);

		driver.findElement(uname).clear();
	}

	public void searchEmpByUserRole(String role) {
		Reporter.log("Search Employee by UserRole", true);

		driver.findElement(userrole).click();
		List<WebElement> list = driver.findElements(userROptions);
		for (WebElement i : list) {
			if (i.getText().contains(role)) {
				i.click();
				break;
			}
		}

		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log(driver.findElement(recordmsg).getText(), true);

		driver.navigate().refresh();
	}

	public void searchEmpByStatus(String stat) {
		Reporter.log("Search Employee by Status", true);

		driver.findElement(status).click();
		List<WebElement> list = driver.findElements(statustext);
		for (WebElement i : list) {
			if (i.getText().contains(stat)) {
				i.click();
				break;
			}
		}

		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log(driver.findElement(recordmsg).getText(), true);

	}

}
