package TestNG_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {

//	1. India Qutub Minar
//	2. Agra Taj Mahal
//	3. Hyderabad Charminar
	
	
	@DataProvider(name = "searchDataSet")
	public Object[][] searchData()
	{
		Object[][] searchKeyword = new Object[3][2];
		searchKeyword[0][0] = "India";
		searchKeyword[0][1] = "Qutub Minar";
		
		searchKeyword[1][0] = "Agra";
		searchKeyword[1][1] = "Taj Mahal";
		
		searchKeyword[2][0] = "Hyderabad";
		searchKeyword[2][1] = "Charminar";
		
		return searchKeyword;
	}
	
	@Test(dataProvider = "searchDataSet")
	public void testCaseGoogleSearch(String country, String monumnet)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		
		//enter key combination of country and monument
		searchBox.sendKeys(country+ " "+monumnet);
		
		driver.findElement(By.name("btnK")).click();
		
		driver.quit();
	}
}
