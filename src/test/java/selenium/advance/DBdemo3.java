package selenium.advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DBdemo3 {
	WebDriver driver;
	Connection conn;
	Statement stmt;
	ResultSet rs;

	@Test
	public void test() throws InterruptedException {

		try {
			Integer un;
			String pwd;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select EmployeeId,FirstName,LastName,Password from tbl_EmployeeDetails where EmployeeId IN (11)");
			System.out.println("Query ready");
			while (rs.next()) {
				un = rs.getInt(1);
				pwd = rs.getString(4);
				System.out.println("FirstName="+rs.getString(2));
				System.out.println("LastName="+rs.getString(3));
				driver.findElement(By.id("txtUserID")).sendKeys(un.toString());
				driver.findElement(By.id("txtPassword")).sendKeys(pwd);
				driver.findElement(By.id("btnLogin")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Site Map")).click();
				driver.findElement(By.linkText("Case File")).click();
				driver.findElement(
						By.xpath("//*[@id=\"__tab_cphMainContent_tcAddOrViewCaseFile_tpViewCaseFile\"]/span")).click();
				driver.findElement(
						By.name("ctl00$cphMainContent$tcAddOrViewCaseFile$tpViewCaseFile$txtPatientIDSearch"))
						.sendKeys("1");
				Thread.sleep(3000);
				driver.findElement(
						By.name("ctl00$cphMainContent$tcAddOrViewCaseFile$tpViewCaseFile$btnSearch"))
						.click();
				Thread.sleep(3000);
					

				WebElement tblAccountDetails = driver.findElement(By.id("cphMainContent_tcAddOrViewCaseFile_tpViewCaseFile_gvCaseDetails"));
				
				List<WebElement> rows = tblAccountDetails.findElements(By.tagName("tr"));

				
				for (WebElement row : rows) {
					List<WebElement> cols = row.findElements(By.tagName("td"));

					for (WebElement col : cols) {
						if(col.getText().equals("No"))
						System.out.print(row.getText()+"\t ");
					}
					System.out.println("");
				}

				
							
				
			driver.findElement(By.linkText("Logout")).click();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters({ "Browser", "URL" })
	@BeforeSuite

	public void setUp(@Optional("IE") String browser, String url) {
		try {
			switch (browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(url);
				break;

			case "IE":
				System.setProperty("webdriver.ie.driver",
						"D:\\software\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get(url);
				break;

			}
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager
					.getConnection("jdbc:sqlserver://VIVSBNG2-07;database=HMS_New;user=sa;password=infy@123");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@AfterSuite
	public void tearDown() {
		try {
			conn.close();
			driver.close();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
