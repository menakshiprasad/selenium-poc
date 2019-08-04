package selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IEBILogoutPage {
  @Test
  public static WebElement getLogout(WebDriver driver) {
	  
	  return driver.findElement(By.linkText("Log Out"));
 
  }
}
