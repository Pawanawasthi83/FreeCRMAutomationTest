package com.crm.qa.utils.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter =0;
	int counterLimit=3;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()){
		if(counter<counterLimit){
			counter++;
			return true;
		}return false;
		}
		return false;
		
	}

}

