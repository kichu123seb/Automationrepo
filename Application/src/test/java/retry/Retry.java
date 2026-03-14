package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retrylimit = 2;// count of reexecution

	public boolean retry(ITestResult result) {
		if (counter < retrylimit) {
			counter++;// reexecution
			return true;
		}
		return false;// stop execution

	}

}
