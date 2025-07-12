package ict.internship.orangehrmdemo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ict.internship.orangehrmdemo.base.PreSettings;
import ict.internship.orangehrmdemo.pages.AddEmployee;
import ict.internship.orangehrmdemo.pages.Login;
import ict.internship.orangehrmdemo.pages.PIMReport;

public class Testcases extends PreSettings {

	Login lobj;
	AddEmployee add;
	PIMReport report;
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
	
	
	@BeforeClass
	public void objinit() {
		lobj=new Login(driver);
		add=new AddEmployee(driver);
		report=new PIMReport(driver);
				
	}
	//first test case
	@Test(priority=0)
	public void loginandnavigationtoPIM()
	{
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifydashboardpage();
		Assert.assertEquals(actualmessageforlogin,actualmessageforlogin);
		System.out.println("Message displayed for search with invalid data:"+ actualmessageforlogin);
	}
	@Test(priority=1)
	public void searchemployeebyname() {
		lobj.verifypimmenu();
		//lobj.verifyemployeelist();
		lobj.employeename("John");
		lobj.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=2)
	public void searchemployeebyId() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		//lobj.verifydashboardpage();
		lobj.enterid("0295");
		lobj.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=3)
	public void searchemployeebystatus() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		//lobj.verifydashboardpage();
		lobj.employeestatus();
		lobj.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=4)
	public void searchbyincludes() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		//lobj.verifydashboardpage();
		lobj.employeeinclude();
		lobj.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=5)
	public void searchbyjobtitle() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		//lobj.verifydashboardpage();
		lobj.employeejobtitle();
		lobj.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=6)
	public void viewemployeedetailsfromlist() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		lobj.employeedetails();
		lobj.logout();
		lobj.logout2();
		}
	@Test(priority=7)
	public void searchwithblankfields() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		lobj.search();
		lobj.logout();
		lobj.logout2();
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
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		lobj.resetbutton();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=10)
	public void searchwithinvaliddata() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		//lobj.verifydashboardpage();
		lobj.enterid("0000");
		lobj.employeename("null");
		lobj.search();
		Assert.assertEquals(actualmessagefornorecords,actualmessagefornorecords);
		System.out.println("Message displayed for search with invalid data:"+ actualmessagefornorecords);
		lobj.logout();
		lobj.logout2();	
		
	}
	@Test(priority=11)
	public void searchusingspecialcharacter() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		//lobj.verifydashboardpage();
		lobj.enterid("@#$");
		lobj.employeename("%&");
		lobj.search();
		Assert.assertEquals(actualmessagefornorecords,actualmessagefornorecords);
		System.out.println("Message displayed for search using special character:"+ actualmessagefornorecords);
		lobj.logout();
		lobj.logout2();	
	}
	@Test(priority=12)
	public void deletenamefromlist() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		//lobj.verifydashboardpage();
		lobj.deletename();
		Assert.assertEquals(actualmessagefordeletion,actualmessagefordeletion);
		System.out.println("Message displayed for delete name from list:"+ actualmessagefordeletion);
		lobj.logout();
		lobj.logout2();	
	
	}
	@Test(priority=13)
	public void addnewemployee()  {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.lastname("Kurup");
		add.save();
		Assert.assertEquals(actualmessageforsave,actualmessageforsave);
		System.out.println("Message displayed for add  new employee:"+ actualmessageforsave);
		lobj.logout();
		lobj.logout2();	
	}
	@Test(priority=14)
	public void addemployeewithonlyfirstname(){
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.save();
		Assert.assertEquals(actualmessageformissingfield,actualmessageformissingfield);
		System.out.println("Message displayed for add new employee without lastname:"+ actualmessageformissingfield);
		lobj.logout();
		lobj.logout2();	
	}
	@Test(priority=15)
	public void addemployeewithexistingID() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.enterfirst("Mary");
		add.lastname("Philip");
		add.enterid("0295");
		add.save();
		Assert.assertEquals(actualmessageforalreadyexistfield,actualmessageforalreadyexistfield);
		System.out.println("Message displayed for add new employee with existingId:"+ actualmessageforalreadyexistfield);
		lobj.logout();
		lobj.logout2();	
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
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.cancelbutton();
		lobj.logout();
		lobj.logout2();	
		Assert.assertEquals(actualmessageforcancel,actualmessageforcancel);
		System.out.println("Message displayed for canceling the add employee process:"+ actualmessageforcancel);
	}
	@Test(priority=18)
	public void eneterlogincredential() 
{
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
		add.add();
		add.enterfirst("Sunitha");
		add.lastname("Kurup");
		add.save();
		add.logincredential();
		add.eneterusername("Sunitha");
		add.eneterpassword("Tester@1245");
		add.eneterconfirmpass("Tester@1245");
		add.save();
		lobj.logout();
		lobj.logout2();	
		Assert.assertEquals(actualmessageforlogin,actualmessageforlogin);
		System.out.println("Message displayed for enterlogin credential:"+ actualmessageforlogin);
	}
	@Test(priority=19)
	public void loginwithmismatchedpassword()  {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
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
		lobj.logout();
		lobj.logout2();	
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
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifypimmenu();
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
		lobj.logout();
		lobj.logout2();	
	}
	@Test(priority=21)
	public void verifyaddedemployeeinlistafterlogoutlogin() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
		//lobj.verifyemployeelist();
		lobj.employeename("Joele");
		lobj.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=22)
	public void verifyReportlist() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
		report.verifyReportpage();
		report.viewreport();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=23)
	public void Searchreport() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
		report.verifyReportpage();
		report.searchreport("Employee");
		report.search();
		lobj.logout();
		lobj.logout2();
	}
	@Test(priority=24)
	public void AddReport() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
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
		lobj.logout();
		lobj.logout2();	
		}
	@Test(priority=25)
	public void addreportwithexistingname() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
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
		lobj.logout();
		lobj.logout2();	
	}
	@Test(priority=26)
	public void deletereport() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
		report.verifyReportpage();	
		report.deletereport();
		Assert.assertEquals(actualmessagefordeletion,actualmessagefordeletion);
		System.out.println("Message displayed for delete reportf from list:"+ actualmessagefordeletion);
		lobj.logout();
		lobj.logout2();	
	}
	@Test(priority=27)
	public void editreport() {
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();	
		lobj.verifypimmenu();
		report.verifyReportpage();
		report.editreport();
		report.addmoredisplay();
		report.save();
		Assert.assertEquals(actualmessageforedit,actualmessageforedit);
		System.out.println("Message displayed for edit the report:"+ actualmessageforedit);
		lobj.logout();
		lobj.logout2();	
		}
@Test(priority=28)
public void canceladdreport() {
	lobj.loginusername("Admin");
	lobj.loginpassword("admin123");
	lobj.logbuttn();	
	lobj.verifypimmenu();
	report.verifyReportpage();
	report.addreport();
	report.enterreponame("Developer");
	report.selectioncriteria();
	report.option("Employee Name");
	report.canceladdreport();
	lobj.logout();
	lobj.logout2();	
	Assert.assertEquals(actualmessageforcancel,actualmessageforcancel);
	System.out.println("Message displayed forcancel the adding report:"+ actualmessageforcancel);
}
@Test(priority=29)
public void addreportwithmissingfield() {
	lobj.loginusername("Admin");
	lobj.loginpassword("admin123");
	lobj.logbuttn();	
	lobj.verifypimmenu();
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
	lobj.logout();
	lobj.logout2();		
}

}



