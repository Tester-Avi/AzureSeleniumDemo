package TestNG_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Without Page Factory
public class LoginPage {

	WebDriver driver;

	// Constructor
	LoginPage(WebDriver d)
	{
		driver = d;
	}

	//Locate WbeElements
	By username = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");

	public void enterUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassowrd(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(loginBtn).click();
	}

}


