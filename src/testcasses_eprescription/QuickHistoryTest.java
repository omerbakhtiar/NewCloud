package testcasses_eprescription;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.core.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.QuickHistory;


public class QuickHistoryTest {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);


	@Test(priority=1)
	public void verifyMrNumber() throws IOException, InterruptedException {
		Thread.sleep(20000);
		String s = sr.Searching();
		Thread.sleep(20000);
		driver.manage().window().maximize();

		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		boolean result =his.clickVisitFomDate("10-May-2016");
		Thread.sleep(10000);
		Assert.isTrue(result);
		
		
		his.clickVisitToDate("19-July-2017");
		Thread.sleep(10000);
		
	
		his.clickSearch();
		Thread.sleep(10000);
		
		
		boolean res=his.clickSoap();
		Assert.isTrue(res);	
		
		Thread.sleep(10000);
		his.closePdf();
		
		Thread.sleep(20000);
		his.close();
		
		
	}
     
	 @Test(priority = 2)
	public void invalidDates() throws InterruptedException{
		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		boolean result =his.clickVisitFomDate("10-May-2018");
		Thread.sleep(10000);
		Assert.isTrue(result);
	
		his.clickVisitToDate("19-July-2020");
		Thread.sleep(10000);
		
		his.clickSearch();
		Thread.sleep(10000);
		
		String s=his.errorMessage();
		
		Assert.isTrue(s.contains("No record"));
		
		Thread.sleep(10000);
		his.close();
			
	}
 
	 @Test(priority=3)
	public void AllClinic() throws InterruptedException, IOException{
		
		
		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		his.clickVisitFomDate("10-May-2016");
		Thread.sleep(10000);
	
		his.clickVisitToDate("19-July-2016");
		Thread.sleep(10000);
       
		his.clickSearch();
		Thread.sleep(10000);
		
		int n1=his.getTableSize();
		
		Thread.sleep(1000);
		his.clickClinics();
		Thread.sleep(10000);
		his.clickSearch();
		
		Thread.sleep(20000);
		int n2=his.getTableSize();
		
		Assert.isTrue(n1<n2);
		Thread.sleep(20000);
		his.close();
		
	}
	 
	@AfterClass
	public void afterClass() {
		driver.close();
	
	}

}
