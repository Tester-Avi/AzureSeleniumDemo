package TestNG_4;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestCasesExample {

	@Test
	public void TestCase01()
	{
		Assert.assertTrue(false); // test case will fail
	}
	
	@Test
	public void TestCase02()
	{
		Assert.assertTrue(false); // test case will fail
	}
	
	@Test
	public void TestCase03()
	{
		Assert.assertTrue(true); // test case will pass
	}
}