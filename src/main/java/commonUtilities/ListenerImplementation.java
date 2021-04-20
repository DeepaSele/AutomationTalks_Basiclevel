package commonUtilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import basePackage.BaseClass;
import basePackage.InitializeObjectforAllPages;

public class ListenerImplementation extends InitializeObjectforAllPages implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		//Before each test starts..
		 test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//below line will generate in the Extentreport
		test.log(Status.FAIL,"Fail testcase is: "+result.getMethod().getMethodName());
		
		//below line for for what reason its failed for that throwing the exception
		test.log( Status.FAIL, result.getThrowable());
		
		//Below line method created in Baseclass make it into static to take screen shot
		BaseClass.failedTC_takescreenshot(result.getMethod().getMethodName());
		
		
		//Below line -Took screenshot, how you will add screenshot to our report. Using Extenttext class
		//Getting error while executing below line -Screencapture path is not null or empty
		//test.addScreenCaptureFromPath(destinationpath, "Test is failed with s/s");
		
		
		  
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// we need to call Set up..We will get execution report include all the tests
		extent =ExtentReportSetup.setupextendreport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//close the extent report
		extent.flush();
		
	}   


}
