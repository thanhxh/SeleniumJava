package com.thanh.listeners;

import com.aventstack.extentreports.Status;
import com.thanh.helpers.CaptureHelpers;
import com.thanh.reports.ExtentReportManager;
import com.thanh.reports.ExtentTestManager;
import com.thanh.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("onFinish: " + result.getEndDate());
        CaptureHelpers.stopRecord();
        ExtentReportManager.getExtentReports().flush(); //Kết thúc và thực thi xuất report
    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("onFinish: " + result.getStartDate());
        CaptureHelpers.startRecord(result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " is pass.");
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println(result.getName() + " is fail.");
        CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi fail
        Log.error(result.getName() + " is fail.");
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.warn(result.getName() + " is skipped.");
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());

    }

}
