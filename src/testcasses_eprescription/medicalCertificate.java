package testcasses_eprescription;

import java.io.IOException;

import org.eclipse.core.internal.runtime.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.LabHistory;
import prescription.MedicalCertificate;

public class medicalCertificate {
	
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);

	
   @Test(priority=1)
  public void enterData() throws InterruptedException, IOException {


		String s = sr.Searching();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		MedicalCertificate med=new MedicalCertificate(driver);
		med.selectCertificate();
		Thread.sleep(10000);
		
		med.insertNotes("testing notes");
		Thread.sleep(10000);
		
		med.insertLeaveDays("12");
		Assert.isTrue(driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:j_idt186")).isDisplayed());
		Thread.sleep(10000);
		med.submit();
		Thread.sleep(1000);
  }
  
  @AfterClass
  public void close(){
	  driver.quit();
	  
  }
}
