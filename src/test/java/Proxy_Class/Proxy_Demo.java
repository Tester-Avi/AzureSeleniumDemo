package Proxy_Class;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proxy_Demo {

public static void main(String[] args) {
		
		Proxy prxy = new Proxy();
		prxy.setAutodetect(false);
//		prxy.setHttpProxy("localhost:8080");
		prxy.setSslProxy("localhost:8080");
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("prxy", prxy);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com");

	}
}
