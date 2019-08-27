package com.frameworkdemo.excel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.frameworkdemo.generics.Genericmethods;
import com.frameworkdemo.utility.Listenersclass;

@Listeners(Listenersclass.class)
public class Login extends Genericmethods{

	@Test
	public void TC01()
	{
		System.out.println(gv.driver);
		setdata("admin","username");
		setdata("manager","password");
		clickOnElement("loginbtn");
	}
	
}
