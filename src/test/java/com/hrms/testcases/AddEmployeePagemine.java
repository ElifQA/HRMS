package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class AddEmployeePagemine extends CommonMethods{
	
	@Test(groups="regression")
	public void addEmpValidation() throws InterruptedException {
		LoginPageElements login=new LoginPageElements();
		login.login("Admin", "Syntax@123");
		
		DashboardPageElements dashboard=new DashboardPageElements();
		dashboard.navigateToAddEmployee();
		Thread.sleep(3000);
		AddEmployeePageElements addemp=new AddEmployeePageElements();
		
		sendText(addemp.fName, "Bu");
		sendText(addemp.mName, "Nassii");
		sendText(addemp.lName, "is$");
		click(addemp.btnSave);
		click(addemp.personalDetail);
		Assert.assertEquals(addemp.personalDetail.getText(), "Bu Nassii is$", "Name does not match");
		
		
		
		
	}
	

}
