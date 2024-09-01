package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {
			extent = createInstance();
			return extent;
		} else {
			return extent;
		}

	}

	public static ExtentReports createInstance() {

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Report/OHRMAutomation.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("NewTEstReport");
		sparkReporter.config().setDocumentTitle("Sprint 1 Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer name", "Samsung");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Banti nayak");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser Name", "Chrome");

		return extent;
	}

}
