package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class Doctor_EditPatientPage {
	@FindBy(xpath = "//input[@name='patname']")
	private WebElement patname;

	@FindBy(name = "patcontact")
	private WebElement patcontact;

	@FindBy(id = "patemail")
	private WebElement patemail;

	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleradiobutton;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleradiobutton;

	@FindBy(name = "pataddress")
	private WebElement pataddress;

	@FindBy(name = "patage")
	private WebElement patage;

	@FindBy(name = "medhis")
	private WebElement medhistory;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement addbutton;

	WebDriver driver;

	public Doctor_EditPatientPage(WebDriver driver) {

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

	public void editaddPatient() throws Throwable {
		int randomNumber = jLib.getRandomNumber();
		String patName = eLib.getDataFromExcel("Doctor", 17, 0);
		String patContact = eLib.getDataFromExcel("Doctor", 17, 1);
		String patEmail = eLib.getDataFromExcel("Doctor", 17, 2) + randomNumber;
		String patAdress = eLib.getDataFromExcel("Doctor", 17, 4);
		String patAge = eLib.getDataFromExcel("Doctor", 17, 5);
		String patmedicalHistory = eLib.getDataFromExcel("Doctor", 17, 6);
		getPatname().clear();
		patname.sendKeys(patName);
		getPatcontact().clear();
		patcontact.sendKeys(patContact);
		getPataddress().clear();
		pataddress.sendKeys(patAdress);
		getPatage().clear();
		patage.sendKeys(patAge);
		getMedhistory().clear();
		medhistory.sendKeys(patmedicalHistory);
		addbutton.click();
	}

}
