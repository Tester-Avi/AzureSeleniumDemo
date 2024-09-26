package TestNG_1;

import org.testng.annotations.*;

public class TestNGparameterDemo {

	@Test
	@Parameters({"i", "j"})
	public void add(int a, int b)
	{
		System.out.println("Add Value : "+(a+b));
	}

	@Test
	@Parameters({"i", "j"})
	public void substraction(int a, int b)
	{
		System.out.println("Subtract Value : "+(a-b));
	}
	
	@Test
	@Parameters({"i", "j"})
	public void multiply(int a, int b)
	{
		System.out.println("Multiply Value : "+(a*b));
	}
}
