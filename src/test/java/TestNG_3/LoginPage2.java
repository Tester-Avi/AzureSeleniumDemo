package TestNG_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//With Page Factory
public class LoginPage2 {

	WebDriver driver;
	
	// Constructor
	LoginPage2(WebDriver d)
	{
		driver = d;
	
		// this method will create web elements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginBtn;
	

	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterPassowrd(String pwd)
	{
		password.sendKeys(pwd);	
	}
	
	public void clickLoginBtn()
	{
		loginBtn.click();
	}

}