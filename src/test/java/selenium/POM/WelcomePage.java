package selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WelcomePage {
	
	  public static WebElement getMessage(WebDriver driver) {
		 return driver.findElement(By.id("ctl00_ctl00_divWelcome"));
		  
	  }

	
}
