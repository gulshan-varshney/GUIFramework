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
 *         Contains Doctor login page elements & business lib like login()
 *
 */
public class Doctor_LoginPage extends WebDriverUtility {

	@FindBy(xpath = "//a[@href='hms/doctor/']")
	private WebElement doctorclickherelink;

	@FindBy(name = "username")
	private WebElement doctorusername;
	@FindBy(name = "password")
	private WebElement doctorpassword;

	@FindBy(xpath = "//a[@href='forgot-password.php']")
	private WebElement forgotpassword;

	@FindBy(name = "submit")
	private WebElement submitbutton;

	WebDriver driver;

	public Doctor_LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorclickherelink() {
		return doctorclickherelink;
	}

	public WebElement getDoctorusername() {
		return doctorusername;
	}

	public WebElement getDoctorpassword() {
		return doctorpassword;
	}

	public WebElement getForgotpassword() {
		return forgotpassword;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();

	public void login() throws Throwable {
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		driver.get(URL);
		waitForPageToLoad(driver);
		maximize(driver);
		getDoctorclickherelink().click();
		doctorusername.sendKeys(USERNAME);
		doctorpassword.sendKeys(PASSWORD);
		submitbutton.click();
	}

}
