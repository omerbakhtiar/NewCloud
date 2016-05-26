package prescription;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import patient.ChronicDisease;
import patient.Pateintvital;
import bookApointment.Appointment;
import framework.Login;

public class Epres {

	private WebDriver driver;

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
		driver.get("http://192.168.1.6:8080/web/cloudclinik/cc-login");

		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232884", "infogistic@1");

		Pateintvital vi = new Pateintvital(driver);
		Thread.sleep(20000);
		vi.searchPatient();

		Appointment app = new Appointment(driver);
		Thread.sleep(20000);

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
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_PatientHeader_WAR_CloudClinikportlet_:header_form:j_idt31').click()");

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

	public void selectCancel() throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:cancel_pres_btn').click()");
		
	}
	
}
