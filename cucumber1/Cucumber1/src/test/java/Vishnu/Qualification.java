package Vishnu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import OR1.OR;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumgluecode1.BeforeAfter_Scenario;

public class Qualification {
	
	public WebDriver driver;
	
 @When ("^I open OpenOrangeHRM website$")
    public void openOrangeHRM() {
	 
	 
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.manage().deleteAllCookies();
     // Write code here that turns the phrase above into concrete actions
 	driver.get("https://opensource-demo.orangehrmlive.com/");
	 
	 
	 
	 
 }
 
 @Given ("^Sign in Details$")
public void Login() throws Throwable {
	 
	 findElement(By.xpath(OR.UserName)).sendKeys("Admin");
		findElement(By.xpath(OR.Password)).sendKeys("admin123");
		findElement(By.xpath(OR.Loginbutton)).click();
	 
	 
	 
	 
	 
 }


 @And ("^I created Jobs Record$")
 public void jobs() throws Throwable {
 	 
	 findElement(By.id(OR.Admin_id)).click();
 	
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales57");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales57 descr");
		findElement(By.id("jobTitle_note")).sendKeys("Sales57 Note");
		findElement(By.id("btnSave")).click();
 	 
 	 
 	 
 	 
 }
  
 
 
 @Then ("^I sign out$")
 public void signout() {
	 
 	 
	 BeforeAfter_Scenario.driver=driver;
 	driver.quit();
 	 
 	 
 	 
 	 
 	 
  }
 
 public   WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
}
	   