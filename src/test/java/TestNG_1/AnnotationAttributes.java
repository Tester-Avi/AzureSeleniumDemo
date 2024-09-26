package TestNG_1;

import org.testng.annotations.*;

public class AnnotationAttributes {

	@Test(enabled = false)
	public void testCase1()
	{
		System.out.println("Mobile Login TestCase...");
	}
	
	@Test
	public void testCase2()
	{
		System.out.println("Web Login TestCase...");
	}
	
	@Test
	public void testCase3()
	{
		System.out.println("API Login TestCase...");
	}
	
	@Test
	public void testCase4()
	{
		System.out.println("IOS Login TestCase...");
	}
}
