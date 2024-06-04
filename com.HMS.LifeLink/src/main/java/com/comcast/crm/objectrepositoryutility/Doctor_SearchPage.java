package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
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
 * Contains Doctor search page elements & business lib like  searchpatient()
 *
 */  
public class Doctor_SearchPage {

	@FindBy(name = "searchdata")
	private WebElement searchname;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchbutton;
	

	WebDriver driver;
	public Doctor_SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchname() {
		return searchname;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility WLib = new WebDriverUtility();
	
	public void searchPatient() throws Throwable
	{
		String name=eLib.getDataFromExcel("Doctor", 11, 0);
		searchname.sendKeys(name);
		searchbutton.click();
		
	}
	
	public void clickoneyeicon() throws Throwable
	{
		String patName = eLib.getDataFromExcel("Doctor", 1, 0);
		WebElement eye=driver.findElement(By.xpath("//td[text()='"+patName+"']/../../tr[2]/td[7]/a[2]"));
		eye.click();
	}
}
