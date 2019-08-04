package selenium.POM;

import org.testng.annotations.Test;

public class WelcomeTest extends BaseClass {
  @Test
  public void Welcome() {
	  String s=WelcomePage.getMessage(driver).getText();
	  System.out.println(s);
  }
}
