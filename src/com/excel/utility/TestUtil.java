package com.excel.utility;

import java.util.ArrayList;
import com.excel.utility.Xls_Reader;


public class TestUtil {
	
	static Xls_Reader reader;
	 
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		reader = new Xls_Reader("/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG"
				+ "/src/com/testdata/YahooLoginTestData.xlsx");
		
		for(int rowNum=2; rowNum<= reader.getRowCount("Sheet1"); rowNum++) {
			
			String firstName = reader.getCellData("Sheet1", "firstName", rowNum);
			String surName = reader.getCellData("Sheet1", "surName", rowNum);
			String eMail = reader.getCellData("Sheet1", "eMail", rowNum);
			String mobile = reader.getCellData("Sheet1", "mobile", rowNum);
			String birthMonth = reader.getCellData("Sheet1", "birthMonth", rowNum);
			String birthDay = reader.getCellData("Sheet1", "birthDay", rowNum);
			String birhtYear = reader.getCellData("Sheet1", "birhtYear", rowNum);
			String gender = reader.getCellData("Sheet1", "gender", rowNum);
			
			Object ob[] = {firstName, surName, eMail, mobile, birthMonth, birthDay, birhtYear, gender};
			myData.add(ob);
			
		}
		return myData;
	}

}
