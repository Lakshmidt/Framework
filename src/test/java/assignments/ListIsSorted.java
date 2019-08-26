package assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListIsSorted {
	@Test
	public void sortedlist()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Lakshmi/Desktop/html%20codes/Singleselct.html");
		Select s=new Select(driver.findElement(By.id("slv")));
		List<String> unsorted = new ArrayList();
		List<String> sorted = new ArrayList();
		for(WebElement e:s.getOptions())
		{
			unsorted.add(e.getText());
			sorted.add(e.getText());
		}
		Collections.sort(sorted);
		if(unsorted.equals(sorted))
		{
			Reporter.log("Lsit is soreted",true);
		}
		else
			Reporter.log("List is not sorted",true);
		
	}

}
