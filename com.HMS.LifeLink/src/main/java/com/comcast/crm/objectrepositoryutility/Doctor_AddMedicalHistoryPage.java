package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * 
 * @author Hithashree C S
 * 
 * Contains AddMedicalHistoryPage elements & business lib like addmedicalhistory()
 *
 */  

public class Doctor_AddMedicalHistoryPage {

	@FindBy(name  = "bp")
	private WebElement bp;
	
	@FindBy(name = "bs")
	private WebElement bloodsugar;
	
	@FindBy(name = "weight")
	private WebElement weight;
	
	@FindBy(name = "temp")
	private WebElement bodytemp;
	
	@FindBy(name = "pres")
	private WebElement Prescription;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitbutton;
	
	WebDriver driver;
	public Doctor_AddMedicalHistoryPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getBp() {
		return bp;
	}
	public WebElement getBloodsugar() {
		return bloodsugar;
	}
	public WebElement getWeight() {
		return weight;
	}
	public WebElement getBodytemp() {
		return bodytemp;
	}
	public WebElement getPrescription() {
		return Prescription;
	}
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility WLib = new WebDriverUtility();
	
	public void addmedicalhistory() throws Throwable
	{
		String patbp = eLib.getDataFromExcel("Doctor", 7, 0);
		String patbllodSugar = eLib.getDataFromExcel("Doctor", 7, 1);
		String patweight = eLib.getDataFromExcel("Doctor", 7, 2);
		String patbodyTemp = eLib.getDataFromExcel("Doctor", 7, 3);
		String patprescription = eLib.getDataFromExcel("Doctor", 7, 4);
		bp.sendKeys(patbp);
		bloodsugar.sendKeys(patbllodSugar);
		weight.sendKeys(patweight);
		bodytemp.sendKeys(patbodyTemp);
		Prescription.sendKeys(patprescription);
		submitbutton.click();
		WLib.alertpopup(driver);
	}
	
	
}
