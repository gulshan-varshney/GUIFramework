package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
/**
 * 
 * @author Hithashree C S
 * 
 * Contains AddPatientPage elements & business lib like  addPatientS()
 *
 */  
public class Doctor_AddPatientPage {
	@FindBy(xpath ="//input[@name='patname']")
	private WebElement patname;
	
	@FindBy(name = "patcontact")
	private WebElement patcontact;
	
	@FindBy(id = "patemail")
	private WebElement patemail;
	
	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleradiobutton;
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleradiobutton;
	
	@FindBy(name  = "pataddress")
	private WebElement pataddress;
	
	@FindBy(name = "patage")
	private WebElement patage;
	
	@FindBy(name = "medhis")
	private WebElement medhistory;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement addbutton;
	
	WebDriver driver;
	public Doctor_AddPatientPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatname() {
		return patname;
	}

	public WebElement getPatcontact() {
		return patcontact;
	}

	public WebElement getPatemail() {
		return patemail;
	}

	public WebElement getFemaleradiobutton() {
		return femaleradiobutton;
	}

	public WebElement getMaleradiobutton() {
		return maleradiobutton;
	}

	public WebElement getPataddress() {
		return pataddress;
	}

	public WebElement getPatage() {
		return patage;
	}

	public WebElement getMedhistory() {
		return medhistory;
	}

	public WebElement getAddbutton() {
		return addbutton;
	}
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();

	
	public void addPatient() throws Throwable
	{
		int randomNumber = jLib.getRandomNumber();
		String patName = eLib.getDataFromExcel("Doctor", 1, 0);
		String patContact = eLib.getDataFromExcel("Doctor", 1, 1);
		String patEmail = eLib.getDataFromExcel("Doctor", 1, 2) + randomNumber;
		// String gender = eLib.getDataFromExcel("Doctor", 1, 3);
		String patAdress = eLib.getDataFromExcel("Doctor", 1, 4);
		String patAge = eLib.getDataFromExcel("Doctor", 1, 5);
		String patmedicalHistory = eLib.getDataFromExcel("Doctor", 1, 6);
		patname.sendKeys(patName);
		patcontact.sendKeys(patContact);
		patemail.sendKeys(patEmail);
		femaleradiobutton.click();
		pataddress.sendKeys(patAdress);
		patage.sendKeys(patAge);
		medhistory.sendKeys(patmedicalHistory);
		addbutton.click();
	}
	
	

}
