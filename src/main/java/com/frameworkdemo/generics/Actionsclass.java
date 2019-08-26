package com.frameworkdemo.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsclass {
	Actions a;
	Genericmethods g=new Genericmethods();
	public void doubleclick(WebDriver driver,String elementname)
	{
		a=new Actions(driver);
		a.doubleClick(g.findWebelement(elementname)).perform();
	}
	public void doubleclick(WebDriver driver)
	{
		a=new Actions(driver);
		a.doubleClick().perform();
	}
	public void contextclick(WebDriver driver)
	{
		a=new Actions(driver);
		a.contextClick().perform();
	}
	public void contextclick(WebDriver driver,String elementname)
	{
		a=new Actions(driver);
		a.contextClick(g.findWebelement(elementname)).perform();
	}
	public void movetoelement(WebDriver driver,String elementname)
	{
		a=new Actions(driver);
		a.moveToElement(g.findWebelement(elementname)).perform();
	}
	public void movetoelement(WebDriver driver,String elementname,int xoffset,int yoffset)
	{
		a=new Actions(driver);
		a.moveToElement(g.findWebelement(elementname), xoffset, yoffset).perform();
	}
	public void draganddrop(WebDriver driver,String sourceelement,String targetelement)
	{
		a=new Actions(driver);
		a.dragAndDrop(g.findWebelement(sourceelement), g.findWebelement(targetelement)).perform();
	}
	public void clickandhold(WebDriver driver,String elementname)
	{
		a=new Actions(driver);
		a.clickAndHold(g.findWebelement(elementname)).perform();
	}
	public void clickonelement(WebDriver driver,String targetelementname)
	{
		a=new Actions(driver);
		a.click(g.findWebelement(targetelementname)).perform();
	}
}
