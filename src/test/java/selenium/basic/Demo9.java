package selenium.basic;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Demo9 {
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
		//String un="donhere";
		//String pw="don@123";
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		//String msg1=driver.findElement(By.id("ctl00_body_txtUserID")).getText();
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$body$btnLogin")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Deposit")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Close FD/RD Account")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("ctl00_ctl00_body_cph_Deposit_rbtnDepositType_1")).click();
				Thread.sleep(3000);
				
				Select s=new Select(driver.findElement(By.name("ctl00$ctl00$body$cph_Deposit$ddlMyDeposits")));
				s.selectByValue("100000000045");
				Thread.sleep(3000);
				driver.findElement(By.id("ctl00_ctl00_body_cph_Deposit_chkNewTransfer")).click();
				Thread.sleep(3000);
				
				
					driver.findElement(By.id("ctl00_ctl00_body_cph_Deposit_rbtnTransferType_2")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.name("ctl00$ctl00$body$cph_Deposit$btnReset")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Log Out")).click();
				Thread.sleep(3000);
				
			}
	}


