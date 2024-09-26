package TestNG_Demo;

import org.testng.annotations.*;

public class CheckPriority {

	@Test (priority = -1)
	public void abaa()
	{
		System.out.println("This is Test abaa...");
	}
	
	@Test (priority = -2)
	public void aabb()
	{
		System.out.println("This is Test aabb...");
	}
	
	@Test (priority = -3)
	public void aaaa()
	{
		System.out.println("This is Test aaaa...");
	}
	
	@Test (priority = -10)
	public void aaac()
	{
		System.out.println("This is Test aaac...");
	}
	
	@Test (priority = 3)
	public void aacbbb()
	{
		System.out.println("This is Test aacbbb...");
	}
	
}
