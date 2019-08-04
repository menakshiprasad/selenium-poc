package selenium.basic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Demo12 {
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
				
				driver.findElement(By.linkText("View Transactions")).click();
			
				Thread.sleep(3000);
				//WebElement obj=driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlAccountNo"));
				//Thread.sleep(3000);
				
				Select s=new Select(driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlAccountNo")));
					
					s.selectByIndex(1);	
					driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_rblTransactions_0")).click();
					
					driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$btnViewTrancastions")).click();
					
					Thread.sleep(3000);
					List<WebElement> rowcount=driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr"));
					List<WebElement> colcount=driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr/td"));
						
					//int rc=rowcount.size();
				List<WebElement> headercount=driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr[1]/th"));
				int hc=headercount.size();
				for(int k=1; k<=hc;k++)
				{
					System.out.print(driver.findElement(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr[1]/th["+k+"]")).getText());	
					System.out.print("\t");
					
				}
				
	System.out.println();	
	
	for(WebElement el: rowcount)
	{
		
	}
		
					//System.out.println(rowcount+" "+colcount);
//					int j;
//					for(int i=2; i<=rc;i++)
//					{
//						List<WebElement> colcount=driver.findElements(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr["+i+"]/td"));
//
//						for(j=1;j<=colcount.size();j++)
//						{
//
//				System.out.print(driver.findElement(By.xpath("//table[@id='ctl00_ctl00_body_cph_MyAccount_gvTransaction']/tbody/tr["+i+"]/td["+j+"]")).getText());	
//				System.out.print("\t");
//					}
						//Thread.sleep(3000);
						System.out.println();
					}
				

				//s.selectByValue("100000000001");
				//Thread.sleep(3000);
					
				//s.selectByVisibleText("100000000011");
				//Thread.sleep(3000);
				//driver.findElement(By.linkText("Log Out")).click();
				//Thread.sleep(3000);
					
			}
	


