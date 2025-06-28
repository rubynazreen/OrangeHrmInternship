package org.ictkerala.testcases;

import org.ictkerala.base.PreSettings;
import org.ictkerala.pages.OrangeHrmLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeTestCases extends PreSettings {

	OrangeHrmLogin lobj;
	
	@BeforeClass
	public void objinit() {
		lobj=new OrangeHrmLogin(driver);
				
	}
	
	@Test
	public void TC011()
	{
		lobj.loginusername("Admin");
		lobj.loginpassword("admin123");
		lobj.logbuttn();
		lobj.verifydashboardpage();
	}
	@Test
	public void TC012() {
		lobj.verifyrecruitmentmenu();
	}
}
