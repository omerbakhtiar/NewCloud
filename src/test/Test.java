package test;

import helper.Helper;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import bookApointment.Appointment;
import org.openqa.selenium.JavascriptExecutor;
import com.anteambulo.SeleniumJQuery.jQueryFactory;
import com.gargoylesoftware.htmlunit.BrowserVersion;

import framework.Login;

public class Test {

	private static ArrayList<WebElement> td = new ArrayList<WebElement>();

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
		Thread.sleep(10000);
		
		((JavascriptExecutor) driver).executeScript("$('#_58_login').val(300);");
		
		
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
			
			jq.query("[#_58_login]").val("Sle").submit();

		} finally {
			drv.close();
		}
	}

}