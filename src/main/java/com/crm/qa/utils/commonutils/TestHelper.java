package com.crm.qa.utils.commonutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestHelper extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=120;
	public static long IMPLICIT_WAIT=60;
	public static long EXPLICIT_WAIT=60;
	
	public static void switchToFrame(WebElement frame){
		WebDriverWait wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
	}
	
	public static String takeScreenShot(String methodName){
		String targetPath=System.getProperty("user.dir")
				+File.separator+"screenshots"+File.separator+methodName+"_"+System.currentTimeMillis()+".jpg";
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(targetPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetPath;
		
	}
	
	public static String getMethodName() {
	    return Thread.currentThread().getStackTrace()[2].getMethodName();
	} 
}
