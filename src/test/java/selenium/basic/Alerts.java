package selenium.basic;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.67.89.41/Automation/DemoApps/PopupBox.aspx");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(3000);
	driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/input")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/input")).click();
		Thread.sleep(3000);		
		driver.switchTo().alert().accept();
		
		System.out.println(driver.findElement(By.id("lblMessage")).getText());
			
		//*[@id="lblMessage"]
	   Thread.sleep(3000);
			
   driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/input")).click();
		
	driver.switchTo().alert().sendKeys("Menakshi");
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("lblMessage")).getText());
		
//	
	   //Thread.sleep(3000);
		
//		driver.switchTo().frame(0);
//	System.out.println(driver.findElement(By.className("frames-page")).getText());
//	driver.switchTo().parentFrame();
//	driver.switchTo().frame("right");
//	System.out.println(driver.findElement(By.className("frames-page")).getText());
//	driver.switchTo().parentFrame();
//	driver.switchTo().frame("center");
//	System.out.println(driver.findElement(By.className("frames-page")).getText());
//	
	
	}

}
