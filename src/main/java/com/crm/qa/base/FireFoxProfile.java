package com.crm.qa.base;

import org.openqa.selenium.firefox.FirefoxProfile;

import com.crm.qa.utils.commonutils.TestConfig;

public class FireFoxProfile {

	private static FirefoxProfile profile;
	
	public static FirefoxProfile fireFoxProfile(){
		
		profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.panel.shown", false);
		profile.setPreference("browser.download.useDownloadDir", TestConfig.downloadDirPath);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip");
		return profile;
		
	}
	
	
}
