package org.actitime.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.frameworkdemo.generics.Genericmethods;

@Listeners(com.frameworkdemo.utility.Listenersclass.class)
public class Actimelogin extends Genericmethods {

	@Test
	public void login() throws InterruptedException, FileNotFoundException, IOException {

		gv.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		setdata(gv.browser.getProperty("username"), "username");
		System.out.println("username entered");
		setdata(gv.browser.getProperty("password"), "password");
		System.out.println("password enterred");
		clickOnElement("loginbtn");
		Thread.sleep(5000);
		Reporter.log(gv.driver.getTitle(), true);
		List<WebElement> lst = findWebelements("links");
		for(WebElement e:lst)
		{
			if(!(e.getText().equals("")))
			Reporter.log(e.getText(),true);
		}
		getscreenshot("timetrack",gv.browser.getProperty("screanshots-path") ,"Actitime");
	}
}
