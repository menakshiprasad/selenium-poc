package selenium.basic;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo04 {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://10.67.89.41/Automation/HMS/LoginPage.aspx");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//driver.close();
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.name("txtUserID")).sendKeys("11");
		Thread.sleep(3000);
		driver.findElement(By.name("txtPassword")).sendKeys("priya");
		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(3000);
			
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		//driver.findElement(By.linkText("About Us")).click();
		
		
	}

}
