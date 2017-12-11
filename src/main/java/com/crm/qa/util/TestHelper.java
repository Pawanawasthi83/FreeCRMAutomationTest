package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TestHelper extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=120;
	public static long IMPLICIT_WAIT=30;
	public static long EXPLICIT_WAIT=30;
	
	public static void switchToFrame(WebElement frame){
		
		driver.switchTo().frame(frame);
	}
	
	public static void takeScreenShot(){
		String targetPath=System.getProperty("user.dir")
				+File.separator+"screenshots"+File.separator+System.currentTimeMillis()+".jpg";
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(targetPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getMethodName() {
	    return Thread.currentThread().getStackTrace()[2].getMethodName();
	} 
}
