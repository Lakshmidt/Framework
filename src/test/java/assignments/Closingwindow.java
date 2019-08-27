package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;
import com.frameworkdemo.generics.Genericmethods;

public class Closingwindow extends Genericmethods{
	@Test
	public void closealternate()
	{
		Set<String> s = getwindowhandles();
		List<String> lst=new ArrayList<String>(s);
		for(int i=lst.size()-1;i>=0;i-=2)
		{
			gv.driver.switchTo().window(lst.get(i).toString()).close();
		}
	}

}
