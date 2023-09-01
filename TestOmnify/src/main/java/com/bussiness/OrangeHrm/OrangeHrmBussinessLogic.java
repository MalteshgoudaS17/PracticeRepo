package com.bussiness.OrangeHrm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmBussinessLogic {


	// Create a new instance of the ChromeDriver
	WebDriver driver=new ChromeDriver();
	public  void LaunchOrangeHRM()
	{
		WebDriverManager.chromedriver().setup();

		// Launch the OrangeHRM website
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		// Close the browser after a few seconds (you can customize the delay)
		try {
			Thread.sleep(5000); // Wait for 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public  void LoginOrangeHRM() throws  InterruptedException 
	{
		WebElement element =driver.findElement(OrangeHrmPageObject.objLogincTitle);

		try {

			if (element.isDisplayed()) {
				System.out.println("User is navigated to OrangeHRM login page");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("User is Not navigated to OrangeHRM login page");
		}

		driver.findElement(OrangeHrmPageObject.objUsernameTextField).sendKeys("Admin");
		driver.findElement(OrangeHrmPageObject.objPasswordTextField).sendKeys("admin123");
		driver.findElement(OrangeHrmPageObject.objloginButton).click();
		Thread.sleep(10000);

	}

	public void AddEmployee() throws InterruptedException, IOException
	{
		String csvFile = "src\\AddEmployee.csv";
		String line;
		JavascriptExecutor jsExecutor;
		WebElement element =driver.findElement(OrangeHrmPageObject.objPIMtext);
		try {

			if (element.isDisplayed()) {
				System.out.println("User is loggedIN");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("User failed to log-in");
		}
		

		BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
		while ((line = bufferedReader.readLine()) != null) {
			String[] row = line.split(",");
			driver.findElement(OrangeHrmPageObject.objPIMtext).click();
			Thread.sleep(5000);
			driver.findElement(OrangeHrmPageObject.objAddCTA).click();
			Thread.sleep(5000);
			driver.findElement(OrangeHrmPageObject.objfirstNameCTA).sendKeys(row[0]);
			driver.findElement(OrangeHrmPageObject.objmiddleNameCTA).sendKeys(row[1]);
			driver.findElement(OrangeHrmPageObject.objlastNameCTA).sendKeys(row[2]);
			Thread.sleep(5000);
			driver.findElement(OrangeHrmPageObject.objSaveCTA).click();
			Thread.sleep(10000);
			try {
			driver.findElement(OrangeHrmPageObject.objDashboardCTA).click();
			Thread.sleep(5000);
			driver.findElement(OrangeHrmPageObject.objPIMtext).click();
		//	driver.findElement(OrangeHrmPageObject.objEmployeeListCTA).click();
			Thread.sleep(5000);
			driver.findElement(OrangeHrmPageObject.objEmployeeNameTextBOX).click();
			driver.findElement(OrangeHrmPageObject.objEmployeeNameTextBOX).sendKeys(row[0]);
			driver.findElement(OrangeHrmPageObject.objSearchCTA).click();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0, 500);");
			Thread.sleep(5000);
			WebElement ename =driver.findElement(OrangeHrmPageObject.objEnameVerify(row[0]));
			try {

				if (ename.isDisplayed()) {

					System.out.println("Added employee name is Displayed");
					System.out.println(driver.findElement(OrangeHrmPageObject.objEnameVerify(row[0])).getText());
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Added employee name is Not Displayed");
			}

		}
		
	}

	public void Logout() throws InterruptedException
	{
		driver.findElement(OrangeHrmPageObject.objDashboardCTA).click(); 
		Thread.sleep(5000);
		driver.findElement(OrangeHrmPageObject.objuserdropdownCTA).click();
		driver.findElement(OrangeHrmPageObject.objLogoutCTA).click();
		Thread.sleep(5000);

		WebElement element =driver.findElement(OrangeHrmPageObject.objLogincTitle);

		try {

			if (element.isDisplayed()) {
				System.out.println("User is navigated to OrangeHRM login page");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("User is Not navigated to OrangeHRM login page");
		}

	}
	public void tearDown() {
		driver.close();

	}

}
