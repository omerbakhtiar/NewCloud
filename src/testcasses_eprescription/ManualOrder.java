package testcasses_eprescription;

import java.io.IOException;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class ManualOrder {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	OrderSet order = new OrderSet(driver);

 	@Test(priority = 1)
	public void complaints() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		order.selectOrderSet();
		Thread.sleep(10000);
		order.clickAddNew();
		Thread.sleep(10000);
		order.setComplaints("nauzia");
		Thread.sleep(10000);
		order.setDoctorNotes("test notes");
		Thread.sleep(1000);
		order.setOrderSetName("dengue");
		Thread.sleep(20000);
		order.clickTemplates();
		Thread.sleep(10000);
		order.addTemplate();
		Thread.sleep(1000);
		order.closeNotesTemplate();
		Thread.sleep(10000);
	 
	  }
	  @Test(priority=2)
	  public void setDisease() throws InterruptedException{
	   order.addDisease();
	   Thread.sleep(1000);
	   order.addDieaseData("T40.7");
	   Thread.sleep(20000);
	  }
	  
	  @Test(priority=3)
	  public void setProcedureData() throws InterruptedException{
	    order.addProcedureClick();
	    Thread.sleep(10000);
	    order.addProcedureData("GEN03");
	    Thread.sleep(10000);
	    order.addProcedureNote("testing note for the procedure");
	    Thread.sleep(10000); 
	  }
	  
	  @Test(priority=4)
	  public void setLab() throws InterruptedException{
	   order.addLabButton();
	   Thread.sleep(20000);
	   order.labSetData("MLABSET01",0);
	   Thread.sleep(10000);
	   order.setLabsetInstructions("testing instructiong lab test manual",0);
	   Thread.sleep(2000);
	   order.addLabButton();
	   Thread.sleep(10000);
	   order.labSetData("Long Name of Manual Lab",1);
	   Thread.sleep(1000);
	   order.setLabsetInstructions("testing instructions lab test manual", 1);
	   Thread.sleep(1000);
	  }

	
 	 @Test(priority=4)
	  public void setMedicine() throws InterruptedException{
	   order.addMedicieneButton();
	   Thread.sleep(10000);
	   order.setMedicineData("panadol ADVANCE", 0);
	   Thread.sleep(1000);
	   order.insertDosageUnit("10", 0);
	   Thread.sleep(10000);
	   order.setMedicineFrequency(0, 1);
	   Thread.sleep(1000);
	  order.setMedicineDuration("10", 0);
	   Thread.sleep(1000);
	   order.setMedicineRoute(2);
	   Thread.sleep(1000);
	   order.save();
	   Thread.sleep(10000);
	   order.closeOrderSetDiaglog();
	  }
 	 
 	  @Test(priority=5)
 	  public void applyOrderSet() throws InterruptedException{
 		  order.selectOrderSet();
 		  Thread.sleep(10000);
 		  order.applyOrderSet("dengue");
 		  Thread.sleep(10000);
 		  order.closeOrderSetMainWindow();
 		  Thread.sleep(10000);
 		  driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:btn_presc_save_only")).submit();
 		  Thread.sleep(1000);
 		  driver.close();
 	  }
 	 
	}

