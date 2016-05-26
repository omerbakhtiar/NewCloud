package framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public WebDriver driver;

	@FindBy(id = "_58_login")
	private WebElement idn;

	@FindBy(id = "_58_password")
	private WebElement password;
	
	

	public Login(WebDriver driver1) throws IOException {

		this.driver = driver1;
		PageFactory.initElements(driver, this);
	}

	public void Logincredentials(String id, String pass)
			throws InterruptedException {
		idn.sendKeys(id);
		password.sendKeys(pass);
		
        Thread.sleep(1000);
        driver.findElement(By.className("button-holder ")).findElement(By.tagName("button")).submit();
	}

	public void RegisterLink() {

		driver.findElement(By.className("cc_DesktopLogin")).click();
	}
	
	
	public void clickPatient(){
		
		driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:form:btn_select_patient")).submit();
	}


	
}
