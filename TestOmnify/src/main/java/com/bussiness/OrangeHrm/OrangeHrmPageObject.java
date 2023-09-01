package com.bussiness.OrangeHrm;

import org.openqa.selenium.By;

public class OrangeHrmPageObject {
	
public static By objLogincTitle = By.xpath("//*[contains(@class,'orangehrm-login-title')]");

	public static By objUsernameTextField = By.xpath("//*[@placeholder='Username']");

	public static By objPasswordTextField = By.xpath("//*[@placeholder='Password']");

	public static By objloginButton= By.xpath("//*[contains(@class,'orangehrm-login-button')]");
	
	public static By objPIMtext= By.xpath("//*[text()='PIM']");
	
	public static By objAddCTA= By.xpath("//*[text()[normalize-space()='Add']]");
	
	public static By objfirstNameCTA= By.xpath("//*[@name='firstName']");
	
	public static By objmiddleNameCTA= By.xpath("//*[@name='middleName']");
	
	public static By objlastNameCTA= By.xpath("//*[@name='lastName']");
	
	public static By objSaveCTA= By.xpath("//*[text()[normalize-space()='Save']]");
	
	public static By objEmployeeListCTA= By.xpath("//*[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']");
	
	
	public static By objEmployeeNameTextBOX= By.xpath("//*[text()='Employee Name']/parent::*//following-sibling::*//child::input[contains(@placeholder,'Type for hints')]");
	//(//input[@placeholder='Type for hints...'])[1]
	//*[text()='Employee Name']/parent::*//following-sibling::*//child::input[contains(@placeholder,'Type for hints')]
	//*[text()='Employee Name']/parent::*//following-sibling::*//child::*[@placeholder='Type for hints...']
	public static By objSearchCTA= By.xpath("//*[text()[normalize-space()='Search']]");
	
	public static By objAddEmployeeCTA= By.xpath("//*[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']");
	
	public static By objDashboardCTA= By.xpath("//*[text()='Dashboard' and contains(@class,'main-menu-item--name')]");
	
	public static By objuserdropdownCTA= By.xpath("//*[contains(@class,'userdropdown-icon')]");
	
	public static By objLogoutCTA= By.xpath("//*[text()='Logout']");
	
	
	public static By objEnameVerify(String name)
	{
		return By.xpath("//*[contains(text(),'"+name+"')]");
	}
	
	

}
