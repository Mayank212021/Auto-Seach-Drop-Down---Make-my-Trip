package com.myproject1.utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	/* Remember, we have to congfigure this method before the execution of the test cases.Because onstart method execute first before class start, so we can
	   configure this method inside the onstart method */
	public void configureReports()
	{
		readConfig readconfig = new readConfig();
		// for generating extent report with time.
		String timestamp = new SimpleDateFormat("YYYY.MM.dd hh.mm.ss").format(new Date());
		String reportName = "MyProject1-" + timestamp  + ".html" ;
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add system/environmental information

		reports.setSystemInfo("Machine:", "Mayank_HP_Laptop");
		reports.setSystemInfo("Operating System:", "Window-11");
		reports.setSystemInfo("Browser:", readconfig.getBrowser());
		reports.setSystemInfo("User Name:", "Mayank Kaushik");

		// Configuration to change look and feel of report.
		htmlReporter.config().setDocumentTitle("Extent Reports of the Project");
		htmlReporter.config().setReportName(" Project Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}  
	// onStart method is called when ant test starts.
	public void onStart(ITestContext result) {
		configureReports();
		System.out.println("On start method invoked");			

	}	
	//onFinish method is called after all test cases are executed.
	public void onFinish(ITestContext result) {					
		System.out.println("On finish menthod invoked");
		reports.flush(); // flush method will write all the reports information in the html report.It is mandatory to call.

	}	
	public void onTestFailure(ITestResult result) {					
		System.out.println("Name of the failed test method  is :" + result.getName()); // print the name of the failed test method					
		test = reports.createTest(result.getName()); // For entry in the HTML report.
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test method  is :" + result.getName(),ExtentColor.RED ));
		// Capturing the screenshot , when test method is failed.
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
		File screenShotFile = new File(screenShotPath);
		if (screenShotFile.exists() ) {
			test.fail("Captured screenshot is below :" + test.addScreenCaptureFromPath(screenShotPath) );
		}
	}	
	public void onTestSkipped(ITestResult result) {					
		System.out.println("Name of the skipped test method  is :" + result.getName()); // print the name of the skipped test method					
		test = reports.createTest(result.getName()); // For entry in the HTML report.
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test method  is :" + result.getName(),ExtentColor.YELLOW ));
	}	
	public void onTestSuccess(ITestResult result) {					
		System.out.println("Name of the pass test method  is :" + result.getName()); // print the name of the pass test method					
		test = reports.createTest(result.getName()); // For entry in the HTML report.
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the pass test method  is :" + result.getName(),ExtentColor.GREEN ));		
	}	
	public void onTestStart(ITestResult result) {					
		System.out.println("Name of test method started :" + result.getName());		
	}	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					


	}	

}
