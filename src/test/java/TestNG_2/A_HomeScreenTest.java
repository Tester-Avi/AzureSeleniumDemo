package TestNG_2;

import org.testng.annotations.*;

public class A_HomeScreenTest {

	@Test
	public void LaunchApplication() {
		System.out.println("Application launched passed...");
	}
	
	@Test
	public void VerifyTitle() {
		System.out.println("Verify title passed...");
	}
	
	@Test
	public void VerifyLogo() {
		System.out.println("Verify logo passed...");
	}
	
	
}
