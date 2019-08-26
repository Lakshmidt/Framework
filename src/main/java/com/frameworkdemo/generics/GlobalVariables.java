package com.frameworkdemo.generics;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class GlobalVariables {
	public WebDriver driver;
	public Properties object;
	public Properties browser;
	public Properties excel;
	public String currentdir = System.getProperty("user.dir");
	
	public String testCaseName;
	
}
