package selenium.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({Demo01.class,Demo02.class, Demo03.class})
public class SuiteClassAnnotation {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
