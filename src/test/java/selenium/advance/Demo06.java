package selenium.advance;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;


import org.testng.annotations.Test;

public class Demo06 {
	WebDriver driver;
	  
	  @Test
	  public void c()
	  {
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
	  @Test
	  public void b()
	  {
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
	  @Test()
	  public void a() {
		  try {
			  System.out.println(driver.findElement(By.id("ctl00_ctl00_divWelcome")).getText());
			  Thread.sleep(3000);
			  }
			  catch(Exception e)
			  {
				  e.getMessage();
			  }
		  
	  }

	//  @DataProvider
	//  public Object[][] dp() {
//	    return new Object[][] {
//	      new Object[] { "donhere", "don@123" },
//	      new Object[] { "Peter_Parker" ,"Peter@Parker93" },
//	    };
	//  }
	  
	  @Parameters({"Browser","URL"})
	  @BeforeSuite
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
		  	  	System.setProperty("webdriver.ie.driver","D:\\IVS Content\\Selenium\\IE Driver\\3.9.0\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
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

	  @AfterSuite
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
