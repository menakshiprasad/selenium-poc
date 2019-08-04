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

public class Demo03 {
  @Test
   public void test3() {
	  System.out.println("This is test 3");
  }
  @BeforeMethod
  public void beforeMethod1() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod1() {
	  System.out.println("This is after method");
  }
  @BeforeMethod
  public void beforeMethod2() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod2() {
	  System.out.println("This is after method");
  }

  @BeforeClass
  public void beforeClass1() {
	  System.out.println("This is before class method");
  }

  @AfterClass
  public void afterClass1() {
	  System.out.println("This is after class method");
  }
  @BeforeClass
  public void beforeClass2() {
	  System.out.println("This is before class method");
  }

  @AfterClass
  public void afterClass2() {
	  System.out.println("This is after class method");
  }

  @BeforeTest
  public void beforeTest1() {
	  System.out.println("This is before test method");
  }

  @AfterTest
  public void afterTest1() {
	  System.out.println("This is after test method");
  }
  @BeforeTest
  public void beforeTest2() {
	  System.out.println("This is before test method");
  }

  
  @BeforeSuite
  public void beforeSuite1() {
	  System.out.println("This is before suite method");
  }

  @AfterSuite
  public void afterSuite1() {
	  System.out.println("This is after suite method");
  }
  @BeforeSuite
  public void beforeSuite2() {
	  System.out.println("This is before suite method");
  }

  @AfterSuite
  public void afterSuite2() {
	  System.out.println("This is after suite method");
  }

}
