package com.frameworkdemo.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public GlobalVariables gv = new GlobalVariables();
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest extentlogs;

	@BeforeSuite
	public void beforesuite() throws FileNotFoundException, IOException {
		init();
	}

	@BeforeMethod
	public void beforemethod(ITestResult result) throws FileNotFoundException, IOException {
		if (gv.browser.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			gv.driver = new ChromeDriver();
		} else if (gv.browser.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			gv.driver = new FirefoxDriver();
		}
		enterURL();
		gv.driver.manage().window().maximize();

	}

	public void init() throws FileNotFoundException, IOException {
		gv.object = new Properties();
		gv.object.load(new FileInputStream(gv.currentdir + "\\src\\main\\resources\\object.properties"));
		gv.browser = new Properties();
		gv.browser.load(new FileInputStream(gv.currentdir + "\\src\\main\\resources\\Browser.properties"));
		gv.excel = new Properties();
		gv.excel.load(new FileInputStream(gv.currentdir + "\\src\\main\\resources\\excel.properties"));
	}

	public void enterURL() throws FileNotFoundException, IOException {
		try {
			gv.driver.get(gv.browser.getProperty("url"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closeApp() {
		gv.driver.close();
	}

}
