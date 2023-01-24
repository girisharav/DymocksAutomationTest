package genericUtilities;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass extends BaseClass implements ITestListener{
	
	public void onTestFailure(ITestResult result,WebDriver driver) throws IOException {
		// Calling after method after testing is failed.		
			AM(result);		
		}
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	
}
