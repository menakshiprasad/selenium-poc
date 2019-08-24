package selenium.POM;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class IEBILoginTest extends BaseClass{
  @Test
  public void login() throws InterruptedException {
	  
	  ExtentHtmlReporter report=new ExtentHtmlReporter("./Reports/r.html");
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(report);
	  ExtentTest logger=extent.createTest("Login");
	  logger.log(Status.PASS, "Login Successfull");
	  extent.flush();
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
