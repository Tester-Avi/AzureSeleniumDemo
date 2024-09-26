package TestNG_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class TestNGReportExample {

	public void googleSearch() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Reporter.log("Google Url Opened...");
		
		System.out.println("Before Search Title : " +driver.getTitle());

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("India Gate");
		Reporter.log("India Gate entered...");
		
		searchBox.sendKeys(Keys.ENTER);
		Reporter.log("Search Key pressed...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("After Search Title : " +driver.getTitle());
		
		driver.quit();
		Reporter.log("Browser Closed...");

	}
}

