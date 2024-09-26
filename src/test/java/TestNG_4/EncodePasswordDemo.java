package TestNG_4;

import java.time.Duration;

import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EncodePasswordDemo {

	public static void main(String[] args) {
		
		//encode password
		
		String password = "admin123";
	
		byte[] encodedPassword = Base64.encodeBase64(password.getBytes());
		
		System.out.println("Encoded Password is : "+(new String(encodedPassword)));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		byte[] decodePassword = Base64.decodeBase64("YWRtaW4xMjM=");
		
		System.out.println("Decoded Password is : "+(new String(decodePassword)));
		
		driver.findElement(By.name("password")).sendKeys(new String(decodePassword));
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		
		
	}
}
