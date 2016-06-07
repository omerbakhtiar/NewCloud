package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.LabSet;
import prescription.VitalHistory;

public class Vital {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	LabSet set = new LabSet(driver);
	VitalHistory vital = new VitalHistory(driver);

	@Test(enabled=false)
	public void testDates() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(20000);

		driver.manage().window().maximize();
		Thread.sleep(20000);
		vital.clickVitalHistory();
		Thread.sleep(10000);
		vital.clickAddPatient();
		Thread.sleep(1000);
		vital.insertTemp("100");
		Thread.sleep(1000);
		vital.selectTempPoint("Ear");
		Thread.sleep(1000);
		vital.insertPulse("10");
		vital.insertBloodSugarData("20");
		vital.insertBpFirst("140");
		vital.insertBpSecond("110");
		vital.insertHeight("10");
		vital.clickFasting();
		vital.insertRespRate("30");
		vital.insertNotes("temp notes");
		vital.insertWeight("40");
		Thread.sleep(10000);
		vital.saveData();
		Thread.sleep(10000);
		vital.closeAddPatientVital();
		
	}

	@Test(enabled=false)
	public void search() throws InterruptedException {
		vital.insertFromDate("06-May-2016");
		Thread.sleep(1000);
		vital.visitToDate("08-Jun-2016");
		Thread.sleep(1000);
		vital.search();
		Thread.sleep(1000);
		vital.closeVitalHistory();
	}
	
	
	@Test
	public void testTable() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(20000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		vital.clickVitalHistory();
		Thread.sleep(1000);
		vital.getTableData(); 
		
	}
	
}
