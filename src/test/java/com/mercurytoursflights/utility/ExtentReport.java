package com.mercurytoursflights.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.MessagingException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mercurytoursflights.reusuablecomponents.Driver;

/**
 * @author M1049131 
 * Purpose: To generate extent report.
 *         
 */

public class ExtentReport extends TestListenerAdapter {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest logTest;
	public static String path ="";	
	Screenshot screenshot = new Screenshot();

	public ExtentReport() {
	}

	// When the test case is started
	public void onStart(ITestContext testContext) {

		String date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		path ="./extentreports/Test_Report_"+date+".html";
		htmlReporter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Report on Test Execution");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	// When the test case is passed
	public void onTestSuccess(ITestResult testResult) {
		logTest = report.createTest(testResult.getName());
		logTest.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
	}

	// When the test case is failed
	public void onTestFailure(ITestResult testResult) {
		logTest = report.createTest(testResult.getName());
		logTest.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));
																									
																									
		logTest.log(Status.FAIL, "TEST FAILED" + testResult.getThrowable());

		try {
			System.out.println("error");
			logTest.fail("Below is the screenshot attached. "
					+ logTest.addScreenCaptureFromPath(screenshot.takeScreenshot(Driver.driver)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// When the test case execution is finished
	public void onFinish(ITestContext testContext) {
		report.flush();		
	}

	public static String sendEmail() {
		Log.info("Sending a mail");
		return path;
	}
}
