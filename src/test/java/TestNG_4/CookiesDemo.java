package TestNG_4;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		//capture all the cookies
		Set <Cookie> cookiesList = driver.manage().getCookies();

		//print size/number of cookies
		System.out.println("Total No. of Cookies Before Adding : "+cookiesList.size());

		for(Cookie ck:cookiesList)
		{
			System.out.println(ck.getName() +" : "+ck.getValue());
		}

		//get specific cookie according to name

		System.out.println(driver.manage().getCookieNamed("i18n-prefs"));


		// Create Cookie
		Cookie cookieObj = new Cookie("TestCookie", "www.amazon.in");

		// add	cookie to browser
		driver.manage().addCookie(cookieObj);


		cookiesList = driver.manage().getCookies();

		//print size/number of cookies
		System.out.println("Total No. of Cookies After Adding : "+cookiesList.size());

		for(Cookie ck:cookiesList)
		{
			System.out.println(ck.getName() +" : "+ck.getValue());
		}

		// delete all cookies 
		
		driver.manage().deleteAllCookies();
		
		cookiesList = driver.manage().getCookies();

		//print size/number of cookies
		System.out.println("Total No. of Cookies After Deleting : "+cookiesList.size());

		for(Cookie ck:cookiesList)
		{
			System.out.println(ck.getName() +" : "+ck.getValue());
		}

		driver.quit();
	}
}