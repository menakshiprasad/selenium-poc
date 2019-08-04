package selenium.basic;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Exercise2 {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.67.89.42/Common/Login.aspx");


	}

	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(3000);
	driver.quit();
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException, IOException {

	driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		

	WebElement tblAccountDetails = driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_gvAccountDetails"));
	
	List<WebElement> rows = tblAccountDetails.findElements(By.tagName("tr"));

	
	for (WebElement row : rows) {
		List<WebElement> cols = row.findElements(By.tagName("td"));

		for (WebElement col : cols) {
			if("FD".equals(col.getText()))
			System.out.print(row.getText()+"\t ");
		}
		System.out.println("");
	}
		
		
		driver.findElement(By.linkText("Log Out")).click();
		
		
				
	}

}
