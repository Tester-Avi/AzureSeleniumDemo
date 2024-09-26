package HEALTHCARE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Velocity {

	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@Test(priority = 1)
	public void verifyLogin()
	{
		driver.get("https://clientaccesstest.precheck.com/LoginCheck.aspx?mode=9");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("aagarwal");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("PRECHECK");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtClientID")).sendKeys("7519");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
	}
	
	
	@Test(priority = 2)
	public void redirectToOrderPage()
	{
		driver.findElement(By.xpath("//a[text()='Place a new order for a background report']")).click();
		driver.findElement(By.xpath("//span[text()='Invitation']")).click();
	}
	
	@Test(priority = 3)
	public void CreateOrderPage()
	{
		
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();

		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}

		
		
		
		
		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("Adam");
		
		
//		driver.findElement(By.id("FirstName")).sendKeys("Adam");
		driver.findElement(By.id("MiddleName")).sendKeys("James");
		driver.findElement(By.id("LastName")).sendKeys("Smith");
		driver.findElement(By.id("Email")).sendKeys("aviral.agarwal@cisive.com");
		
		WebElement facility = driver.findElement(By.xpath("//span[contains(text(),'Select the Facility')]"));
		
		Select sel = new Select(facility);
		sel.selectByVisibleText("Clear Lake Regional Medical Center");
		
		
	}
	
	

	@AfterTest
	public void Quit()
	{
		driver.quit();
	}
}
