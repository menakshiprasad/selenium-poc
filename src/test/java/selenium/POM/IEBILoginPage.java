package selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IEBILoginPage {
	public static WebElement getUserID(WebDriver driver) {

		return driver.findElement(By.name("ctl00$body$txtUserID"));

	}

	public static WebElement getPassword(WebDriver driver) {

		return driver.findElement(By.name("ctl00$body$txtPassword"));

	}

	public static WebElement getLoginButton(WebDriver driver) {

		return driver.findElement(By.name("ctl00$body$btnLogin"));

	}

}
