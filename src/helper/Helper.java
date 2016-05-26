package helper;

import java.util.HashSet;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Helper {
	
	 WebDriver driver;
	
	public Helper(WebDriver driver2){	
		driver=driver2;
		PageFactory.initElements(driver2,this);
	
	}
	 
	public void WindowHandles(){
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
	
		HashSet<String> handles = (HashSet<String>) driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		
		while (iterator.hasNext()){
				subWindowHandler = iterator.next();
		}
		
		driver.switchTo().window(subWindowHandler);

		}
	
	
	
}
