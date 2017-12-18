package com.crm.qa.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter =0;
	int counterLimit=3;
	public boolean retry(ITestResult result) {
		if(counter<counterLimit){
			counter++;
			return true;
		}return false;
	}

}

