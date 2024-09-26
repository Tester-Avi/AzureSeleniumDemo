package TestNG_1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

	// On Start method is called, when any Test Starts.
	public void onStart(ITestContext Result) {
		System.out.println("On Start Method Invoked....");
	}

	// On Finish method is called, when all Test cases Finished.
	public void onFinish(ITestContext context) {
		System.out.println("On Finished Method Invoked....");
	}

	// when Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result){
		System.out.println("Name of Test Method Failed : "+ Result.getName());
	}

	// when Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of Test Method Skipped : "+ Result.getName());
	}

	// When Test get Started, this method is called
	public void onTestStart (ITestResult Result) {
		System.out.println("Name of Test Method Started : " + Result.getName());
	}

	// When Test Case get passed, this method is called
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of Test Method Successfully Passed : "+ Result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
}
