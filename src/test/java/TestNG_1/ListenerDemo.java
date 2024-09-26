package TestNG_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerDemo {

	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test
	public void testFail()
	{
		System.out.println("Failed Test Case...");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testSkipped()
	{
		System.out.println("Skipped Test Case...");
		throw new SkipException("skip Exception throws....");
	}
	
}

