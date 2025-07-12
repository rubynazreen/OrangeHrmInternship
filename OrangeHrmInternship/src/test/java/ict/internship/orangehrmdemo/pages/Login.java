package ict.internship.orangehrmdemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void loginusername(String uname) {
		WebElement orglogin=driver.findElement(By.xpath("//input[@name='username']"));
		orglogin.sendKeys(uname);		
	}
	public void loginpassword(String pass) {
		WebElement orgpass=driver.findElement(By.xpath("//input[@type='password']"));
		orgpass.sendKeys(pass);	
	}
	public void logbuttn() {
		WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
	}
	public void verifydashboardpage() {
		
		// Wait up to 10 seconds for dashboard to load
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Check that URL contains "/dashboard"
		String currenturl=driver.getCurrentUrl();
		if (!currenturl.contains("/dashboard")) {
	        throw new AssertionError("URL does not contain '/dashboard'");
	    }
		// Check that the Dashboard  header is visible
		WebElement dashboardheader=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		 if (!dashboardheader.isDisplayed()) {
		        throw new AssertionError("Dashboard header is not visible");
		    }
	}
	
	public void verifypimmenu() 
	{	
		WebElement pimmenu=driver.findElement(By.xpath("//span[text()='PIM']"));
		Assert.assertTrue(pimmenu.isDisplayed(), "'PIM' menu is not displayed");
		pimmenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		// 4. Verify that the URL contains "/recruitment"
       // String currentUrl = driver.getCurrentUrl();
       // Assert.assertTrue(currentUrl.contains("/recruitment"), "URL does not contain '/recruitment'");
    }
	//public void verifyemployeelist(){
		//WebElement empllist=driver.findElement(By.id("Employee List"));
		//empllist.click();
	//}
	public void employeename(String name){
		WebElement entname=driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		entname.sendKeys(name);
	}
	public void search(){
		WebElement srchname=driver.findElement(By.xpath("//button[@type='submit']"));
		srchname.click();
	}
	public void enterid(String id){
		WebElement entid=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		entid.sendKeys(id);
	}
	public void logout(){
		WebElement lgt=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
	lgt.click();}
	public void logout2() {
	WebElement lgt2=	driver.findElement(By.xpath("(//a[@role='menuitem'])[4]"));
		lgt2.click();
	}
	public void employeestatus(){
		WebElement emstatus=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
	emstatus.click();
	driver.findElement(By.xpath("(//div[normalize-space()='Full-Time Permanent'])[1]"));
	}
	public void employeeinclude(){
		WebElement eminclude=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
	eminclude.click();
	driver.findElement(By.xpath("(//div[normalize-space()='Current Employees Only'])[1]"));
	}
	public void employeejobtitle(){
		WebElement emjob=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]"));
		emjob.click();
		driver.findElement(By.xpath("(//div[@tabindex='0'])[3]"));
		
	}
	
	public void employeedetails(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement empdet=driver.findElement(By.xpath("(//button[@type='button'])[6]"));
		
	empdet.click();
	}
	public void pagination(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement pgn=driver.findElement(By.xpath("(//button[@type='button'])[107]"));
		pgn.click();
	}
public void resetbutton(){
	WebElement rstbtn=driver.findElement(By.xpath("//button[@type='reset']"));
	rstbtn.click();
}
public void errormessage(){
	WebElement errormsg=driver.findElement(By.id("No Records Found"));
	String actualmessage=errormsg.getText();
}
public void deletename(){
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement dtl=driver.findElement(By.xpath("(//button[@type='button'])[7]"));
	dtl.click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]/i")).click();
}
public void cancelbutton(){
	WebElement cancel=driver.findElement(By.xpath("(//button[@type='button'])[5]"));
	cancel.click();
}

	{
		
	}
	}
	
