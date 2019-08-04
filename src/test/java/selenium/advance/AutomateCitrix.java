package selenium.advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
//import org.sikuli.api.Screen;
//import org.sikuli.script.Screen;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomateCitrix {
	WebDriver driver;
	@Test
	public void Test() throws InterruptedException, FindFailed {
		
		
		driver.findElement(By.id("Enter user name")).sendKeys("prasme4xo");
		Thread.sleep(3000);
		driver.findElement(By.id("passwd")).sendKeys("man@8384");
		Thread.sleep(3000);
		driver.findElement(By.id("eula_check")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("Log_On")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("protocolhandler-welcome-installButton")).click();
		Thread.sleep(6000);
		//protocolhandler-welcome-installButton
		
		driver.findElement(By.xpath("//*[@id=\"protocolhandler-detect\"]/div/div/div/div/div[3]")).click();
		Thread.sleep(3000);
		//*[@id="protocolhandler-welcome-installButton"]
		
		
		Screen s =new Screen();
		
		s.wait("src/images/n.PNG", 30);
	
		s.click("src/images/n.PNG");
		
		
			
	}
  

  

  @Parameters({"Browser","URL"})
  @BeforeSuite
  public void beforeSuite(@Optional("IE")String browser,String url) {
	  	
	  switch(browser)
	  {
	  case "Chrome":
	  	  	System.setProperty("webdriver.chrome.driver","D:\\software\\chromedriver_win32\\chromedriver.exe");
	  	  	driver = new ChromeDriver();
	  	  	//driver.manage().deleteAllCookies();
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
