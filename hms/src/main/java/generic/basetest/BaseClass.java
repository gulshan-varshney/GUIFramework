package generic.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import generic.IConstantPath.IconstantPath;
import generic.databaseutlity.DataBaseUtility;
import generic.fileutility.ExcelUtility;
import generic.fileutility.FileUtility;
import generic.webdriverutility.JavaUtility;
import generic.webdriverutility.UtilityClassObject;
import generic.webdriverutility.WebDriverUtility;
import objectRepositoryUtility.AdminLoginPage;
import objectRepositoryUtility.AdminPage;

public class BaseClass implements IconstantPath {
	/* Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws Throwable {
		System.out.println("===Connect to DB , Report Config===");
		dbLib.getDbconnection();
	}

	// @Parameters ("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Throwable {

		System.out.println("==Launch the BROWSER==");

		// String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		wLib.waitForPageToLoad(driver);
	}

//	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
//	public void configBM() throws Throwable {
//		System.out.println("=login=");
//		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
//		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
//		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
//		
//	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("=logout=");
		AdminPage ap = new AdminPage(driver);
		ap.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("==Close the BROWSER==");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws SQLException {
		System.out.println("===close Db , Report backUP====");
		dbLib.closeDbconnection();

	}

}
