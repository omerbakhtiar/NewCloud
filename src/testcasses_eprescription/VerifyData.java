package testcasses_eprescription;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.core.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;

public class VerifyData {
	
	WebDriver driver=new FirefoxDriver();
	boolean result;
	Epres sr= new Epres(driver);

	ArrayList<String> list = new ArrayList<String>() {{
	    add("PRE07 : Tx of Sensitive/Tooth");
	    add("GEN03 : Emergency Call");
	}};
	
	ArrayList<String> notes = new ArrayList<String>() {{
	    add("test");
	    add("testing 123");
	}};
	
	ArrayList<String> lab = new ArrayList<String>() {{
	    add("test");
	    add("testing 123");
	}};
	
	
	ArrayList<String> diag = new ArrayList<String>() {{
	    add("T40.7 : Cannabis (derivatives)");
	}};
	
	ArrayList<String> doz = new ArrayList<String>() {{
	    add("1.0");
	}};
	
	
	@Test(priority=1)
	public void verifyComplaint() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		sr.selectCancel();
		Thread.sleep(20000);
		sr.selectSeenPatient("1. Mr. Demo Pathologist ");
		
		Thread.sleep(10000);
	
	}
		/*sr.getComplaintData(list);
		Thread.sleep(20000);
		sr.getDoctorNotes("test congested tympanic membrane");
		Thread.sleep(10000);
	   }
	
	 @Test(priority=2)
	 public void verifyDieasesData() throws InterruptedException{
		  boolean result=sr.getDieasesData(list);
		  Assert.isTrue(result);
	 }
	 
	 @Test(priority=3)
	 public void verifyProcedureData(){
		 boolean pro=sr.getProcedureData(list,notes);
		 Assert.isLegal(pro);
	 }
	 */
	 
	/* @Test(priority=4)
	 public void verifyProcedureData() throws InterruptedException{
		 
		 //sr.clickOptionLabSet(2);
		 Thread.sleep(10000);
		 sr.verifyMedicineData(0);
		 sr.printData();
		 //boolean pro=sr.getLabData(list, notes);
		 //Assert.isLegal(pro);
	 }*/
	
	 @Test(priority=5)
	 public void verifyMedicine() throws InterruptedException{
		 Thread.sleep(1000);
		 sr.verifyMedicineData(0);
		 result=sr.verifyMedicine(diag,doz);
		 Thread.sleep(1000);
		 sr.printData();
		 System.out.println(result);
		 
	 }
  }

