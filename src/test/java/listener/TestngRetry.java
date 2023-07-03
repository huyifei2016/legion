package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class TestngRetry implements IRetryAnalyzer {

	private int retryCnt = 1;
	private int maxRetryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCnt <= maxRetryCount){
			result.setAttribute("RETRY", retryCnt);
			retryCnt++;
			return true;
		}
		return false;
	}

	public void reset() {
		retryCnt = 1;
	}

}
