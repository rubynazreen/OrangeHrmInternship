package org.ictkerala.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrangeHrmLogin {

	WebDriver driver;
	public OrangeHrmLogin(WebDriver driver) {
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
	
	public void verifyrecruitmentmenu() 
	{	
		WebElement recruitmentmenu=driver.findElement(By.xpath("//span[text()='Recruitment']"));
		Assert.assertTrue(recruitmentmenu.isDisplayed(), "'Recruitment' menu is not displayed");
		recruitmentmenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 4. Verify that the URL contains "/recruitment"
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/recruitment"), "URL does not contain '/recruitment'");
    }
	public void recruitmentTitle() 
	{
		
	}
	}
	
