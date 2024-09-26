package TestNG_5;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport()
	{
		htmlReporter = new ExtentSparkReporter("Part-51_Report.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add system Information/environment info to reports
		reports.setSystemInfo("Machine: ", "testpc1");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser: ", "chrome");
		reports.setSystemInfo("user name : ", "Aviral Agarwal");

		// Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("First Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'");

	}


	// On Start method is called, when any Test Starts.
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On Start Method Invoked....");
	}

	// On Finish method is called, when all Test cases Finished.
	public void onFinish(ITestContext context) {
		System.out.println("On Finished Method Invoked....");
		reports.flush();
	}

	// when Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result){
		System.out.println("Name of Test Method Failed : "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed Test Case is : "+Result.getName(), ExtentColor.RED));
	}

	// when Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of Test Method Skipped : "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped Test Case is : "+Result.getName(), ExtentColor.YELLOW));
	}

	// When Test get Started, this method is called
	public void onTestStart (ITestResult Result) {
		System.out.println("Name of Test Method Started : " + Result.getName());
	}

	// When Test Case get passed, this method is called
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of Test Method Successfully Passed : "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed Test Case is : "+Result.getName(), ExtentColor.GREEN));
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
}
