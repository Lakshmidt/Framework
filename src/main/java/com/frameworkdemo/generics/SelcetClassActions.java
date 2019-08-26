package com.frameworkdemo.generics;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelcetClassActions extends Base {
	Genericmethods g=new Genericmethods();
	Select s;
	
	public void selectbyvalue(String value,String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		s.selectByValue(value);
	}
	public void selectbytext(String text,String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		s.selectByVisibleText(text);
	}
	public void selectbyindex(int index,String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		s.selectByIndex(index);
	}
	public boolean ismultiple(String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		return s.isMultiple();
	}
	public void deselectbyvalue(String value,String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		if(s.isMultiple())
			s.deselectByValue(value);
		else
			System.out.println("Dropdown is not multiple");
		
	}
	public void deselectbyindex(int index,String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		if(s.isMultiple())
		s.deselectByIndex(index);
	}
	public void deselectbytext(String text,String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		if(s.isMultiple())
		s.deselectByVisibleText(text);
		
	}
	public void deselectall(String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		if(s.isMultiple())
		s.deselectAll();
	}
	public List<WebElement> getalloptions(String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		return s.getOptions();
	}
	public List<WebElement> getallselectedoptions(String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		if(s.isMultiple())
		return s.getAllSelectedOptions();
		return null;
	}
	public WebElement getwrappedelement(String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		return s.getWrappedElement();
	}
	public WebElement getfirstselect(String selectid)
	{
		s=new Select(g.findWebelement(selectid));
		return s.getFirstSelectedOption();
	}
	public void selectmultiple(String selectid,String[]text)
	{
		s=new Select(g.findWebelement(selectid));
		for(int i=0;i<text.length;i++)
		{
			s.selectByValue(text[i]);
		}
	}
	public void selectmultiple(String selectid,int[]index)
	{
		s=new Select(g.findWebelement(selectid));
		for(int i=0;i<index.length;i++)
		{
			s.selectByIndex(index[i]);
		}
	}
}
