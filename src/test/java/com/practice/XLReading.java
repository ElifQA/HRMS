package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReading {
	@Test
	public void read()throws Exception{
		String filePath="C:\\Users\\MelekAsim\\Desktop\\Book1.xlsx";
		// create file input stream object and load file
		FileInputStream fis =new FileInputStream(filePath);
		//to read excel we need to use different classes
		//Workbook wbook=HSSFWorkbook() --> 2003 xfiles
		//create object for workbook and load file
		Workbook wbook=new XSSFWorkbook(fis);//2007 files            workbook=interface
		// get the sheet which you want to modify or create
		Sheet xlsheet=wbook.getSheet("Sheet1");
		//create object for rowRow row = sheet.getRow
		Row row=xlsheet.getRow(0);
		//create object for cell
		Cell cell=row.getCell(0);
		//get and print the value from specific cell
		String value=cell.toString();
		System.out.println(value);
		
		String value2=xlsheet.getRow(1).getCell(1).toString();
		System.out.println(value2);
		
	}
	

}
