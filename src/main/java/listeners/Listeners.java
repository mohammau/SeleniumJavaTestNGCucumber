package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	 ExtentReports extentReport = ExtentReporter.getExtentReport();
	 ExtentTest extentTest;
	 ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
	
		extentTest = extentReport.createTest(result.getName());
		 extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		//extentTest.log(Status.PASS, "Test Passed");
		extentTestThread.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testMethodName = result.getName();
		
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try {
			String screenshotPath = takeScreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotPath, screenshotPath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}

}
