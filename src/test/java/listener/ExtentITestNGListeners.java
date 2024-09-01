package listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import scenario1.DataDrivenTest;

public class ExtentITestNGListeners extends DataDrivenTest implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();

	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

		parentTest.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {

		parentTest.get().pass("Test Passed");
		String pass = result.getName();
		try {
			Thread.sleep(3000);
			captureScreenshot(
					result.getTestClass().getRealClass().getSimpleName() + "_" + pass + "_" + timestamp() + ".png");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		captureScreenshot(result.getTestClass().getRealClass().getSimpleName()+"_"+pass+"_"+timestamp()+".png");

	}

	private String timestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	}

	public void onTestFailure(ITestResult result) {

		parentTest.get().fail("Test Failed " + result.getThrowable().getMessage());
		String fail = result.getName();
		try {
			Thread.sleep(3000);
			captureScreenshot(
					result.getTestClass().getRealClass().getSimpleName() + "_" + fail + "_" + timestamp() + ".png");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		captureScreenshot(result.getTestClass().getRealClass().getSimpleName()+"_"+fail+"_"+timestamp()+".png");

	}

	public void onTestSkipped(ITestResult result) {
		parentTest.get().skip("Test Skipped " + result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
