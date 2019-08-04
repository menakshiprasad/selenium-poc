package selenium.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShots {
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
	
	File src1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File imgfile1=new File("D:\\Selenium workspace\\Image\\img.jpg");
	FileUtils.copyFile(src1, imgfile1);
	
	for(int i=1; i<rows;i++)
	{
		
		uname=sh.getRow(i).getCell(0).getStringCellValue();
		pwd=sh.getRow(i).getCell(1).getStringCellValue();
		
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys(uname);
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys(pwd);
		Thread.sleep(3000);
			
		
		driver.findElement(By.name("ctl00$body$btnLogin")).click();
		String s=driver.findElement(By.id("ctl00_ctl00_divWelcome")).getText();
		
		Row r1;
		Cell c1;
		
			r1=sh.getRow(i);
			c1=r1.createCell(2);
			c1.setCellValue(s);
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File imgfile=new File("D:\\Selenium workspace\\Image\\img["+i+"].jpg");
	FileUtils.copyFile(src, imgfile);
	
	driver.findElement(By.linkText("Log Out")).click();
		
	}
	
	FileOutputStream fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
	}

}
