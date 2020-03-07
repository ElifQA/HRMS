package com.hrms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods{
	//@Test(groups="smoke")
	public void login() throws InterruptedException {
		LoginPage login=new LoginPage();
		sendText(login.username,"Admin");
		sendText(login.password, "Syntax@123");
		Thread.sleep(1000);
		click(login.loginBtn);
		
	}
	//@Test
	public void emptyPassword() throws InterruptedException {
		LoginPage login=new LoginPage();
		sendText(login.username,"Admin");
		Thread.sleep(1000);
		click(login.loginBtn);
		String expected="Password cannot be empty";
		String actual=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actual, expected, "message not displayed");
		
		}
	
	//@Test
	public void emptyUserName() throws InterruptedException {
		LoginPage login=new LoginPage();
		sendText(login.password, ConfigsReader.getProperty("password"));
		Thread.sleep(1000);
		click(login.loginBtn);
		String expected="Username cannot be empty";
		//String actual=login.errMsg.getText();
		String actual=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actual, expected, "message not displayed");
	}
	//navigate to HRMS enter uid 
	//leave password field blank click login
	//verfy password cannot be empty"
	//close browser
	@Test(groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login =new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		String expectedError="Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		Thread.sleep(5000);
	}
	
	@Test (groups="smoke")
	public void loginProperties() {
		
		
		LoginPage login = new LoginPage();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		//takeScreenshot("Login");
		
}

	//@Test(dataProvider="getData")
	public void multipleLogin(String uid, String pwd) throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, uid );
		sendText(login.password, pwd);
		Thread.sleep(3000);
		click(login.loginBtn);
		Thread.sleep(3000);
	}
	
	//@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH2, "login");
	}
	
	
	
}
