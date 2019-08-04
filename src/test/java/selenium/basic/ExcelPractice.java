package selenium.basic;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

public class ExcelPractice {
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
	
	
	@Test
	public void test() throws InterruptedException, IOException {

	String uname, pwd;
	String path="D:\\software\\MyData.xlsx";
	
	
	FileInputStream fis=new FileInputStream(path);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sh= wb.getSheet("Sheet1");
	int rows= sh.getPhysicalNumberOfRows();
	//int r= sh.getLastRowNum()-sh.getFirstRowNum();
	
	for(int i=1; i<rows;i++)
	{
		uname=sh.getRow(i).getCell(0).getStringCellValue();
		pwd=sh.getRow(i).getCell(1).getStringCellValue();
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys(uname);
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$btnLogin")).click();
		Thread.sleep(3000);
		String s=driver.findElement(By.id("ctl00_ctl00_divWelcome")).getText();
		Thread.sleep(3000);

		
		Row r1;
		Cell c1;
		
			r1=sh.getRow(i);
			c1=r1.createCell(2);
			c1.setCellValue(s);
	
		driver.findElement(By.linkText("Log Out")).click();
	}
	
	
	FileOutputStream fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
	
//		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
//		Thread.sleep(3000);
//		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
//		Thread.sleep(3000);
//		driver.findElement(By.name("ctl00$body$btnLogin")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("Log Out")).click();
//	driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("Peter_Parker");
//	Thread.sleep(3000);
//	driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("Peter@Parker93");
//	Thread.sleep(3000);
//	driver.findElement(By.name("ctl00$body$btnLogin")).click();
//	Thread.sleep(3000);
//	
//	driver.findElement(By.linkText("Log Out")).click();
//	
//				
	}

}
