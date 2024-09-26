package TestNG_4;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	// counter to keep track of retry attempts
	int counterForRetryAttemps = 0;
	
	// set max limit for retry
	int setMaxLimitForRetry = 3;

	// Method to retry failed test cases
	public boolean retry(ITestResult result) {
		
		if(counterForRetryAttemps < setMaxLimitForRetry)
		{
			counterForRetryAttemps++;
			return true;
		}
		return false;
	}
}