package TestNG_5;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDataProviderWithExcel {

	WebDriver driver;

	@BeforeMethod
	public void setUp ()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "searchDataProvider")
	public void searchKeyword(String keyword)
	{
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);

	}

	@DataProvider(name = "searchDataProvider")
	public Object[][] searchDataProviderMethod()
	{
		String fileName = "D:\\Eclipse_2021\\SearchData.xlsx";
		Object[][] searchData = getExcelData(fileName, "Sheet1");
		return searchData;
	}

	public String[][] getExcelData(String fileName, String sheetName) {

		//declare array
		String[][] data = null;

		// Open file in read open
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);

			// Create XSSFWorkBook Class object for Excel file
			XSSFWorkbook workBook = new XSSFWorkbook(fis);

			XSSFSheet excelSheet = workBook.getSheet(sheetName);

			// get total no. of rows
			int ttlRows = excelSheet.getLastRowNum() + 1;

			// get total no. of cells
			int ttlCells = excelSheet.getRow(0).getLastCellNum();
			
			//initialize array
			data = new String[ttlRows-1][ttlCells-1];
			
			for(int currentRow=1; currentRow<ttlRows; currentRow++) // for Row
			{
				for(int currentCell=0; currentCell<ttlCells; currentCell++) // For Cell
				{
					data[currentRow-1][currentCell] = excelSheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
					System.out.println(data);
				}
			}
			workBook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
