package com.cal.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener{
	
	
	@Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Method Executing:" + method.getTestMethod().getMethodName()+"  , Test Results :"+testResult.getStatus());
    }
	
	
	@Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Method Executing:" + method.getTestMethod().getMethodName());
    }

    
	
	

}
