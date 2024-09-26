package TestNG_5;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class BasicExtentListenerDemo {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport()
	{
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add system Information/environment info to reports
		reports.setSystemInfo("Machine: ", "testpc1");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser: ", "chrome");
		reports.setSystemInfo("user name : ", "Aviral Agarwal");

		// Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@Test
	public void LaunchBrowserAndOpenURL()
	{
		// create test
		test = reports.createTest("Launch browser and open URL");
		Assert.assertTrue(true);  // test pass
	}

	@Test
	public void VerifyTitle()
	{
		// create test
		test = reports.createTest("Verify Title");
		Assert.assertTrue(false); // test failed
	}

	@Test
	public void VerifyLogo()
	{
		// create test
		test = reports.createTest("Verify Logo");
		Assert.assertTrue(true); // test pass
	}

	@Test
	public void VerifyEmail()
	{
		// create test
		test = reports.createTest("Verify Email");
		throw new SkipException("Skipping this test case with exception...");
	}

	@Test
	public void VerifyUserName()
	{
		// create test
		test = reports.createTest("Verify UserName");
		Assert.assertTrue(true); // test pass
	}

	@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" FAIL",ExtentColor.RED));
			
			// if want to log more info
			test.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +" PASS",ExtentColor.GREEN));
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +" SKIPPED",ExtentColor.YELLOW));
		}
	}

	@AfterTest
	public void tearDown()
	{
		reports.flush(); //mandatory to write
	}
}
