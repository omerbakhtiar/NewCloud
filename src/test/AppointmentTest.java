package test;

import java.io.IOException;

import framework.Login;
import helper.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bookApointment.Appointment;

public class AppointmentTest {
	
	WebDriver driver;
	
  @BeforeTest
  public void before() throws IOException, InterruptedException{
  }
 
  @Test(priority=1)
  public void searchContact() throws IOException, InterruptedException {
	  
	    WebDriver driver=new FirefoxDriver();	 
	    driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
	  	Login log=new Login(driver);
		Thread.sleep(5000);
		log.Logincredentials("9213053774","infogistic1");
		Thread.sleep(5000);
		Appointment app=new Appointment(driver);
		app.selectAppointmentCal();
		app.selectVisit();
		app.bookAppointments();
		Thread.sleep(5000);
		
		 Helper help=new Helper(driver);
		 help.WindowHandles();
		 Thread.sleep(5000);
		//app.searchMr("974100234977");
		 app.searchContactNumber("3454391379");
		 Thread.sleep(10000);
		 app.clickSearchButton();
		 Thread.sleep(20000);
		 app.selectAppointment();
  }
  
 /* @Test(priority=2)
  public void searchMr() throws IOException, InterruptedException {
	  
		Appointment app=new Appointment(driver);
		app.selectAppointmentCal();
		app.selectVisit();
		app.bookAppointments();
		Thread.sleep(5000);
		
		 Helper help=new Helper(driver);
		 help.WindowHandles();
		 Thread.sleep(5000);
		 app.searchMr("974100234977");
		 Thread.sleep(10000);
		 app.clickSearchButton();
		 Thread.sleep(20000);
		 app.selectAppointment();
  }
  */
/*  @Test(priority=3)
  public void invalidsearchMr() throws IOException, InterruptedException {
	  
		Appointment app=new Appointment(driver);
		Thread.sleep(10000);
		app.selectAppointmentCal();
		app.selectVisit();
		app.bookAppointments();
		Thread.sleep(5000);
		
		 Helper help=new Helper(driver);
		 help.WindowHandles();
		 Thread.sleep(5000);
		 app.searchMr("97addbb");
		 Thread.sleep(10000);
		 app.clickSearchButton();
		 Thread.sleep(20000);
  }
  */
}
