package TestNG_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionDemo {

	@Test
	public void testMethod()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		SoftAssert sa = new SoftAssert();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		System.out.println("Verifying Title.....");
		String expectedTitle = "Automation Testing Practices";
		String actualTitle = driver.getTitle();
		sa.assertEquals(actualTitle, expectedTitle, "Title Verified");

		System.out.println("Verifying presence of wikipedia-icon");
		WebElement icon = driver.findElement(By.className("wikipedia-icon"));
		sa.assertTrue(icon.isDisplayed());
		
		System.out.println("Verifying presence of wikipedia-search-icon");
		WebElement searchBtn = driver.findElement(By.className("wikipedia-search-button"));
		sa.assertTrue(searchBtn.isDisplayed());
		
		driver.close();
		
		// report all failure messages
		sa.assertAll();
	}
}