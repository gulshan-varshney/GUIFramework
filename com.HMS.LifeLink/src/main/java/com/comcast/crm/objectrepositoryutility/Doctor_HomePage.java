package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Hithashree C S
 * 
 *         Contains Doctor home page elements & business lib
 *
 */
public class Doctor_HomePage {

	@FindBy(xpath = "//span[text()=' Dashboard ']")
	private WebElement dashboardlink;

//	@FindBy(xpath = "//p[@class=\"links cl-effect-1\"]")
//	private WebElement updateprofilelink;

	@FindBy(xpath = "//a[@href='appointment-history.php']")
	private WebElement appoinmentHistory;

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientslink;

	@FindBy(xpath = "//span[text()=' Search ']")
	private WebElement searchlink;

	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement addpatientlnk;

	@FindBy(xpath = "//a[@href='manage-patient.php']")
	private WebElement patientmanagelnk;

	@FindBy(xpath = "//span[@class='username']")
	private WebElement dropdownuserlink;

	@FindBy(xpath = "//a[@href='edit-profile.php']")
	private WebElement myprofilelnk;

	@FindBy(xpath = "//a[@href=\"change-password.php\"]")
	private WebElement changepassword;

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logout;

	WebDriver driver;

	public Doctor_HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardlink() {
		return dashboardlink;
	}

	public WebElement getAppoinmentHistory() {
		return appoinmentHistory;
	}

	public WebElement getPatientslink() {
		return patientslink;
	}

	public WebElement getSearchlink() {
		return searchlink;
	}

	public WebElement getAddpatientlnk() {
		return addpatientlnk;
	}

	public WebElement getPatientmanagelnk() {
		return patientmanagelnk;
	}

	public WebElement getDropdownuserlink() {
		return dropdownuserlink;
	}

	public WebElement getMyprofilelnk() {
		return myprofilelnk;
	}

	public WebElement getChangepassword() {
		return changepassword;
	}

	public WebElement getLogout() {
		return logout;
	}

	public void logout() {
		dropdownuserlink.click();
		logout.click();
	}

	public void addPatientButton() {
		patientslink.click();
		addpatientlnk.click();
	}

	public void managepatient() {
		patientslink.click();
		patientmanagelnk.click();
	}
	public void clickonchangeps()
	{
		dropdownuserlink.click();
		changepassword.click();
	}
}
