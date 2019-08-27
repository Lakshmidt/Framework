package com.frameworkdemo.generics;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class GlobalVariables {
	public WebDriver driver;
	public static Properties object;
	public static Properties browser;
	public static Properties excel;
	public static String currentdir = System.getProperty("user.dir");
	public String testCaseName;
	
}
