package testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.bussiness.OrangeHrm.OrangeHrmBussinessLogic;
import com.bussiness.OrangeHrm.OrangeHrmPageObject;


public class TestOrangeHRM 
{
	OrangeHrmBussinessLogic	OHM=new OrangeHrmBussinessLogic();
	
	@BeforeTest
	public void setUp() 
	{ 
		OHM.LaunchOrangeHRM();
	}

	
	
	@Test(priority = 1)
	public void launchOrangeHRMWebsite() throws InterruptedException 
	{
		OHM.LoginOrangeHRM();    
	}

	@Test(priority = 2)
	public void addEmployee() throws InterruptedException, IOException
	{
		OHM.AddEmployee();
		
	}
	
	@Test(priority = 2)
	public void logoutfromOrangeHRMWebsite() throws InterruptedException, IOException
	{
		OHM.Logout();
		
	}
	
	
	@AfterTest
	public void tearDown() {
		// Close the browser
		OHM.tearDown();
	}

}
