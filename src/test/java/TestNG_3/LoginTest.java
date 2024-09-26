package TestNG_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");
		
		LoginPage2 pg = new LoginPage2(driver);
		
		pg.enterUsername("standard_user");
		pg.enterPassowrd("secret_sauce");
		pg.clickLoginBtn();

	}

}
