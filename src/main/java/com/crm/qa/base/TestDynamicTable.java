package com.crm.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDynamicTable {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get(
				"http://www.cricbuzz.com/live-cricket-scorecard/18188/sl-vs-ban-1st-t20i-bangladesh-tour-of-sri-lanka-2017");

		String startPath = "//*[@id='innings_1']/div[1]/div[";
		String middlePath = "]/div[";
		String endPath = "]";

		int rows = driver.findElements(By.xpath("//*[@id='innings_1']/div[1]/div")).size();
		System.out.println("Number Of Rows : " + rows);

		int cols = driver.findElements(By.xpath(".//*[@id='innings_1']/div[1]/div[2]/div")).size();
		System.out.println("Number Of Columns : " + cols);

		for (int i = 1; i <= rows - 4; i++) {
			for (int j = 1; j <= cols; j++) {
				String text = driver.findElement(By.xpath(startPath + (i + 1) + middlePath + j + endPath)).getText();
				System.out.print(text + "      ");
			}
			System.out.println();
		}
		driver.quit();
		System.out.println("Completed.........");
	}

}
