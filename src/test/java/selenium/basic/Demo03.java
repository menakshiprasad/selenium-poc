package selenium.basic;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo03 {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.setProperty("webdriver.ie.driver", "D:\\software\\IEdriver_win32\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		
		//driver.get("https://citrix.xo.com/vpn/index.html");
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://citrix.xo.com/vpn/index.html");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Enter user name']")).sendKeys("prasme4xo");
		Thread.sleep(3000);
		driver.findElement(By.id("passwd")).sendKeys("infy@110684");
		Thread.sleep(3000);
		driver.findElement(By.id("eula_check")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("Log_On")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("protocolhandler-welcome-installButton")).click();
		Thread.sleep(6000);
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		//driver.findElement(By.xpath("//*[@id=\"protocolhandler-detect\"]/div/div/div/div/div[3]")).click();
		//Thread.sleep(3000);
		//driver.switchTo().alert().cancel():
		//driver.switchTo().alert().dismiss();
		//alert.accept();
		
		//driver.findElement(By.id("protocolhandler-detect-alreadyInstalledLink")).click();
		//Thread.sleep(3000);
		
		
		//Thread.sleep(8000);
			
	}

}
