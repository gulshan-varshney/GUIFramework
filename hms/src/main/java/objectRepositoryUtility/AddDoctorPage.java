package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.fileutility.ExcelUtility;
import generic.webdriverutility.JavaUtility;
import generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author gulshan
 * 
 *         this page contains webElements of add doctor page
 */
public class AddDoctorPage {

	WebDriver driver;

	/**
	 * constructor for handling staleElementreferenceException
	 * 
	 * @param driver
	 */
	public AddDoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement selectSpecialization;

	@FindBy(name = "docname")
	private WebElement docNameEdt;

	@FindBy(name = "clinicaddress")
	private WebElement addressEdt;

	@FindBy(name = "docfees")
	private WebElement feeEdt;

	@FindBy(name = "doccontact")
	private WebElement docContactEdt;

	@FindBy(name = "docemail")
	private WebElement docEmailEdt;

	@FindBy(name = "npass")
	private WebElement passwordEdt;

	@FindBy(name = "cfpass")
	private WebElement cfpasswordEdt;

	@FindBy(id = "submit")
	private WebElement submitBtn;

	/**
	 * this method handle the add doctor operation
	 * 
	 * @throws Throwable
	 */
	
	String docEmail;
	public void addDoctor() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber();

		String speciazation = eLib.getDataFromExcel("specialization", 1, 0);

		AdminPage ap = new AdminPage(driver);
		ap.getDoctorDD().click();
		ap.getDoctorSpecializationLink().click();
		AddDoctorSpecializationPage adp = new AddDoctorSpecializationPage(driver);
		adp.getSpecilizationnEdt().sendKeys(speciazation);
		adp.getSubmitBtn().click();

		ap.getDoctorDD().click();
		ap.getAddDoctorLink().click();

		wLib.select(selectSpecialization, speciazation);
		String docName = eLib.getDataFromExcel("addDoctor", 1, 0);
		docNameEdt.sendKeys(docName);
		addressEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 1));
		feeEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 2));
		docContactEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 3));
		docEmail = eLib.getDataFromExcel("addDoctor", 1, 4) + randomNum + "@lifelinkhospital.com";
		docEmailEdt.sendKeys(docEmail);
		passwordEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 5));
		cfpasswordEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 6));
		submitBtn.click();
		Thread.sleep(1000);
		wLib.switchtoAlertAndAccept(driver);

		String actName = driver.findElement(By.xpath("//td[text()='" + docName + "']")).getText();
		Assert.assertEquals(docName, actName);
		Reporter.log(docName + " is successfully added", true);
		System.out.println(docEmail);
	}

}
