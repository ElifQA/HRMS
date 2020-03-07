package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LeaveListPageTest extends CommonMethods{

	@Test(groups = "regression")
	public void leaveLabelvalidation() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();
		test.info("Loggin into the application");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		test.info("Navigating to the Leave List List");
		jsClick(dashboard.leaveLnk);
		jsClick(dashboard.leaveList);
		test.info("Validating Leave List Label");
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
	}		
	
	@Test(groups="regression")
	public void leaveLabelvalidation1() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard=new DashboardPageElements();
		LeaveListPageElements leaveLnk=new LeaveListPageElements();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToLeaveList();
		Assert.assertTrue(leaveLnk.leaveListLbl.isDisplayed(), "Label is not displayed");
		//Assert.assertTrue(false);
		}
}
