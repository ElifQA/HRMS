package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XlRecap {
	@Test
	public void read() throws Exception {
		String filePath="C:\\Users\\MelekAsim\\Desktop\\AddEmp.xlsx";
		FileInputStream fis =new FileInputStream(filePath);
		Workbook wbook=new XSSFWorkbook(fis);
		Sheet xlsheet=wbook.getSheet("Login");
		
		String value1=xlsheet.getRow(1).getCell(0).toString();
		System.out.println(value1);
		int rows=xlsheet.getPhysicalNumberOfRows();
		int cols=xlsheet.getRow(0).getLastCellNum();
		System.out.println(rows);
		System.out.println(cols);
		Object [][]data=new Object [rows-1][cols];
		//looping from 2row of excel (eliminate header) we dont need header
		for (int i=1; i<rows; i++) {
			//looping frm 1 column in excel
			for (int y=0; y<cols; y++) {
				
				String value=xlsheet.getRow(i).getCell(y).toString();
				System.out.println(value);
				//storing retrived data 2d object array
				data[i-1][y]=value;
				
			}
				
			}
		wbook.close();
		fis.close();
		System.out.println("----------------------------");
		for (Object[] rowArray :data) {
			for(Object d:rowArray) {
				System.out.println(d);
			}
		}
		
		
		
	}
	

}
