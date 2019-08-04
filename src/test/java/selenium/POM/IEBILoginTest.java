package selenium.POM;


import org.testng.annotations.Test;

public class IEBILoginTest extends BaseClass{
  @Test
  public void login() throws InterruptedException {
	  
	  IEBILoginPage.getUserID(driver).sendKeys("donhere");
	  log.info("The user name was entered");
	  Thread.sleep(3000);
	  IEBILoginPage.getPassword(driver).sendKeys("don@123");
	  log.info("The Password was entered");
	  Thread.sleep(3000);
	  IEBILoginPage.getLoginButton(driver).click();
	  log.info("The login button was clicked");
	  Thread.sleep(3000);
  }
}
