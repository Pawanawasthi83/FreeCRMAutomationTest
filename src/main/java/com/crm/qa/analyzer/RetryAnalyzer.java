package com.crm.qa.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter =0;
	int counterLimit=3;
	public boolean retry(ITestResult result) {
		System.out.println("Status : "+result.getStatus());
		System.out.println("======"+counter);
		if(result.getStatus()==2){
		if(counter<counterLimit){
			counter++;
			return true;
		}return false;
		}
		return false;
		
	}

}

