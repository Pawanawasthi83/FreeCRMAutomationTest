package com.crm.qa.utils.commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class TestHelper extends TestBase {

	public static void switchToFrame(WebElement frame) {
		// WebDriverWait wait = new WebDriverWait(driver,
		// TestConfig.EXPLICIT_WAIT);
		waitDriver.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

	}

	public static String takeScreenShot(String methodName) {
		String targetPath = TestConfig.screenShotPath + methodName + "_" + System.currentTimeMillis() + ".jpg";
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(targetPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetPath;

	}

	public static Properties getPropConfiguration(String path) {
		FileInputStream fis;
		try {
			prop = new Properties();
			File file = new File(path);
			if (file.exists()) {
				fis = new FileInputStream(file);
				prop.load(fis);
			} else {
				log.error("File Not Found At Location : " + TestConfig.configPropertyPath);
			}

		} catch (FileNotFoundException e) {
			log.error("File Not Found : ", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
