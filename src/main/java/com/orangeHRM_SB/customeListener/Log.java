package com.orangeHRM_SB.customeListener;


import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.reports.ExtentManager;
import com.orangeHRM_SB.reports.ExtentTestManager;
import com.orangeHRM_SB.utilities.Screenshot;


public class Log extends TestListenerAdapter implements ITestListener{
	public static int DataSet = -1;
    public Log() {
    	
    }
    // Initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName());
    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    public static void startTestCase(String sTestCaseName) {
        Log.info("****************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$ " + sTestCaseName + "  $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("******************************************************************");
     }
    public static void endTestCase(String sTestCaseName) {
        Log.info("XXXXXXXXXXXXXXXX " + "-E---N---D-" + "   XXXXXXXXXXXXXX");
    }
    // Need to create these methods, so that they can be called
    public static void info(String temp, String message) {
    	Log.info(message);
    	try {
    		Thread.sleep(5000);
    		ExtentTestManager.getTest().info(message, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
    	}
    	catch(Exception e) {
    		e.getMessage();
    	}
    } 
    public static void info(String message) {
    	Log.info(message);
    	ExtentTestManager.getTest().log(Status.INFO, message);
    }
    public static void warn(String message) {
    	Log.warn(message);
    	ExtentTestManager.getTest().log(Status.WARNING, message);
    }
    /*
    public static void error(String message) {
    	Log.error(message);
    	ExtentTestManager.getTest().log(Status.ERROR, message);
    }
    public static void fatal(String message) {
        Log.fatal(message);
        ExtentTestManager.getTest().log(Status.FATAL, message);
    }
    public static void debug(String message) {
        Log.debug(message);
        ExtentTestManager.getTest().log(Status.DEBUG, message);
    } 
    */
    public void onStart(ITestContext context) {
    	System.out.println("*** Test Suite " + context.getName() + " started ***");
    }
    public void onFinish(ITestContext context) {
    	System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }
    public void onTestStart(ITestResult result) {    
        System.out.println(("*** Running test method " + result.getMethod().getMethodName()));
        ExtentTestManager.startTest(result.getMethod().getMethodName());       
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
        String temp = Screenshot.captureScreen(driverManager.getDriver(), result.getName());
        ExtentTestManager.getTest().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }
	public static  void info(String message, ExtentColor color) {
		ExtentTestManager.getTest().log(Status.INFO, MarkupHelper.createLabel(message, color));
	}
}