package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.frameworkdemo.generics.SelectClassActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Noduplicatesinlist extends SelectClassActions{
	@Test
	public void duplicatesinlist()
	{
		List<WebElement> lst = getalloptions("selectelement");
		boolean f=false;
		for(int i=0;i<lst.size();i++)
		{
			for(int j=i+1;j<lst.size();j++)
			{
				if(lst.get(i).getText().equals(lst.get(j).getText()))
				{	
					f=false;
					Assert.fail();
				}
				else
					f=true;
			}
		}
		if(f)
		Reporter.log("No duplicates present in the list",true);
	}
}
