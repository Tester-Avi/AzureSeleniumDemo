package TestNG_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadlessBrowserTesting {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
//		options.setHeadless(true);
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		System.out.println("Before Search Title : " +driver.getTitle());
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("India Gate");
		searchBox.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After Search Title : " +driver.getTitle());
		
	}
}

