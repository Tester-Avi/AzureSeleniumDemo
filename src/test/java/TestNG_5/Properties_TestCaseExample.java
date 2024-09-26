package TestNG_5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Properties_TestCaseExample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		ReadConfigFile rc = new ReadConfigFile();
		
		driver.get(rc.getURL());
		driver.findElement(By.name("username")).sendKeys(rc.getUsername());
		driver.findElement(By.name("password")).sendKeys(rc.getPassword());
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
}