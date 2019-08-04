package selenium.basic;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class Exercise3 {
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
		driver.findElement(By.linkText("Add Payee")).click();
		
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtPayeeAccountNumber")).sendKeys("123");
		
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtReEnterAccountNumber")).sendKeys("123");
		Thread.sleep(3000);
		
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtPayeeName")).sendKeys("Sachin");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtPayeeNickName")).sendKeys("Sach");
		Thread.sleep(3000);
		
		driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$btnAddPayee")).click();
		Thread.sleep(3000);
		String msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(msg);
		
		driver.findElement(By.linkText("Log Out")).click();
		driver.findElement(By.linkText("Contact Us")).click();
		System.out.println(driver.findElement(By.id("templatemo_footer")).getText());
		
				
	}

}
