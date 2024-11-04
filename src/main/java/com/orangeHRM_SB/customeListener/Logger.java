package com.orangeHRM_SB.customeListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Logger extends TestListenerAdapter implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult tr) {
		
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		
	}
	@Override
	public void onTestSkipped(ITestResult tr) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailedButWithinSuccessPercentage(tr);
	}
	@Override
	public void onStart(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onStart(testContext);
	}
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		super.onTestStart(result);
	}
}