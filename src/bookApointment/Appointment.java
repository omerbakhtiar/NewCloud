package bookApointment;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import framework.ReadExcel;

public class Appointment {

	private  WebDriver driver;
	
	private ArrayList<WebElement> divs = new ArrayList<WebElement>();
	private ArrayList<WebElement> a = new ArrayList<WebElement>();
	private ArrayList<WebElement> td = new ArrayList<WebElement>();
	private ArrayList<WebElement> tr = new ArrayList<WebElement>();
	private ArrayList<WebElement> ul = new ArrayList<WebElement>();
	private ArrayList<WebElement> td2 = new ArrayList<WebElement>();
	
	
	public Appointment(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ArrayList<ReadExcel> lst = new ArrayList<ReadExcel>();

	}
	
	public void selectAppointmentCal() throws InterruptedException{
		
		Thread.sleep(10000);	
		WebElement element=driver.findElement(By.id("myId"));
		divs = (ArrayList<WebElement>) element.findElements(By.tagName("li"));
		divs.get(0).findElement(By.tagName("a")).click();		
		
	}
		
	public void selectVisit() throws InterruptedException{

		Thread.sleep(10000);
		
		//_AppointmentCalender_WAR_CloudClinikportlet_:form:app:0:dynaButton
		tr =(ArrayList<WebElement>)driver.findElement(By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app")).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		td=(ArrayList<WebElement>) tr.get(0).findElements(By.tagName("td"));
		td.get(9).findElement(By.tagName("div")).click();
		
	}

    public void  bookAppointments(){
    	WebElement element =driver.findElement(By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app:0:appCalenderManu")).
    						findElement(By.tagName("ul"));
    	
    	ul=(ArrayList<WebElement>) element.findElements(By.tagName("li"));
    	ul.get(0).findElement(By.tagName("a")).click();
    }

    public void searchidy(String id){
    	 WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(3).findElement(By.tagName("input")).sendKeys(id);
    }

    public void searchMr(String mr){
    	
    	 WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(6).findElement(By.tagName("input")).sendKeys(mr);
    }
    
    public void searchPatientName(String patient){
    	
    	 WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(8).findElement(By.tagName("input")).sendKeys(patient);
    }
    public void searchContactNumber(String contact){

    	WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(11).findElement(By.tagName("input")).sendKeys(contact);
    	
    }
    
    public void searchFileNumber(String number){
    	WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(13).findElement(By.tagName("input")).sendKeys(number);
    }

    public void otherIdentification(String otherid){
    	WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(15).findElement(By.tagName("input")).sendKeys(otherid);
    }

    public void setPurposeVisit(String purpose){
    	WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	 td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	 td.get(8).findElement(By.tagName("input")).sendKeys(purpose);
    	
    }
    
    public void clickSearchButton() throws InterruptedException{
    	  WebElement ele=driver.findElement(By.className("prescription-patient")).findElement(By.className("row"));
	   	   td=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
	   	   td.get(17).findElement(By.tagName("button")).click();
		   Thread.sleep(5000);
    	
    }
    
    public void selectAppointment() throws InterruptedException{
      driver.findElement(By.xpath("//*[@id='_AppointmentCalender_WAR_CloudClinikportlet_:searchtbl_data']/tr/td[1]")).click();
    	Thread.sleep(10000);
    }
}