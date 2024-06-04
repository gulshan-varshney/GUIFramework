package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.fileutility.FileUtility;
import generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Gulshan
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class AdminLoginPage extends WebDriverUtility { // Rule-1 create a separte java class

	WebDriver driver;

	public AdminLoginPage(WebDriver driver) { // Rule 3 : Object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username") // Rule-2 Object Creation
	private WebElement usernameEdt;

	@FindBy(name = "password")
	private WebElement passwordEdt;

	@FindBy(name = "submit")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() { // Rule-4 : Object Encapsulation
		return usernameEdt; // Rule-5 : Object Utilization
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * login to application based username , password , url argumnets
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws Throwable 
	 */
	public void loginToapp() throws Throwable {
		waitForPageToLoad(driver);
		FileUtility fLib = new FileUtility();
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
		driver.get(URL);
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
		hp.adminLoginClick();
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
