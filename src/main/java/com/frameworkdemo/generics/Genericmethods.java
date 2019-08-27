package com.frameworkdemo.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Genericmethods extends Base{
	By b;
	public WebElement findWebelement(String elementName)
	{
		System.out.println(gv.object.getProperty(elementName));
		String[] locator = gv.object.getProperty(elementName).split("-");
		
		if(locator[0].equalsIgnoreCase("id"))
		{
			b=By.id(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("name"))
		{
			b=By.name(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("className"))
		{
			b=By.className(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("cssSelector"))
		{
			b=By.cssSelector(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("linkText"))
		{
			b=By.linkText(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("partialLinkText"))
		{
			b=By.partialLinkText(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("xpath"))
		{
			b=By.xpath(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("tagName"))
		{
			b=By.tagName(locator[1]);
		}
		
		return gv.driver.findElement(b);
		
	}
	
	public List<WebElement> findWebelements(String elementName)
	{
		String[] locator = gv.object.getProperty(elementName).split("-");
		if(locator[0].equalsIgnoreCase("id"))
		{
			b=By.id(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("Name"))
		{
			b=By.name(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("className"))
		{
			b=By.className(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("cssSelector"))
		{
			b=By.cssSelector(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("linkText"))
		{
			b=By.linkText(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("partialLinkText"))
		{
			b=By.partialLinkText(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("xpath"))
		{
			b=By.xpath(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("tagName"))
		{
			b=By.tagName(locator[1]);
		}
		 return gv.driver.findElements(b);
	}
	public void setdata(String data,String elementname)
	{
		System.out.println(gv.driver);
		findWebelement(elementname).sendKeys(data);
	}
	public void clickOnElement(String elementname)
	{
		findWebelement(elementname).click();
	}
	public String gettext(String elementname)
	{
		return findWebelement(elementname).getText();
	}
	public String getAttributevalue(String value,String elementname)
	{
		return findWebelement(elementname).getAttribute(value);
	}
	public void maximize()
	{
		gv.driver.manage().window().maximize();
	}
	public void getscreenshot(String elementname,String filepath,String filename) throws IOException
	{
		File src = findWebelement(elementname).getScreenshotAs(OutputType.FILE);
		File dest=new File(filepath+"\\"+filename+".png");
		System.out.println("path "+filepath);
		System.out.println(filepath+"\\"+filename+".png");
		FileUtils.copyFile(src, dest);
	}
	public boolean isdisplayed(String elementname)
	{
		return findWebelement(elementname).isDisplayed();
	}
	public boolean isselected(String elementname)
	{
		return findWebelement(elementname).isSelected();
	}
	public boolean isenabled(String elementname)
	{
		return findWebelement(elementname).isSelected();
	}
	public String getcssvalue(String elementname,String Propertyname)
	{
		return findWebelement(elementname).getCssValue(Propertyname);
	}
	public void scrollby(int xoffset, int yoffset) 
	{
		JavascriptExecutor j = (JavascriptExecutor)gv.driver;
		j.executeScript("window.scrollBy(xoffset,yoffset)");
	}
	public Set<String> getwindowhandles()
	{
		return gv.driver.getWindowHandles();
	}
	public String getwindowhandle()
	{
		return gv.driver.getWindowHandle();
	}
}
