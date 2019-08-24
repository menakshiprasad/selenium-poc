package selenium.POM;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger log = Logger.getLogger(getClass());
	
	@Parameters({"Browser","URL"})  
	@BeforeSuite
	  public void setUp(@Optional("IE")String browser,String URL){
		BasicConfigurator.configure();
		PropertyConfigurator.configure("D:\\Selenium workspace\\Log.properties");
		  	try
		  	{
		  		switch(browser)
		  		{
		  		case "Chrome":
		  				System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		  				driver = new ChromeDriver();
		  				driver.manage().window().maximize();
		  			
		  				driver.get(URL);
		  				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  				log.info("The url was opened in the chrome browser");
		  				break;
		  				
		  		case "IE":
	  				System.setProperty("webdriver.ie.driver", "D:\\software\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
	  				driver = new InternetExplorerDriver();
	  				driver.manage().window().maximize();
	  				driver.get(URL);
	  				log.info("The url was opened in the internet explorer browser");
	  				break;
			}
		  		Thread.sleep(3000);
		  		
		  	}
		  	catch(Exception e)
		  	{
		  		System.out.println(e.getMessage());
		  	}
	  
	  }

	  @AfterSuite
	  public void tearDown() {
		  driver.close();
		  log.info("The browser was closed");
	  }



}
