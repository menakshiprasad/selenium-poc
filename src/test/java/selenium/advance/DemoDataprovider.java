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

public class DemoDataprovider {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void test(String un, String pwd) {
		  try
		  	{
		  	driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys(un);
			Thread.sleep(3000);
			driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys(pwd);
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

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "donhere", "don@123" },
	      new Object[] { "Peter_Parker" ,"Peter@Parker93" },
	    };
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
