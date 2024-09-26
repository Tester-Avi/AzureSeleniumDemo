package TestNG_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginForm {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/v1/");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
			
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Swag Labs");
		driver.quit();
		
		Actions act = new Actions(driver);
		
		Action seriesOfAction = act.moveToElement(driver.findElement(By.id("user-name")))
								.click()
								.sendKeys("standard_user", Keys.TAB)
								.sendKeys("secret_sauce", Keys.ENTER).build();
		seriesOfAction.perform();
	}
}