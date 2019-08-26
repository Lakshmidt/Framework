package com.frameworkdemo.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;

public class Listenersclass implements ITestListener {

	public void onTestStart(ITestResult result) {
		new ExtentHtmlReports().createExtentReport(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentHtmlReports.extentlogs.log(Status.PASS," is pass");
		ExtentHtmlReports.extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentHtmlReports.extentlogs.log(Status.FAIL, " is Fail");
		ExtentHtmlReports.extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentHtmlReports.extentlogs.log(Status.SKIP, " is ");
		ExtentHtmlReports.extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log(context.getClass().getSimpleName() + " Test is finished", true);
		ExtentHtmlReports.extent.flush();
	}

}
