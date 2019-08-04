package selenium.advance;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;

public class DemoGroups {
	WebDriver driver;
	  @Test(groups = {"g2"})
	  public void login() {
		  try
		  	{
		  	driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
			Thread.sleep(3000);
			driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
			Thread.sleep(3000);
			driver.findElement(By.name("ctl00$body$btnLogin")).click();
			Thread.sleep(3000);
			}
		  	catch(Exception e)
		  	{
		  		e.getMessage();
		  	}
	  }
	  @Test(groups = {"g1"})
	  public void welcome() {
		  try {
			  System.out.println(driver.findElement(By.id("ctl00_ctl00_divWelcome")).getText());
			  Thread.sleep(3000);
			  }
			  catch(Exception e)
			  {
				  e.getMessage();
			  }
	  }
	  @Test(groups = {"g2"})
	  public void logout() {
		  try {
		  		driver.findElement(By.linkText("Log Out")).click();
		  		System.out.println("Logged out");
				Thread.sleep(3000);	
		  	}
		  	catch(Exception e)
		  	{
		  		e.getMessage();
		  	}
	  }
	  @Parameters({"Browser","URL"})
	  @BeforeSuite(groups = {"g2"})
	  public void d(@Optional("IE")String browser,String url) {
		  try
		  {
		  switch(browser)
		  {
		  case "Chrome":
		  	  	System.setProperty("webdriver.chrome.driver","D:\\software\\chromedriver_win32\\chromedriver.exe");
		  	  	driver = new ChromeDriver();
		  	  	driver.manage().window().maximize();
		  	  	driver.get(url);
		  	  	break;
		  	  	
		  case "IE":
		  	  	System.setProperty("webdriver.ie.driver","D:\\software\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
		  	  	driver = new InternetExplorerDriver();
		  	  	driver.manage().window().maximize();
		  	  	driver.get(url);
		  	  	break;
		  	  	
		  }
		  }
		  catch(Exception e)
		  {
			  e.getMessage();
		  }
	  }

	  @AfterSuite (groups = {"g1"})
	  public void e() {
		  try
		  {
		  driver.close();
		  }
		  catch(Exception e)
		  {
			  e.getMessage();
		  }
	  }

  
}
