package com.crm.qa.utils.commonutils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderHelper {

	
	@DataProvider(name="newcontact",parallel=false)
	public Object[][] getUserLoginData() throws IOException{
		String datasheet="NewContact";
		ExcelHelper reader = new ExcelHelper(TestConfig.testDataFile);
		
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
