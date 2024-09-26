package TestNG_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestNGParameterGoogleSearch {

	@Parameters({"keyword"})
	@Test
	public void googleSearch(String searchData)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys(searchData);
		
		Assert.assertEquals(searchData, searchBox.getAttribute("value"));
		
		driver.quit();
	}
}
