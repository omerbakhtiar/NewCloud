package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.LabHistory;
import prescription.MedicalCertificate;

public class medicalCertificate {
	
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);

	
   @Test(enabled = false)
  public void enterData() throws InterruptedException, IOException {

	   Thread.sleep(20000);
	    
		String s = sr.Searching();
		Thread.sleep(20000);
		driver.manage().window().maximize();
		Thread.sleep(20000);
		
		MedicalCertificate med=new MedicalCertificate(driver);
		med.selectCertificate();
		Thread.sleep(10000);
		
		med.insertNotes("testing notes");
		Thread.sleep(10000);
		
		med.insertLeaveDays("12");
		Thread.sleep(10000);
		
		med.submit();
		
  }
  
   @Test
  public void insertLabHistory() throws IOException, InterruptedException{
	    String s = sr.Searching();
		Thread.sleep(20000);
		
		driver.manage().window().maximize();
		Thread.sleep(20000);
		
		LabHistory lab=new LabHistory(driver);
		lab.selectLabHis();
		Thread.sleep(20000);
		
		lab.selectFromDate("15-May-2016");
		Thread.sleep(10000);
		
		lab.selectVisitDate("16-May-2017");
		Thread.sleep(10000);
	  
		lab.Search();
		Thread.sleep(10000);
		
		lab.AddResult();
		Thread.sleep(10000);
		
		lab.insertComments("testing comments");
		Thread.sleep(2000);
		
		lab.insertResult("test resuls");
		Thread.sleep(1000);
		
		lab.submitResult();
		Thread.sleep(100000);
		
		lab.close();
			
  }
  
  public void showMessage(){
	  
  }
}
