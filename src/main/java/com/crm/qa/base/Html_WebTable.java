package com.crm.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Html_WebTable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String _start_path= "//*[@id='innings_1']/div[1]/div[";
		String _middle_path="]/div[";
		String _end_path = "]";
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18188/sl-vs-ban-1st-t20i-bangladesh-tour-of-sri-lanka-2017");
		int rows = driver.findElements(By.xpath("//*[@id='innings_1']/div[1]/div")).size();
		System.out.println("Number Of Rows : "+rows);
		int colms = driver.findElements(By.xpath(".//*[@id='innings_1']/div[1]/div[2]/div")).size();
		System.out.println("Number Of Columns : "+colms);
		for(int i=1;i<=rows-4;i++){
			for(int j=1;j<=colms;j++){
				String text = driver.findElement(By.xpath(_start_path+(i+1)+_middle_path+j+_end_path)).getText();
				System.out.print(text + "      ");
			}
			System.out.println();}
	
	
		System.out.println("Completed.........");
	}

}
