package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class HrmsLoginProperties extends CommonMethods{
	Properties prop;
	
	@Test
	public void loginReadProperties() {
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Configs/loginConfig";
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String usname=prop.getProperty("userName");
		String pwd=prop.getProperty("password");
		
		LoginPageElements log=new LoginPageElements();
		log.login(usname, pwd);
		
		DashboardPageElements dash=new DashboardPageElements();	
		Assert.assertEquals(dash.welcome.getText(), "Welcome Admin", "failed");
	
		CommonMethods.takeScreenshot("loginRead");
		
	}

}
