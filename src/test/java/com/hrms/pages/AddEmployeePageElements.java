package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements {
	/*
     * Sprint 5
	US 16767: As an admin I should be able to add an employee 
	TC: Add Employee
	Step 1. navigate to the application
	Step 2: login into the application
	Step 3: navigate to add employee page
	Step 4: add employee by providing fname. mname, lname
	Step 5: verify employee has been added successfully
	     */
	
	@FindBy(id="firstName")
	public WebElement fName;
	
	@FindBy(id="middleName")
	public WebElement mName;
	
	@FindBy(id="lastName")
	public WebElement lName;
	
	@FindBy(id="chkLogin")
	public WebElement createLoginDetails;
	
	@FindBy(id="user_name")
	public WebElement username;
	
	@FindBy(id="user_password")
	public WebElement userPassword;
	
	@FindBy(id="re_password")
	public WebElement confirmUserPassword;
	

	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
    public WebElement personalDetail;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
