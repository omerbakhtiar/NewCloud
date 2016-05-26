package prescription;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OrderSet {

	WebDriver driver;
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();

	public OrderSet(WebDriver driv) {
		driver = driv;
	}

	public void selectOrderSet() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:btn_os"))
				.click();

	}

	public void clickAddNew() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:orderSetForm:j_idt75').click()");

	}

	public void setOrderSetName(String name) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:OrderSetName"))
				.sendKeys(name);

	}

	public void setComplaints(String complaint) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:complaints_input"))
				.sendKeys(complaint);
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:complaints_input"))
				.sendKeys(Keys.ENTER);
	}

	public void setDoctorNotes(String notes) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:doc_notes_area"))
				.sendKeys(notes);
	}

	public void clickTemplates() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:osApplyTemplateBtn"))
				.click();
	}

	public void addTemplate() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_nt_form:dt_nt:0:osNotesTemplateLink"))
				.click();

	}

	public void addDisease() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:addDisease').click()");

	}

	public void clickFavoriteDisease() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(200000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseFavoriteBtn').click()");

	}

	public void addDieaseData(String diease) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT:0:disease_input"))
				.sendKeys(diease);
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT:0:disease_input"))
				.sendKeys(Keys.ENTER);

	}

	public void favouriteDieaseData(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:searchIcd"))
				.sendKeys(data);
	}

	public void favouriteSearch() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:searchFavoriteDisseaseBtn"))
				.click();
	}

	public void selectFavouriteSearch() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.linkText("K02.1:Caries of dentine")).click();
	}

	public void addProcedureTreatment() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addDiagnositic"))
				.click();
	}

	public void closeNotesTemplate() {
		driver.findElement(
				By.xpath("//div[@id='_Eprescription_WAR_CloudClinikportlet_:j_idt64']/div/a/span"))
				.click();

	}

	public void save() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:os_btn_presc_sign').click()");

	}

	public void closeFavoriteDiaglog() {
		driver.findElement(
				By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:j_idt24']/div[1]/a"))
				.click();
	}

	public void closeDialogButtonFavorite() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:closeDiseaseFavoritePopup"))
				.click();
	}

	public void addProcedureClick() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addDiagnositic"))
				.click();
	}

	public void addProcedureData(String data) throws InterruptedException {
		// GEN03 : Emergency Call
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:0:diagnostics_input"));
		ele.sendKeys(data);
		Thread.sleep(5000);
		ele.sendKeys(Keys.ENTER);
	}

	public void addProcedureNote(String note) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:0:osProcedureNote"))
				.sendKeys(note);
	}

	public void clickFavoriteProcedure() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:favoriteDiagnostic').click()");
	}

	public void sendFavoriteProcedure(String data) {
		// INS65 : Tmj Appliance For Tounge Habit
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:searchCpt"))
				.sendKeys(data);
	}

	public void searchFavoriteSearchProcedure() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:searchFavProcedureBtn"))
				.click();
	}

	public void selectFarovriteSearchDataProcedure() {
		driver.findElement(
				By.linkText("INS65 : Tmj Appliance For Tounge Habit")).click();
	}

	public void selectFavoriteSearchClose() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:closeDiagnosticFavoritePopup"))
				.click();
	}

	public void closeOrderSetDiaglog() {
		((JavascriptExecutor) driver)
				.executeScript("$('.ui-dialog-titlebar-icon').click();");
	}

	public void setFavoriteProcedureNote(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:1:osProcedureNote"))
				.sendKeys(data);
	}

	public void addLabButton() {
		driver.findElement(By
				.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addLoinc"));
	}

	public void labSetData(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:0:loincCode_input"))
				.sendKeys(data);
	}

	public void setLabInstructions(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:0:loincInstructions"))
				.sendKeys(data);
	}

	public void clickFavoriteButton() {
		driver.findElement(By
				.id("Eprescription_WAR_CloudClinikportlet_:os_form:applyFavoriteLoinc"));
	}

	public void searchFavoriteLab(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchLoinc"))
				.sendKeys(data);
	}

	public void clickSearchFavoriteLab() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchFavPrLabBtn"))
				.click();
	}

	public void selectFavoriteSearchValueLabandSet(String data) {
		// 1002 lab set
		// 5866-9 lab
		driver.findElement(By.linkText(data)).click();
	}

	public void searchFavoriteLab() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchFavPrLabBtn"))
				.click();
	}

	public void closeLabFavorite() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:closeLoincFavoritePopup"))
				.click();
	}

	public void setLabsetInstructions(String labset) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
						+ 0 + ":loincInstructions")).sendKeys(labset);
	}

	public void setLabInstruction(String lab) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
						+ 1 + ":loincInstructions")).sendKeys(lab);
	}
	
	public void addMedicine(String med){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addMedicationBtn")).click();
	}
	
    public void setMedicineData(String data){
    	driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:md_medicine_input")).sendKeys(data);
    }
    
    public void insertDosageUnit(String data){
    	driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:dozeId_input")).sendKeys(data);
    }
    
    
    
    
	public void applyOrderSet(String templateName) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		row = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset_data"))
				.findElements(By.tagName("tr"));
		for (int i = 0; i < row.size(); i++) {

			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			String id = "_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset"
					+ ":" + i + ":j_idt84";
			WebElement ele = driver.findElement(By.id(id));

			if (td.get(1).getText().contains(templateName)) {
				jse.executeScript("arguments[0].click()", ele);
			}
		}
	}

	public void closeOrderSetMainWindow() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:orderSetForm:j_idt90').click()");
	}

}
