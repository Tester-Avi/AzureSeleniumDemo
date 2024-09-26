package TestNG_1;

import org.testng.annotations.*;

public class T_SoftwareCompany {

	@Test
	@Parameters({"SofwareCompanyName"})
	public void testCase2(String name)
	{
		System.out.println("Software Company Name is : "+name);
	}
}