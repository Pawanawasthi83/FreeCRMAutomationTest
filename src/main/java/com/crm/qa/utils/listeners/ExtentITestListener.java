package com.crm.qa.utils.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.commonutils.TestHelper;
import com.crm.qa.utils.extentreports.ExtentManager;
import com.crm.qa.utils.extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentITestListener extends TestBase implements ITestListener{

	private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onTestStart method " +  getTestMethodName(result) + " start");
		ExtentTestManager.startTest(result.getMethod().getMethodName(), "");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("I am in onTestSuccess method " +  getTestMethodName(result) + " succeed");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("I am in onTestFailure method " +  getTestMethodName(result) + " Failed");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
		ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
		
		String ScreenPath = TestHelper.takeScreenShot(result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(LogStatus.FAIL,ExtentTestManager.getTest().addScreenCapture(ScreenPath));
		
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("I am in onTestSkipped method " +  getTestMethodName(result) + " Skipped");
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skiped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		ExtentTestManager.endTest();
		ExtentManager.getreport().flush();
		
	}

}
