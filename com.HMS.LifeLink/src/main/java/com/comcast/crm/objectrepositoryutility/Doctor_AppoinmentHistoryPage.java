package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Hithashree C S
 * 
 * Contains AppoinmentHistoryPage elements & business lib 
 *
 */  

public class Doctor_AppoinmentHistoryPage {

	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelbutton;
	
	@FindBy(xpath = "//p[@style='color:red;']")
private WebElement verifycancelmsg;	
	WebDriver driver;
	public Doctor_AppoinmentHistoryPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getCancelbutton() {
		return cancelbutton;
	}
	public WebElement getVerifycancelmsg() {
		return verifycancelmsg;
	}
	
	
	
}
