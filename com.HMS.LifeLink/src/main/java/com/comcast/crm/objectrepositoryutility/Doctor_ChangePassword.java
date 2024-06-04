package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class Doctor_ChangePassword {

	@FindBy(xpath = "//input[@name='cpass']")
	private WebElement currentpassword;
	
	@FindBy(xpath = "//input[@name='npass']")
	private WebElement newpassword;
	 
	@FindBy(xpath = "//input[@name='cfpass']")
	private WebElement confirmpassword;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submit;
	
	WebDriver driver;
	public Doctor_ChangePassword(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getCurrentpassword() {
		return currentpassword;
	}
	public WebElement getNewpassword() {
		return newpassword;
	}
	public WebElement getConfirmpassword() {
		return confirmpassword;
	}
	public WebElement getSubmit() {
		return submit;
	}

	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();

public void changePassword() throws Throwable
{
	String currentps=eLib.getDataFromExcel("password", 1, 0);
	String newps=eLib.getDataFromExcel("password", 1, 1);
	String confirmps=eLib.getDataFromExcel("password", 1, 2);
	currentpassword.sendKeys(currentps);
	newpassword.sendKeys(newps);
	confirmpassword.sendKeys(confirmps);
	submit.click();
}
}
