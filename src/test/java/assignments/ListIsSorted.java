package assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.frameworkdemo.generics.SelectClassActions;	

public class ListIsSorted extends SelectClassActions{
	@Test
	public void sortedlist()
	{
		//SelectClassActions s=new SelectClassActions();
		List<String> unsorted = new ArrayList<String>();
		List<String> sorted = new ArrayList<String>();
		for(WebElement e:getalloptions("selectelement"))
		{
			unsorted.add(e.getText().toUpperCase());
			sorted.add(e.getText().toUpperCase());
		}
		Collections.sort(sorted);
		Assert.assertEquals(sorted,unsorted);
		/*if(unsorted.equals(sorted))
		{
			Reporter.log("List is soreted",true);
		}
		else
			Reporter.log("List is not sorted",true);*/
		
	}

}
