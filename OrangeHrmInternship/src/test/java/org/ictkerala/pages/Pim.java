package org.ictkerala.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pim
{
	WebDriver driver;
	public Pim(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void pim()
	{
		WebElement pim = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		pim.click();
		System.out.println("clicked PIM");
	}
	public void config()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement configElement = wait.until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//span[text()='Configuration ']")));
		configElement.click();
		System.out.println("clicked CONFIGURATION");


	}
	public void optional()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement op= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Optional Fields']")));
		op.click();
		System.out.println("clicked OPTIONAL FIELD");
	}
	public void optionalfield() throws InterruptedException
	{
		
		
//click all switches at once
	
	 	List<WebElement> switches = driver.findElements(By.xpath("//span[contains(@class, 'oxd-switch-input')]"));

		for (WebElement sw : switches) {
		    new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(sw));
		    try {
		        sw.click();
		    } catch (ElementClickInterceptedException e) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sw);// javascript click
		    }
		}

		System.out.println("clicked all checkboxes");
		WebElement save=driver.findElement(By.xpath("//button[@type='submit']"));
		save.click();
		System.out.println("clicked save ");
		
	}
	public void custom()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cus= wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[normalize-space(text())='Custom Fields'])"))));
		cus.click();
		System.out.println("clicked custom field");
	}
	public void customfieldadd()
	
	{
		WebElement add=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		add.click();
		System.out.println("clicked  add button");
	}
	public void customfieldtext(String field_name)
	{
		// Enter field name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));
		field.click();
		field.clear();
		field.sendKeys(field_name);
		System.out.println("Field filled");

	}
	public void dropdown()
	{
		driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text')])[1]")).click();
		System.out.println("clicked dropdown ");
		// Then select the option from the dropdown
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions
		    .visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Personal Details']")));
		option.click();
		System.out.println("selected personal details ");
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
		System.out.println("clicked second dropdown ");
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement text= Wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@role='option']//span[text()='Text or Number']"))));
		text.click();
		System.out.println("selected option");
		WebElement submit=driver.findElement(By.xpath("//button[text()=' Save ']"));
		submit.click();		
	}
	public void editrecord()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click edit button
		WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[1]")));
		editIcon.click();
	}
	public void customeditname(String field_name)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Enter field name
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));
		field.clear();
		field.sendKeys(field_name);
		System.out.println("Field filled");

		// Click first dropdown
		WebElement firstDropdown = driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text')])[1]"));
		firstDropdown.click();
		System.out.println("Clicked first dropdown");

		// Select 'Personal Details'
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[@role='option']//span[text()='Personal Details']")));
		option.click();
		System.out.println("Selected 'Personal Details'");

		// Click second dropdown
		WebElement secondDropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		secondDropdown.click();
		System.out.println("Clicked second dropdown");

		
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[contains(@class,'oxd-select-text-input') and @tabindex='-1']")));
		text.click();
		System.out.println("Selected 'Dropdown'");

		// Click save
		WebElement submit = driver.findElement(By.xpath("//button[text()=' Save ']"));
		submit.click();
		System.out.println("Clicked save");
	}
	public void deleterecord()
	{

			WebElement delete=driver.findElement(By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[3]"));
			delete.click();
			System.out.println("Selected 'delete'");
			WebElement confirm=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
			confirm.click();
			System.out.println("confirmed delete");
	}
	public void dataimport(String file_path)throws AWTException 
	{
	
	        Robot robot = new Robot();
	        robot.delay(1000);

	        // Copy the path to clipboard
	        StringSelection selection = new StringSelection(file_path);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        // Press Ctrl + V
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.delay(500);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        // Press Enter
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	
	

	public void reporting()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement configElement = wait.until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//span[text()='Configuration ']")));
		configElement.click();
		System.out.println("clicked CONFIGURATION");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement repo=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-topbar-body-nav-tab-link' and text()='Reporting Methods']")));
		repo.click();
		System.out.println("Clicked Reporting methods");
		
	}
	public void reportingmethod(String report)
	{
		WebElement add=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		add.click();
		System.out.println("Clicked Add ");
		WebElement Name=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		Name.click();
		Name.sendKeys(report);
		System.out.println("filled name field ");
		WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		System.out.println("Clicked submit ");
				
	}
	public void reportedit(String report)
	{

		WebElement edit=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[1]"));
		edit.click();
		System.out.println("Clicked edit ");
		WebElement Name=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		Name.click();
		Name.sendKeys(report);
		System.out.println("edited name field ");
		WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		System.out.println("Clicked submit ");
	}
	public void reportdelete()
	{	
	WebElement delete=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-trash'])[3]"));
	delete.click();
	System.out.println("Selected 'delete'");
	WebElement confirm=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
	confirm.click();
	System.out.println("confirmed delete");
	}
	public void termination()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement configElement = wait.until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//span[text()='Configuration ']")));
		configElement.click();
		System.out.println("clicked CONFIGURATION");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement termin=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-topbar-body-nav-tab-link' and text()='Termination Reasons']")));
		termin.click();
		System.out.println("Clicked Termination");
				
	}
	public void terminationreason(String reason)
	{
		WebElement add=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		add.click();
		System.out.println("Clicked Add ");
		WebElement Name=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		Name.click();
		Name.sendKeys(reason);
		System.out.println("filled name field ");
		WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		System.out.println("Clicked submit ");
				
	}
	public void terminationedit(String report)
	{

		WebElement edit=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[3]"));
		edit.click();
		System.out.println("Clicked edit ");
		WebElement Name=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		Name.click();
		Name.sendKeys(report);
		System.out.println("edited name field ");
		WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		System.out.println("Clicked submit ");
	}
	public void terminationdelete()
	{	
	WebElement delete=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-trash'])[3]"));
	delete.click();
	System.out.println("Selected 'delete'");
	WebElement confirm=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
	confirm.click();
	System.out.println("confirmed delete");
	}
public void logout()
{
	WebElement userdrop=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
	userdrop.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	WebElement logout = wait.until(ExpectedConditions .visibilityOfElementLocated(By.linkText("/web/index.php/auth/logout")));
	logout.click();
}
}

