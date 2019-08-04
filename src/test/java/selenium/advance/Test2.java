package selenium.advance;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	WebDriver driver;
	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setUp(@Optional("IE")String browser,String url) {
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

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	 @Test(priority=1)
	  public void login()
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
	  @Test(priority=3)
	  public void logout()
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
	@Test(priority=2)
public void printTable(){
	try {
			driver.findElement(By.linkText("View Transactions")).click();
			Select s = new Select(driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlAccountNo")));
			s.selectByIndex(1);
			driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_rblTransactions_0")).click();
			driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$btnViewTrancastions")).click();
			Thread.sleep(3000);
			List<WebElement> nr = driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr"));
			List<WebElement> nh = driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr/th"));
			for(int i=1;i<nh.size();i++)
			{
			System.out.print(driver.findElement(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr[1]/th["+i+"]")).getText());
			System.out.print("\t");
			}
			System.out.println("");
			for(int i=2;i<nr.size();i++)
			{
				List<WebElement> nd = driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr["+i+"]/td"));
				for(int j=1;j<nd.size();j++)
				{
					System.out.print(driver.findElement(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr["+i+"]/td["+j+"]")).getText());
					System.out.print("\t");
				}
				System.out.println("");
			}
			Thread.sleep(3000);
				driver.findElement(By.linkText("Log Out")).click();
				Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
