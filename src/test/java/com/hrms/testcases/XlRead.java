package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XlRead {
	@Test
	public void excel() throws IOException {
		String filePath="C:\\Users\\MelekAsim\\Desktop\\AddEmp.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		
		Workbook wbook=new  XSSFWorkbook(fis); 
		Sheet xlsheet=wbook.getSheet("sheet1");
		int rows=xlsheet.getPhysicalNumberOfRows();
		int colls=xlsheet.getRow(0).getLastCellNum();
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<colls; j++) {
				String value=xlsheet.getRow(i).getCell(j).toString();
				System.out.println(value);
				
			}
		}
		
		
	}

}
