package TestNG_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ParalletTestDemo1 {

	WebDriver driver;
	
	@Test
	public void verifyTitle() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");
		String expectedTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, "Swag Labs");
		driver.quit();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyLogo() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='login_logo']"));
		
		Assert.assertTrue(logo.isDisplayed());
		driver.quit();
	}
}