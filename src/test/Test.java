package test;

import helper.Helper;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import bookApointment.Appointment;

import org.openqa.selenium.JavascriptExecutor;

import com.anteambulo.SeleniumJQuery.jQueryFactory;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import framework.Login;

public class Test {

	private static ArrayList<WebElement> td = new ArrayList<WebElement>();

	public static void main(String[] args) throws Exception {
		
		System.out.println("document.querySelector('[id^=\"_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:comments"+"\"]').value="+1+";");
		
		
	/*	WebDriver driver=new FirefoxDriver();
		driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
		Thread.sleep(10000);
	
		((JavascriptExecutor) driver).executeScript("$('div #_58_login').val('test');");
		
	/*	JavascriptExecutor jse = (JavascriptExecutor)driver;
		URL jqueryUrl = Resources.getResource("jquery-1.8.2.min.js");
		String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
		jse.executeScript(jqueryText);
		jse.executeScript("$('div input').val('new');");
		
		
	
	//	((JavascriptExecutor) driver).executeScript("$('#yui_patched_v3_11_0_1_1464716239280_170 input').val('new');");
		
	/*	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cloudclinik.pk/web/cloudclinik");

		// ReadExcel excel=new ReadExcel(driver);
		// excel.ReadData(2);
		// excel.Call(0);

		Login log = new Login(driver);
		log.RegisterLink();
		Thread.sleep(5000);
		log.Logincredentials("9213053774", "infogistic1");
		Thread.sleep(5000);

		Appointment app = new Appointment(driver);
		app.selectAppointmentCal();
		app.selectVisit();
		app.bookAppointments();
		Thread.sleep(5000);

		Helper help = new Helper(driver);
		help.WindowHandles();
		Thread.sleep(5000);
		// app.searchMr("974100234977");
		app.searchContactNumber("3454391379");
		Thread.sleep(10000);
		app.clickSearchButton();
		Thread.sleep(20000);
		app.selectAppointment();
*/
		//testJQuery();
	}

	private static void testJQuery() throws Exception {
		
		HtmlUnitDriver drv = new HtmlUnitDriver(BrowserVersion.FIREFOX_3_6);
		drv.setJavascriptEnabled(true);
		try {
			jQueryFactory jq = new jQueryFactory();
			jq.setJs(drv);

			drv.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
			
			jq.query("[#_58_login]").val("Sle");

		} finally {
			drv.close();
		}
	}

}