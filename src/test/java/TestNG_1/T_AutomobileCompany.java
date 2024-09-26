package TestNG_1;

import org.testng.annotations.*;

public class T_AutomobileCompany {

	@Test
	@Parameters({"AutomobileCompanyName"})
	public void testCase1(String name)
	{
		System.out.println("Automobile Company Name is : "+name);
	}
}