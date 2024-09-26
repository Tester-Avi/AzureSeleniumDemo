package TestNG_5;

import org.testng.SkipException;
import org.testng.annotations.*;

import junit.framework.Assert;

public class TestCaseExample {

	@Test
	public void testMethod1()
	{
		System.out.println("This is Test method-1...");
		Assert.assertTrue(true); //Pass
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("This is Test method-2...");
		Assert.assertTrue(false); //Fail
	}
	
	@Test
	public void testMethod3()
	{
		System.out.println("This is Test method-3...");
		Assert.assertTrue(false); //Fail
	}
	
	@Test
	public void testMethod4()
	{
		System.out.println("This is Test method-4...");
		Assert.assertTrue(true); //Pass
	}
	
	@Test
	public void testMethod5()
	{
		System.out.println("This is Test method-1...");
		throw new SkipException("This Test Method is skipped..."); //Skip
	}
	
}
