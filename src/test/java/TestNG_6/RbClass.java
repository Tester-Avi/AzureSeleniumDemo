package TestNG_6;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RbClass {

	public static void main(String[] args) throws AWTException {

		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_2021\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/upload-download");

		//		driver.findElement(By.xpath("//input[@id='uploadFile']")).click();
		// if above not worked, then use Action Class

		WebElement uploadBtnClick = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		Actions act = new Actions(driver);
		act.moveToElement(uploadBtnClick).click().perform();

		Robot rb = new Robot();
		rb.delay(2000);

		// copy file to clipboard
		StringSelection ss = new StringSelection("D:\\SmartClient - Project\\Dummy Doc Files\\-8910728946430324808.PDF"); // Put path of file in it
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// perform control + V action to paste file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
}