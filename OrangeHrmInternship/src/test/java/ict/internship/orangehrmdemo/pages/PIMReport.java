package ict.internship.orangehrmdemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMReport extends Login {

public PIMReport(WebDriver driver) {
	super(driver);
}
public void verifyReportpage() {
	WebElement report=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/a"));
	report.click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
}
public void viewreport() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement view=driver.findElement(By.xpath("(//button[@type='button'])[9]"));
	view.click();
}
/*public void searchreport(String Search) {
	WebElement search=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
	search.sendKeys(Search);
	try {
		Thread.sleep(1000); // or use ExpectedConditions if dynamic suggestions have a container
		search.sendKeys(Keys.ARROW_DOWN);
		search.sendKeys(Keys.ENTER);
	} catch (Exception e) {
		e.printStackTrace();
	}*/
public void searchreport(String Search) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Step 1: Locate and type in the search input
    WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//input[@placeholder='Type for hints...']")));
    search.click();
    search.clear();
    search.sendKeys(Search);

    // Step 2: Wait for dropdown and select first suggestion
    try {
        Thread.sleep(1000); // Let the dropdown load
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.ENTER);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Step 3: Click the Search button
    WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
    searchButton.click();

    // Step 4: Wait for the results table to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@class='oxd-table-body']")));
}
public void addreport() {
	WebElement adrepo=driver.findElement(By.xpath("(//button[@type='button'])[6]"));
	adrepo.click();
}
public void enterreponame(String name) {
	WebElement namerepo=driver.findElement(By.xpath("//input[@placeholder='Type here ...']"));
	namerepo.sendKeys(name);
}
public void selectioncriteria() {
	WebElement selcri=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
	
	selcri.click();
}
public void option(String value) {
	WebElement opt=driver.findElement(By.xpath("(//div[normalize-space()='"+value+"'])[1]"));
	opt.click();
}
/*public void selectSelectionCriteria() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Step 1: Wait for the dropdown arrow
    WebElement selcri = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")));
    
    // Scroll and click dropdown using JS (to avoid intercepted error)
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selcri);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selcri);

    // Step 2: Wait for and click the option
    WebElement opt = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("(//div[normalize-space()='Employee Name'])[1]")));
    opt.click();
}*/

public void selectioninclude() {
	WebElement selincl=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
	selincl.click();
}
public void option2() {
WebElement option2=driver.findElement(By.xpath("(//div[normalize-space()='Current Employees Only'])[1]"));
option2.click();
}
public void selectiondisplay() {
	WebElement seldisp=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]"));
	seldisp.click();
}
public void option3() {
	WebElement option3=driver.findElement(By.xpath("(//div[normalize-space()='Contact Details'])[1]"));
	option3.click();

}
public void selectiondisplay2() {
	WebElement seldisp2=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]"));
	seldisp2.click();
}
public void option4() {
	WebElement option4=driver.findElement(By.xpath("(//div[@tabindex='0'])[4]"));
	option4.click();
}
public void addmoredisplay() {
	WebElement admo=driver.findElement(By.xpath("(//button[@class='oxd-icon-button orangehrm-report-icon'])[2]"));
	admo.click();
}
public void save() {
	WebElement sv=driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]"));
	sv.click();
}
public void deletereport(){
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement dtl2=driver.findElement(By.xpath("(//button[@type='button'])[7]"));
	dtl2.click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
}
public void editreport() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement edit=driver.findElement(By.xpath("(//button[@type='button'])[8]"));
	edit.click();
}
public void canceladdreport() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement cancelarepo=driver.findElement(By.xpath("(//button[@type='button'])[6]"));
	cancelarepo.click();
}}