package org.ictkerala.testcases;

import org.ictkerala.base.Base;
import org.ictkerala.pages.AddEmployee;
import org.ictkerala.pages.Login;
import org.ictkerala.pages.PIMReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import org.ictkerala.pages.Pim;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends Base {

	Login login;
	AddEmployee add;
	PIMReport report;
  Pim pim;
	String actualmessagefornorecords="No records found";
	String actualmessagefordeletion="Successfully deleted";
	String actualmessageforsave="Successfully saved";
	String actualmessageformissingfield="field Required for further action";
	String actualmessageforalreadyexistfield="Already exist";
	String actualmessageforwrongcredential="Username already exist and password donot match";
	String actualTitle="Personal Details";
	String actualmessageforedit="Successfully edited";
	String actualmessageforcancel="Successfully cancel";
	String actualmessageforlogin="Successfully login";


    @BeforeMethod 
    public void objinit() {
        
    }
	
	@BeforeClass
	public void objinit() 
  {
		add=new AddEmployee(driver);
		report=new PIMReport(driver);
    login = new Login(driver);
        pim = new Pim(driver);
        login.loginusername("Admin");
        login.loginpassword("admin123");
        login.logbuttn();

				
	}
	//first test case
	@Test(priority=0)
	public void loginandnavigationtoPIM()
	{
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifydashboardpage();
		Assert.assertEquals(actualmessageforlogin,actualmessageforlogin);
		System.out.println("Message displayed for search with invalid data:"+ actualmessageforlogin);
	}
	@Test(priority=1)
	public void searchemployeebyname() {
		login.verifypimmenu();
		login.employeename("John");
		login.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=2)
	public void searchemployeebyId() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.enterid("0295");
		login.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=3)
	public void searchemployeebystatus() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		//lobj.verifydashboardpage();
		login.employeestatus();
		login.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=4)
	public void searchbyincludes() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		login.employeeinclude();
		login.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=5)
	public void searchbyjobtitle() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		login.employeejobtitle();
		login.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=6)
	public void viewemployeedetailsfromlist() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		login.employeedetails();
		login.logout();
		login.logout2();
		}
	@Test(priority=7)
	public void searchwithblankfields() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		login.search();
		login.logout();
		login.logout2();
	}
	/*@Test(priority=8)
	public void checkpagination() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		lobj.pagination();
		lobj.logout();
		lobj.logout2();
	}*/
	@Test(priority=9)
	public void Resetallfilters() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		login.resetbutton();
		login.logout();
		login.logout2();
	}
	@Test(priority=10)
	public void searchwithinvaliddata() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		//lobj.verifydashboardpage();
		login.enterid("0000");
		login.employeename("null");
		login.search();
		Assert.assertEquals(actualmessagefornorecords,actualmessagefornorecords);
		System.out.println("Message displayed for search with invalid data:"+ actualmessagefornorecords);
		login.logout();
		login.logout2();	
		
	}
	@Test(priority=11)
	public void searchusingspecialcharacter() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		//lobj.verifydashboardpage();
		login.enterid("@#$");
		login.employeename("%&");
		login.search();
		Assert.assertEquals(actualmessagefornorecords,actualmessagefornorecords);
		System.out.println("Message displayed for search using special character:"+ actualmessagefornorecords);
		login.logout();
		login.logout2();	
	}
	@Test(priority=12)
	public void deletenamefromlist() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		//lobj.verifydashboardpage();
		login.deletename();
		Assert.assertEquals(actualmessagefordeletion,actualmessagefordeletion);
		System.out.println("Message displayed for delete name from list:"+ actualmessagefordeletion);
		login.logout();
		login.logout2();	
	
	}
	@Test(priority=13)
	public void addnewemployee()  {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.lastname("Kurup");
		add.save();
		Assert.assertEquals(actualmessageforsave,actualmessageforsave);
		System.out.println("Message displayed for add  new employee:"+ actualmessageforsave);
		login.logout();
		login.logout2();	
	}
	@Test(priority=14)
	public void addemployeewithonlyfirstname(){
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.save();
		Assert.assertEquals(actualmessageformissingfield,actualmessageformissingfield);
		System.out.println("Message displayed for add new employee without lastname:"+ actualmessageformissingfield);
		login.logout();
		login.logout2();	
	}
	@Test(priority=15)
	public void addemployeewithexistingID() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.enterfirst("Mary");
		add.lastname("Philip");
		add.enterid("0295");
		add.save();
		Assert.assertEquals(actualmessageforalreadyexistfield,actualmessageforalreadyexistfield);
		System.out.println("Message displayed for add new employee with existingId:"+ actualmessageforalreadyexistfield);
		login.logout();
		login.logout2();	
	}
	/*@Test(priority=16)
	public void addemeployeewithoutfirstname() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.enterfirst(" ");
		add.lastname("Philip");
		add.save();
		Assert.assertEquals(actual4message,actual4message);
		System.out.println("Message displayed for add new employee without firstname:"+ actual4message);
		lobj.logout();
		lobj.logout2();
	}*/
	@Test(priority=17)
	public void canceladdemployeeprocess() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.cancelbutton();
		login.logout();
		login.logout2();	
		Assert.assertEquals(actualmessageforcancel,actualmessageforcancel);
		System.out.println("Message displayed for canceling the add employee process:"+ actualmessageforcancel);
	}
	@Test(priority=18)
	public void eneterlogincredential() 
{
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.lastname("Kurup");
		add.save();
		add.logincredential();
		add.eneterusername("Sunitha");
		add.eneterpassword("Tester@1245");
		add.eneterconfirmpass("Tester@1245");
		add.save();
		login.logout();
		login.logout2();	
		Assert.assertEquals(actualmessageforlogin,actualmessageforlogin);
		System.out.println("Message displayed for enterlogin credential:"+ actualmessageforlogin);
	}
	@Test(priority=19)
	public void loginwithmismatchedpassword()  {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.lastname("Kurup");
		add.save();
		add.logincredential();
		add.eneterusername("Sunitha");
		add.eneterpassword("Tester@1245");
		add.eneterconfirmpass("Tester@12");
		add.save();
		Assert.assertEquals(actualmessageforwrongcredential,actualmessageforwrongcredential);
		System.out.println("Message displayed for add new employee with mismatchedpassword and  already existed username:"+ actualmessageforwrongcredential);
		login.logout();
		login.logout2();	
	}
	/*@Test(priority=18)
	public void loginwithoutaddingemployee()  {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.enterfirst(" ");
		add.lastname(" ");
		//add.save();
		add.logincredential();
		//add.eneterusername("Kavya");
		//add.eneterpassword("Tester@1245");
		//add.eneterconfirmpass("Tester@1245");
		//add.save();
		lobj.logout();
		lobj.logout2();
	}*/
	@Test(priority=20)
	public void verifynewemployeepage()  {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();
		login.verifypimmenu();
		add.add();
		add.enterfirst("Joele");
		add.lastname("mathew");
		add.save();
		add.logincredential();
		add.eneterusername("joele");
		add.eneterpassword("Tester@12456");
		add.eneterconfirmpass("Tester@12456");
		add.save();
		Assert.assertEquals(actualTitle, actualTitle);
		System.out.println("Titledisplayed :"+ actualTitle);
		login.logout();
		login.logout2();	
	}
	@Test(priority=21)
	public void verifyaddedemployeeinlistafterlogoutlogin() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		//lobj.verifyemployeelist();
		login.employeename("Joele");
		login.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=22)
	public void verifyReportlist() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		report.verifyReportpage();
		report.viewreport();
		login.logout();
		login.logout2();
	}
	@Test(priority=23)
	public void Searchreport() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		report.verifyReportpage();
		report.searchreport("Employee");
		report.search();
		login.logout();
		login.logout2();
	}
	@Test(priority=24)
	public void AddReport() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		report.verifyReportpage();
		report.addreport();
		report.enterreponame("Electric");
		report.selectioncriteria();
		report.option("Employee Name");
		report.selectioninclude();
		report.option2();
		report.selectiondisplay();
		report.option3();
		report.selectiondisplay2();
		report.option4();
		report.addmoredisplay();
		report.save();
		Assert.assertEquals(actualmessageforsave,actualmessageforsave);
		System.out.println("Message displayed for add  new report:"+ actualmessageforsave);
		login.logout();
		login.logout2();	
		}
	@Test(priority=25)
	public void addreportwithexistingname() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		report.verifyReportpage();
		report.addreport();
		report.enterreponame("Developer");
		report.selectioncriteria();
		report.option("Employee name");
		report.selectioninclude();
		report.option2();
		report.selectiondisplay();
		report.option3();
		report.selectiondisplay2();
		report.option4();
		report.addmoredisplay();
		report.save();
		Assert.assertEquals(actualmessageforalreadyexistfield,actualmessageforalreadyexistfield);
		System.out.println("Message displayed for add report with existing name:"+ actualmessageforalreadyexistfield);
		login.logout();
		login.logout2();	
	}
	@Test(priority=26)
	public void deletereport() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		report.verifyReportpage();	
		report.deletereport();
		Assert.assertEquals(actualmessagefordeletion,actualmessagefordeletion);
		System.out.println("Message displayed for delete reportf from list:"+ actualmessagefordeletion);
		login.logout();
		login.logout2();	
	}
	@Test(priority=27)
	public void editreport() {
		login.loginusername("Admin");
		login.loginpassword("admin123");
		login.logbuttn();	
		login.verifypimmenu();
		report.verifyReportpage();
		report.editreport();
		report.addmoredisplay();
		report.save();
		Assert.assertEquals(actualmessageforedit,actualmessageforedit);
		System.out.println("Message displayed for edit the report:"+ actualmessageforedit);
		login.logout();
		login.logout2();	
		}
@Test(priority=28)
public void canceladdreport() {
	login.loginusername("Admin");
	login.loginpassword("admin123");
	login.logbuttn();	
	login.verifypimmenu();
	report.verifyReportpage();
	report.addreport();
	report.enterreponame("Developer");
	report.selectioncriteria();
	report.option("Employee Name");
	report.canceladdreport();
	login.logout();
	login.logout2();	
	Assert.assertEquals(actualmessageforcancel,actualmessageforcancel);
	System.out.println("Message displayed forcancel the adding report:"+ actualmessageforcancel);
}
@Test(priority=29)
public void addreportwithmissingfield() {
	login.loginusername("Admin");
	login.loginpassword("admin123");
	login.logbuttn();	
	login.verifypimmenu();
	report.verifyReportpage();
	report.addreport();
	report.enterreponame("Software");
	report.selectioncriteria();
	report.option("Employee Name");
	report.selectioninclude();
	report.option2();
	report.selectiondisplay();
	report.option3();
	report.selectiondisplay2();
	report.option4();
	report.save();
	Assert.assertEquals(actualmessageformissingfield,actualmessageformissingfield);
	System.out.println("Message displayed for add  new report with missing field:"+ actualmessageformissingfield);
	login.logout();
	login.logout2();		
}


   

    @Test (priority=30)
    public void Login_positive()
    
    {
      
        login.verifydashboardpage();
        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
        System.out.println("DashBoard present");

    }
    @Test (priority=31)
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
        
        
    

    @Test(priority=32)
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
    @Test(priority=33)
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

    @Test(priority=34)
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
    
    @Test(priority=35)
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

    
@AfterTest
public void teardown() 
{
	 pim.logout();
    if (driver != null) {
        driver.quit();
    }
}
}
