package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class XLAddEmployee extends CommonMethods{
	
	@Test  (dataProvider= "getDataFromXL")
	public void addEmpfromXL(String fName, String lName) {
		LoginPageElements login=new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		DashboardPageElements dashboard=new DashboardPageElements();
		AddEmployeePageElements addemp=new AddEmployeePageElements();

		dashboard.navigateToAddEmployee();
		addemp.fName.sendKeys(fName);
		addemp.lName.sendKeys(lName);
		addemp.btnSave.click();
		click(addemp.personalDetail);
		Assert.assertEquals(addemp.personalDetail.getText(), fName+" "+lName, "Name does not match");
		
		
	}
	@DataProvider(name="getDataFromXL")
	public Object [][] getDataFromXL() throws Exception{
		String filePath=System.getProperty("user.dir")+"C:\\Users\\MelekAsim\\Desktop\\AddEmp.xlsx";
		FileInputStream fis =new FileInputStream(filePath);
		Workbook wbook=new XSSFWorkbook(fis);
		Sheet xlsheet=wbook.getSheet("Sheet1");
		int row=xlsheet.getPhysicalNumberOfRows();
	
		int cell=xlsheet.getRow(0).getLastCellNum();
		Object data [][] =new Object [row] [cell];
		for (int i=0; i<row; i++) {
			for( int j=0; j<cell; j++) {
				data[i][j]=xlsheet.getRow(row).getCell(j).toString();
			}
		}
		
		
		return data;
		
	}
	
}



