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


public class Login {

	WebDriver driver;
	  @Test
	  public void test() {
		  	try
		  	{
		  	driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
			Thread.sleep(3000);
			driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
			Thread.sleep(3000);
			driver.findElement(By.name("ctl00$body$btnLogin")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Log Out")).click();
			Thread.sleep(3000);
		  	}
		  	catch(Exception e)
		  	{
		  		e.getMessage();
		  	}
	  }
	  @Parameters({"Browser","URL"})
	  @BeforeSuite
	  public void beforeSuite(@Optional("IE")String browser,String url) {
		  	
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

	  @AfterSuite
	  public void afterSuite() {
		  driver.close();
	  }

}
