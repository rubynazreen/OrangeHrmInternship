package org.ictkerala.testcases;

import java.awt.AWTException;

import org.ictkerala.base.Base;
import org.ictkerala.pages.Login;
import org.ictkerala.pages.Pim;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends Base {

    Login login;
    Pim pim;

    @BeforeMethod 
    public void objinit() {
        login = new Login(driver);
        pim = new Pim(driver);
        login.loginusername("Admin");
        login.loginpassword("admin123");
        login.logbuttn();

    }

    @Test (priority=1)
    public void Login_positive()
    
    {
      
        login.verifydashboardpage();
        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
        System.out.println("DashBoard present");

    }
    @Test (priority=2)
    public void Login_negative1()
    
    {
    	  pim.logout();
        login.loginusername("Admin");
        login.loginpassword("admin");
        login.logbuttn();

            login.loginusername("admin1");
            login.loginpassword("admin123");
            login.logbuttn();
    
            login.loginusername("  ");
            login.loginpassword("  ");
            login.logbuttn();
            
      
            login.loginusername("  ");
            login.loginpassword("admin123");
            login.logbuttn();
            login.loginusername("Admin");
            login.loginpassword("   ");
            login.logbuttn();
      
            login.loginusername("ADMIN");
            login.loginpassword("admin123");
            login.logbuttn();
       
            login.loginusername("!@#$%^&*()");
            login.loginpassword(" !@#123");
            login.logbuttn();
        
    }
        
        
    

    @Test(priority=9)
    public void Pim_optional_field() throws InterruptedException
    {
    	
        pim.pim();
        pim.config();
        pim.optional();
        WebElement dashboardHeader = driver.findElement(By.xpath("//p[text()='Optional Fields']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
        System.out.println("Optional fields present");
        pim.optionalfield();
      
        
    }
    @Test(priority=10)
    public void Pim_custom_field() throws InterruptedException
    {
        pim.pim();
        pim.config();
        pim.custom();
        WebElement dashboardHeader = driver.findElement(By.xpath("//p[text()='Custom Fields']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
        System.out.println("Custom Fields present");
        pim.customfieldadd();
        pim.customfieldtext("phone number");
        pim.dropdown();
        pim.editrecord();
        pim.customeditname("Blood groups");
        pim.deleterecord();
       
        
    }
     /*   try {
			pim.dataimport("/OrangeHrmInternship/src/test/resources/Employee.csv");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

    @Test(priority=11)
    public void Pim_reporting_methods() throws InterruptedException
    {
    	
    	pim.pim();
        pim.reporting();
        WebElement dashboardHeader = driver.findElement(By.xpath("//p[text()='Reporting Methods']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
        System.out.println("Reporting Methods present");
        pim.reportingmethod("conduct");
        pim.reportedit("Test reportings");
        pim.reportdelete();
      
        
    }
    
    @Test(priority=12)
    public void Pim_termination_reasons() throws InterruptedException
    {
    
    	pim.pim();
    	pim.config();
        pim.termination();
        WebElement dashboardHeader = driver.findElement(By.xpath("//p[text()='Termination Reasons']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
        System.out.println("Termination Reasons present");
        pim.terminationreason("poor performance");
        pim.terminationedit("medical");
        pim.terminationdelete();
        }

    @AfterMethod
    public void logout()
    {
    	 
    }
@AfterTest
public void teardown() 
{
	 pim.logout();
    if (driver != null) {
        driver.quit();
    }
}
}
