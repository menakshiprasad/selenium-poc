package selenium.basic;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLinks {

	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://10.67.89.42/common/login.aspx");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//driver.close();
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		List<WebElement> l=driver.findElements(By.tagName("a"));
		int s=l.size();
		for(int i=0; i<s;i++)
		{
			System.out.println(l.get(i).getText());
			//Thread.sleep(3000);
			
		}
		
	}

}
