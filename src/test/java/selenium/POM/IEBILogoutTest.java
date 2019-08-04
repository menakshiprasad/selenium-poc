package selenium.POM;

import org.testng.annotations.Test;

public class IEBILogoutTest extends BaseClass {
  @Test
  public void logout() {
	  IEBILogoutPage.getLogout(driver).click();
	  log.info("The logout link was clicked");

  }
}
