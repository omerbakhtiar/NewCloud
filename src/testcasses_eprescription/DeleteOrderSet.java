package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class DeleteOrderSet {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	OrderSet order = new OrderSet(driver);

@Test
public void deleteOrderSet() throws IOException, InterruptedException{
	String s = sr.Searching();
	Thread.sleep(10000);
	driver.manage().window().maximize();
	Thread.sleep(1000);
	order.selectOrderSet();
	Thread.sleep(10000);
	order.deleteOrderSet("dengue");
	
}

}
