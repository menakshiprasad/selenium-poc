package selenium.basic;

import static org.junit.Assert.*;

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

public class Explictwait {
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
		
		driver.findElement(By.linkText("Dynamic Elements")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 22);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lblMessage5"))));
		System.out.println(driver.findElement(By.id("lblMessage5")).getText());
		//Thread.sleep(3000);
		//Actions act=new Actions(driver);
		
		
//		WebElement source=driver.findElement(By.id("draggable"));
//		WebElement target=driver.findElement(By.id("droppable"));
//		act.dragAndDrop(source, target).build().perform();
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText());
//		
				
		
	}

}
