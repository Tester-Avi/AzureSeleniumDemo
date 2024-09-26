package TestNG_1;

import org.testng.annotations.*;

public class GroupAttribute {

	@Test(groups = "Software Company")
	public void infosys()
	{
		System.out.println("Infosys...");
	}

	@Test(groups = "Software Company")
	public void wipro()
	{
		System.out.println("Wipro...");
	}
	
	@Test(groups = "Automobile Company")
	public void maruti()
	{
		System.out.println("Maruti...");
	}
	
	@Test(groups = "Automobile Company")
	public void tata()
	{
		System.out.println("Tata...");
	}
}
