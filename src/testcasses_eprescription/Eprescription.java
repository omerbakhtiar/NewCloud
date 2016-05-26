package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import prescription.Epres;
import prescription.HistorEdit;
import prescription.QuickHistory;

public class Eprescription {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);

	@BeforeMethod
	public void beforeClass() {

	}

	@Test(priority = 1)
	public void verifyMrNumber() throws IOException, InterruptedException {
		Thread.sleep(20000);
		String s = sr.Searching();
		Thread.sleep(20000);
		driver.manage().window().maximize();

		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		his.clickVisitFomDate("10-May-2016");
		Thread.sleep(10000);
		
		his.clickVisitToDate("19-July-2017");
		Thread.sleep(10000);
		
		his.clickSearch();
		Thread.sleep(10000);
		
		his.clickSoap();
		
	}

	/*
	 * @Test(priority=1) public void verifyMrNumber() throws IOException,
	 * InterruptedException { Thread.sleep(20000); String s = sr.Searching();
	 * Assert.assertTrue(s.contains("9213061292")); Thread.sleep(20000);
	 * HistorEdit his=new HistorEdit(driver); his.selectHistory();
	 * Thread.sleep(20000); his.searchMr("9213061292"); Thread.sleep(10000);
	 * his.searchButton(); Thread.sleep(20000);
	 * driver.manage().window().maximize(); Thread.sleep(10000);
	 * his.selectCalender();
	 * 
	 * }
	 * 
	 * 
	 * /* @Test(priority=1) public void verifyMrNumber() throws IOException,
	 * InterruptedException { Thread.sleep(20000); String s = sr.Searching();
	 * Assert.assertTrue(s.contains("9213061292")); Thread.sleep(20000); }
	 * 
	 * @Test(priority=2) public void changeInsurance() throws IOException,
	 * InterruptedException { sr.selectInsurance(); Thread.sleep(10000);
	 * sr.selectInsuranceOption(); Thread.sleep(20000); }
	 */

	@AfterClass
	public void close() {
	}

}
