package selenium.basic;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo01 {

	WebDriver driver;
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://citrix.xo.com/vpn/index.html");
		
	}

}
