package selenium.advance;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Demo02 {
  @Test
  
  public void test2() {
	  System.out.println("This is test 2");
  }
  
  
  @BeforeMethod
  public void beforeMethod2() {
	  System.out.println("This is before method 2");
  }

  @AfterMethod
  public void afterMethod2() {
	  System.out.println("This is after method 2");
  }

  
  @BeforeClass
  public void beforeClass2() {
	  System.out.println("This is before class method 2");
  }

  @AfterClass
  public void afterClass2() {
	  System.out.println("This is after class method 2");
  }

  
  @BeforeTest
  public void beforeTest2() {
	  System.out.println("This is before test method 2");
  }

  
  @BeforeSuite
  public void beforeSuite2() {
	  System.out.println("This is before suite method 2");
  }

  @AfterSuite
  public void afterSuite2() {
	  System.out.println("This is after suite method 2");
  }

}
