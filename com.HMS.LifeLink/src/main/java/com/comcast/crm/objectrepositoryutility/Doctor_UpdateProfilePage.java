package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Doctor_UpdateProfilePage  extends WebDriverUtility{

	@FindBy(xpath = "//textarea[@class='form-control']")
	private WebElement addAddress;
	
	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement fees;
	
	@FindBy(xpath = "//input[@name='doccontact']")
	private WebElement phoneNum;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//input[@name='docname']")
	private WebElement verifyname;
	
	WebDriver driver;
	public Doctor_UpdateProfilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddAddress() {
		return addAddress;
	}
	public WebElement getFees() {
		return fees;
	}
	public WebElement getPhoneNum() {
		return phoneNum;
	}
	
	public WebElement getSubmit() {
		return submit;
	}
	

	public WebElement getVerifyname() {
		return verifyname;
	}


	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();

	public void updateProfile() throws Throwable
	{
		String address=eLib.getDataFromExcel("Doctor", 14, 0);
		String feess=eLib.getDataFromExcel("Doctor", 14, 1);
		String phonenum=eLib.getDataFromExcel("Doctor", 14, 2);
		String patname=eLib.getDataFromExcel("Doctor", 14, 3);
		getAddAddress().clear();
		addAddress.sendKeys(address);
		getFees().clear();
		fees.sendKeys(feess);
		getPhoneNum().clear();
		phoneNum.sendKeys(phonenum);
		submit.click();
		alertpopup(driver);
		
//		
	}
}
