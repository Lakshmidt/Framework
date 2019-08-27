package com.frameworkdemo.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;

public class Listenersclass extends Excelfiles implements ITestListener {

	public void onTestStart(ITestResult result) {
		new ExtentHtmlReports().createExtentReport(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentHtmlReports.extentlogs.log(Status.PASS," is pass");
		ExtentHtmlReports.extent.flush();
		try
		{
			writeData("excelexp","sheetname",result.getName(), Status.PASS.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentHtmlReports.extentlogs.log(Status.FAIL, " is Fail");
		ExtentHtmlReports.extent.flush();
		try
		{
			writeData("excelexp","sheetname",result.getName(), Status.FAIL.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentHtmlReports.extentlogs.log(Status.SKIP, " is ");
		ExtentHtmlReports.extent.flush();
		try
		{
			writeData("excelexp","sheetname",result.getName(), Status.SKIP.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
