package prescription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import patient.ChronicDisease;
import patient.Pateintvital;
import bookApointment.Appointment;
import framework.Login;

public class Epres {

	private WebDriver driver;
	boolean result;
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<WebElement> input = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	List<String> myList = new ArrayList<String>();
	List<String> notes = new ArrayList<String>();
	String s;
	
	 ArrayList<MedicineRecord> med = new ArrayList<MedicineRecord>();

	public Epres(WebDriver driv) {
		driver = driv;

	}

	public void clickEpres() throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.id("left-col"))
				.findElement(By.tagName("ul"))
				.findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele
				.findElements(By.tagName("li"));

		Thread.sleep(1000);
		divs.get(1).click();
	}

	public String Searching() throws IOException, InterruptedException {

		ArrayList<WebElement> arr = new ArrayList<WebElement>();
		driver.get("http://10.10.1.129:8080/web/cloudclinik/cc-login");

		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232884", "infogistic@1");

		Pateintvital vi = new Pateintvital(driver);
		Thread.sleep(20000);
		vi.searchPatient();

		Appointment app = new Appointment(driver);
		Thread.sleep(30000);

		arr = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:MyPatients_content"))
				.findElements(By.tagName("div"));
		Thread.sleep(2000);

		arr.get(2).findElement(By.tagName("input")).sendKeys("974100301865");

		Thread.sleep(30000);

		driver.findElement(
				By.xpath(".//*[@id='_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn']"))
				.click();

		Thread.sleep(10000);

		vi.clicktable();
		Thread.sleep(3000);

		String s = driver
				.findElement(
						By.xpath("//*[@id='_PatientHeader_WAR_CloudClinikportlet_:header_form:j_idt5_content']/div[1]/span[2]"))
				.getText().toString();
		System.out.println(s);
		Thread.sleep(1000);
		return s;

	}

	public void selectInsurance() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("document.querySelector('[id^='"+"_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable:0:j_"+"]').click()");

	}

	public void selectInsuranceOption() {
		ArrayList<WebElement> divs = (ArrayList<WebElement>) driver
				.findElements(By.className("ui-radiobutton "));

		ArrayList<WebElement> subdivs = (ArrayList<WebElement>) divs.get(1)
				.findElements(By.tagName("div"));
		subdivs.get(1).click();

	}

	public void clickCurrentPatient() {
		driver.findElement(By.linkText("Current Patient")).click();
	}

	public void selectCancel() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:cancel_pres_btn').click()");

	}

	public String selectSeenPatient(String name) throws InterruptedException {

		WebElement ele = driver
				.findElement(By
						.id("_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients"));
		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//*[@id='_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients:0:theLink']"))
				.click();

		// System.out.println(tr.size());

		/*
		 * for(int i=0;i<tr.size();i++){
		 * 
		 * if(driver.findElement(By.xpath(
		 * "//*[@id='_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients:"
		 * +i+":theLink']")).getText().contains(name)){
		 * tr.get(i).findElement(By.
		 * tagName("td")).findElement(By.tagName("a")).click();
		 * s="contains result"; }else{ s="does not contain result";
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * Thread.sleep(1000); js.executeScript(
		 * "document.getElementById(\'_Eprescription_WAR_CloudClinikportlet_:presc_form:cancel_pres_btn\').click()"
		 * );
		 * 
		 * }8/ }
		 */

		return s;
	}

	public Boolean getComplaintData(ArrayList<String> array) {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:complaints"))
				.findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		String s = li.get(0).getText().toString();

		System.out.println(s);

		for (int i = 0; i < array.size(); i++) {

			if (li.get(i).getText().contains(array.get(i))) {
				result = true;

			} else {
				result = false;

			}
		}

		return result;
	}

	public Boolean getDoctorNotes(String value) {
		String s = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:doc_notes_area"))
				.getText();

		if (s.contains(value)) {
			System.out.println(s);
			result = true;

		} else {
			result = false;
		}

		return result;
	}

	public Boolean getDieasesData(ArrayList<String> data)
			throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diseaseDT"))
				.findElement(By.tagName("tbody"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		System.out.println(tr.size());
		
	   for (int i = 0; i < tr.size(); i++) {
			String val = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:diseaseDT:"
							+ i + ":disease_hinput').value");
			
			System.out.println(val.toString());
			if (val.contains(data.get(i))) {
				result = true;
			} else {
				result = false;
			}

		}

		return result;

	}

    public Boolean getProcedureData(ArrayList<String> data,ArrayList<String> notes){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT"))
				.findElement(By.tagName("tbody"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			String val = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
							+ i + ":diagnostics_hinput').value");

			System.out.println(val.toString());
			
			if (val.contains(data.get(i))) {
				result = true;
			} else {
				result = false;
			}
		}
		
			for(int i=0;i<tr.size();i++){

				String note=(String) js.executeScript("return  document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc"
						+ "_form:diagnosticDT:"+i+":procedureNote').value");
				
				if(note.contains(notes.get(i))){
					result=true;
					System.out.println(note);
				
			}else {
				result=false;
			}
			}
		
		return result;
	}

    public void clickOptionLabSet(int index){
    	WebElement ele=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT_data"));
    	tr=(ArrayList<WebElement>) ele.findElements(By.tagName("tr"));
    	td=(ArrayList<WebElement>) tr.get(index).findElements(By.tagName("td"));
    	
    	td.get(0).findElement(By.tagName("div")).click();
    }
    
    
    public Boolean getLabData(ArrayList<String>lab ,ArrayList<String>notes){
    	boolean labs= driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:1:j_idt666:0:j_idt668")).isDisplayed();
    	WebElement reslt=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:0:loincResult"));
    	String res=reslt.getText();
    	
    	System.out.println(res);
    	
		return result;
	  
    }
    
    public void getLabSet(){
		WebElement ele = driver
				.findElement(By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT_data']/tr[4]/td/div/div[1]/div[1]"));
		
         System.out.println(ele.getText());
    	
    	
    }

	public void verifyMedicineData(int index) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement table = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT"))
						.findElement(By.tagName("tbody"));

		Actions actions = new Actions(driver);
		actions.moveToElement(table);

		tr = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));

		
		for(int i=0;i<tr.size();i++){
		String val = (String) js
				.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
						+ ":presc_form:medicationDT:"+i+":md_medicine_hinput').value");

		String diease = (String) js
				.executeScript("return document.getElementById('"
						+ "_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"+i+":j_idt684_label')"
						+ ".textContent");

		String dose = (String) js
				.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
						+ ":presc_form:medicationDT:"+i+":md_dozeId_input')"
						+ ".value;");

		String frequency = (String) js
				.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
						+ ":presc_form:medicationDT:"+i+":selectFreq_label')"
						+ ".textContent");

		String duration = (String) js
				.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
						+ ":presc_form:medicationDT:"+i+":md_duration_input')"
						+ ".value");
		
		String route=(String) js.executeScript("return document.getElementById('"
				+ "_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"+i+":"	+ "selectRoute_label')"+".textContent");


		String refills = (String) js
				.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
						+ ":presc_form:medicationDT:0:medicineRefills_input"
						+ "')" + ".value");
		
	     MedicineRecord record=new MedicineRecord(val,diease,dose,frequency,duration,route,refills);
	     
	     med.add(record);
		 
		}
	}
   
	public boolean verifyMedicine(ArrayList<String> dig, ArrayList<String> doz) {

		for (int i = 0; i < med.size(); i++) {
			
			if (med.get(i).getDiagnosis().contains(dig.get(i))
					&& med.get(i).getDoze().contains(doz.get(i))) {
				result = true;
				
			
				
			} else {
				result = false;
				
			}
		}

		return result;
	}
	
	
	
    public void printData(){
    	for(int i=0;i<med.size();i++){
    		System.out.println (med.get(i).getDiagnosis());
    		System.out.println (med.get(i).getDoze());
    	}
    }
}
