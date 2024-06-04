package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
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
 * Contains Doctor managepatient page elements & business lib 
 *
 */  
public class Doctor_ManagePatientsPage
{
@FindBy(xpath = "//td[@class='hidden-xs']/../../tr[2]/td[7]/a[1]")
private WebElement editicon;

@FindBy(xpath = "//a[@href='view-patient.php?viewid=6']")
private WebElement  eye;
//a[@href='view-patient.php?viewid=6']/ancestor::tr

@FindBy(xpath = "//button[@data-toggle='modal']")
private WebElement addmedicalhistory;

@FindBy(xpath = "//td[@class='hidden-xs']")
private WebElement verifyname;

WebDriver driver;

public Doctor_ManagePatientsPage(WebDriver driver) {

	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public WebElement getEditicon() {
	return editicon;
}

public WebElement getEye() {
	return eye;
}

public WebElement getAddmedicalhistory() {
	return addmedicalhistory;
}

public WebElement getVerifyname() {
	return verifyname;
}

public FileUtility fLib = new FileUtility();
public ExcelUtility eLib = new ExcelUtility();
public JavaUtility jLib = new JavaUtility();

public void viewicon() throws Throwable
{
	driver.findElement(By.xpath("//td[@class='hidden-xs']/../../tr[2]/td[7]/a[2]")).click();
	addmedicalhistory.click();
}
public void editButton() throws Throwable
{
	driver.findElement(By.xpath("//td[@class='hidden-xs']/../../tr[2]/td[7]/a[1]")).click();
}
}