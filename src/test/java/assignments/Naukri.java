package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Naukri {
	
	@Test
	public void closewindow()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com");
		Set<String> s = driver.getWindowHandles();
		List lst=new ArrayList(s);
		for(int i=lst.size()-1;i>=0;i--)
		{
			driver.switchTo().window(lst.get(i).toString()).close();
		}
	}

}
