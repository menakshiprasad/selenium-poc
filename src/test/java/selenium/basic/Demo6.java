package selenium.basic;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo6 {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.67.89.42/common/login.aspx");
		
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		String un="donhere";
		String pw="don@123";
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$btnLogin")).click();
		Thread.sleep(3000);
		
		if(driver.findElement(By.id("ctl00_ctl00_divWelcome")).isDisplayed())
			System.out.println(driver.findElement(By.id("ctl00_ctl00_divWelcome")).getText());
			else
				System.out.println();
	
		
			
	}

}
