package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport() {
		
		String filePath = System.getProperty("user.dir")+"//reports//extentReport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("Title");
		reporter.config().setReportName("ReportName");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OperatingSystem", "MacOS");
		extentReport.setSystemInfo("TestedBy", "Ummar");
		
		return extentReport;
	}

}
