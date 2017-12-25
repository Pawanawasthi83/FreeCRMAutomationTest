package com.crm.qa.utils.commonutils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderHelper {

	String filepath;
		
	@DataProvider(name="newcontact",parallel=false)
	public Object[][] getUserLoginData() throws IOException{
		String datasheet="NewContact";
		filepath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"
				+File.separator+"java"+File.separator+"com"+File.separator+"crm"+File.separator+"qa"+File.separator+"testdata"
				+File.separator+"TestData_Sheet.xlsx";
		
		ExcelHelper reader = new ExcelHelper(filepath);
		int row = reader.getRowCount(datasheet.toString());
		int col = reader.getColumnCount(datasheet.toString());
		
		Object[][] arr;
		arr=new Object[row-1][col];
		for(int i=1;i<row;i++){
			for(int j=0;j<col;j++){
				arr[i-1][j]=reader.excelReader(datasheet, i, j);
			}
	}
		return arr;
}
}
