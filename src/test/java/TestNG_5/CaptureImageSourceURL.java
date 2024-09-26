package TestNG_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureImageSourceURL {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement imageLogo = driver.findElement(By.xpath("//img[@class='fb_logo_8ilh img']"));
		
		// capture src attribute value of Image logo
		System.out.println("SRC attribute Value : "+imageLogo.getAttribute("src"));
	}
}
