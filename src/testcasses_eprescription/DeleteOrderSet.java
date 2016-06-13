package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class DeleteOrderSet {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	OrderSet order = new OrderSet(driver);
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test(enabled = false)
	public void deleteOrderSet() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		order.selectOrderSet();
		Thread.sleep(10000);
		order.deleteOrderSet("dengue");
	}
		

	@Test(priority = 1)
	public void deleteComplaints() throws InterruptedException, IOException {
		String s = sr.Searching();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		order.selectOrderSet();
		Thread.sleep(1000);
		order.editOrderSet("dengue");
		Thread.sleep(10000);
		order.deleteComplaints();
	}
	
		

	@Test(priority = 2)
	public void deleteDoctorNotes() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:doc_notes_area"))
				.clear();
	}

	@Test(priority = 3)
	public void deleteDiease() throws IOException, InterruptedException {
		;
		Thread.sleep(10000);
		order.deleteDiseases();
	}

	@Test(priority = 4)
	public void deleteProcedure() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteProcedure();
	}

	@Test(priority = 5)
	public void deleteLabSet() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteLabSet();
	}

	@Test(priority = 6)
	public void deleteMedicine() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteMedicine();
	}

	@Test(priority = 7)
	public void deleteDiet() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteInstruction();
		Thread.sleep(1000);
		order.clickUpdate();
		Thread.sleep(10000);
		order.closeMainWindow();
	}

	

private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }


}

