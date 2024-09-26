package TestNG_2;

import org.testng.annotations.*;

public class B_LoginTest {

	@Test
	public void LoginByMobileNumber(){
		System.out.println("Login By Mobile Number passed...");
	}
	
	@Test
	public void LoginByEmail() {
		System.out.println("Login By Email passed...");
	}
}
