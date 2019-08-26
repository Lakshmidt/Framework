package com.frameworkdemo.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.frameworkdemo.generics.Base;

public class ExtentHtmlReports extends Base {

	public void createExtentReport(String testCaseName) {
		reporter = new ExtentHtmlReporter(gv.currentdir + "\\Reports\\"+testCaseName+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extentlogs = extent.createTest(testCaseName);
	}
}
