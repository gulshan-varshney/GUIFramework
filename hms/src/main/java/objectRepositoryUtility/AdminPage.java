package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author gulsh
 *
 */
public class AdminPage {

	WebDriver driver;
/**
 * 
 * @param driver
 */
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement doctorDD;

	@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
	private WebElement doctorSpecializationLink;

	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement addDoctorLink;

	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement manageDoctorLink;

	@FindBy(xpath = "//span[text()=' Users ']")
	private WebElement usersDD;

	@FindBy(xpath = "//span[text()=' Manage Users ']")
	private WebElement manageUsersLink;

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientsDD;

	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement managePatientsLink;

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryLink;

	@FindBy(xpath = "//span[text()=' Doctor Session Logs ']")
	private WebElement doctorSessionLogs;

	@FindBy(xpath = "//span[text()=' User Session Logs ']")
	private WebElement userSessionLogs;

	@FindBy(xpath = "//span[text()=' Reports ']")
	private WebElement reportsDD;

	@FindBy(xpath = "//span[text()='B/w dates reports ']")
	private WebElement reportsDateLink;

	@FindBy(xpath = "//span[text()=' Patient Search ']")
	private WebElement patientSearchLink;
	
	@FindBy(className = "username")
	private WebElement profile;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutBtn;

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getDoctorDD() {
		return doctorDD;
	}

	public WebElement getDoctorSpecializationLink() {
		return doctorSpecializationLink;
	}

	public WebElement getAddDoctorLink() {
		return addDoctorLink;
	}

	public WebElement getManageDoctorLink() {
		return manageDoctorLink;
	}

	public WebElement getUsersDD() {
		return usersDD;
	}

	public WebElement getManageUsersLink() {
		return manageUsersLink;
	}

	public WebElement getPatientsDD() {
		return patientsDD;
	}

	public WebElement getManagePatientsLink() {
		return managePatientsLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getDoctorSessionLogs() {
		return doctorSessionLogs;
	}

	public WebElement getUserSessionLogs() {
		return userSessionLogs;
	}

	public WebElement getReportsDD() {
		return reportsDD;
	}

	public WebElement getReportsDateLink() {
		return reportsDateLink;
	}

	public WebElement getPatientSearchLink() {
		return patientSearchLink;
	}

	
	public void logout() {
		profile.click();
		logoutBtn.click();
	}
	
	public void users() {
		usersDD.click();
		manageUsersLink.click();
	}
	public void patientsDD() {
		patientsDD.click();
		managePatientsLink.click();
	}
	public void appointmentHistory() {
		appointmentHistoryLink.click();
	}
	public void doctorSession() {
		doctorSessionLogs.click();
	}
	public void userSession() {
		userSessionLogs.click();
	}
	public void reports() {
		reportsDD.click();
		reportsDateLink.click();
	}
	public void searchPatient() {
		patientSearchLink.click();
	}

	
}
