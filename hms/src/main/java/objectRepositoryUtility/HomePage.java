package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author gulshan
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class HomePage extends WebDriverUtility {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement adminLoginBtn;

	@FindBy(xpath = "//a[@href='hms/doctor/']")
	private WebElement doctorLoginBtn;

	@FindBy(xpath = "//a[@href='hms/user-login.php']")
	private WebElement patientLoginBtn;

	public WebElement getAdminLoginBtn() {
		return adminLoginBtn;
	}

	public WebElement getDoctorLoginBtn() {
		return doctorLoginBtn;
	}

	public WebElement getPatientLoginBtn() {
		return patientLoginBtn;
	}

	public void adminLoginClick() {
		adminLoginBtn.click();
	}
	
	public void doctorLoginClick() {
		doctorLoginBtn.clear();
	}
	
	public void patientLoginClick() {
		patientLoginBtn.clear();
	}
	
}
