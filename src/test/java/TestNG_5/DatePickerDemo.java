package TestNG_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {

	public static void main(String[] args) {

		String expectedDay = "26";
		String expectedMonth = "May";
		String expectedYear = "1990";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(0);

		//find date picker WebElement to perform click action
		driver.findElement(By.id("datepicker")).click();

		while(true)
		{
			String calendarMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String calendarYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if(calendarMonth.equalsIgnoreCase(expectedMonth) && calendarYear.equalsIgnoreCase(expectedYear))
			{
				List<WebElement> daysList = driver.findElements(By.xpath("//table/tbody/tr/td"));

				for(WebElement e:daysList)
				{
					String calendarDay = e.getText();
					if(calendarDay.equals(expectedDay))
					{
						e.click();
						break;
					}
				}
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
		}
		
	}
	
}
