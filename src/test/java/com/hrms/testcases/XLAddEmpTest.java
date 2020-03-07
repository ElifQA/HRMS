package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class XLAddEmpTest extends CommonMethods{
	
	@Test(dataProvider= "getData", groups ="regression")
	public void addEmpFromExl(String firstname, String lastname) throws InterruptedException {
		LoginPageElements login =new LoginPageElements();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		DashboardPageElements dash=new DashboardPageElements();
		dash.navigateToAddEmployee();
		
		Thread.sleep(3000);
		AddEmployeePageElements addemp=new AddEmployeePageElements();
		sendText(addemp.fName, firstname);
		sendText(addemp.lName, lastname);
		click(addemp.btnSave);
		click(addemp.personalDetail);
		Assert.assertEquals(addemp.personalDetail.getText(), firstname+" "+lastname, "Name does not match");
		
		
		}
	@DataProvider
	public Object [][] getData(){
		
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "newEmp");
		
	}
	
	

}

