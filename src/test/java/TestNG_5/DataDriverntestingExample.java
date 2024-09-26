package TestNG_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriverntestingExample {

	public static void main(String[] args) {

		XSSFWorkbook ExcelWBook = null;
		XSSFSheet ExcelWSheet;
		//		XSSFRow Row;
		//		XSSFCell Cell;

		// create an object of File class to open file
		File excelFile = new File("D:\\Eclipse_2021\\TestData.xlsx");

		// create an object of FileInputStream to read data from File
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Excel > Workbook > Sheet > row > cell
		//Create an object of XSSFWorkBook to handle xlsx file
		try {
			ExcelWBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// to access workbook sheet
		ExcelWSheet = ExcelWBook.getSheetAt(0);

		// get total row count
		int ttlRows = ExcelWSheet.getLastRowNum() + 1;

		// get total no. of cells in a row
		int ttlCells = ExcelWSheet.getRow(0).getLastCellNum();

		for(int currentRow=1; currentRow<ttlRows; currentRow++) // to read row
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.saucedemo.com/v1/");

			driver.findElement(By.id("user-name")).sendKeys(ExcelWSheet.getRow(currentRow).getCell(0).toString());
			
			driver.findElement(By.id("password")).sendKeys(ExcelWSheet.getRow(currentRow).getCell(1).toString());
			driver.findElement(By.id("login-button")).click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			for(int currentCell=0; currentCell<ttlCells; currentCell++) // to read cell 
//			{
//				System.out.println(ExcelWSheet.getRow(currentRow).getCell(currentCell).toString());
//				System.out.print("\t");
//			}
//			System.out.println();
			
			driver.quit();
		}

		try {
			ExcelWBook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
