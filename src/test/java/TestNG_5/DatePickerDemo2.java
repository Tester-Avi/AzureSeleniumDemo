package TestNG_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo2 {

	public static void main(String[] args) {

		String expectedDay = "26";
		String expectedMonthYear = "May 2024";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.goibibo.com/hotels/?gihp");

		//find date picker WebElement to perform click action
		WebElement datePicker = driver.findElement(By.xpath("//div[normalize-space()='Check-in']"));
		datePicker.click();

		while(true)
		{
			String calendarMonthYear = driver.findElement(By.xpath("//span[@data-testid='currentCalendarMonthName']")).getText();

			if(calendarMonthYear.equalsIgnoreCase(expectedMonthYear))
			{
				List<WebElement> daysList = driver.findElements(By.xpath("//div/ul/li/span"));
				//span[@data-testid='date_26_4_2024']

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
				driver.findElement(By.xpath("//span[@data-testid='calendarRightArrowBtn']")).click();
			}
		}

	}

}
