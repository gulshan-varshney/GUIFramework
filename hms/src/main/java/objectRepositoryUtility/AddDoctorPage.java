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

public class AddDoctorPage {

	WebDriver driver;
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
	
	
	public void addDoctor() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		AdminPage ap = new AdminPage(driver);
		ap.getDoctorDD().click();
		ap.getAddDoctorLink().click();
		String speciazation = eLib.getDataFromExcel("specialization", 1, 0);
		
		wLib.select(selectSpecialization, speciazation);
		String docName = eLib.getDataFromExcel("addDoctor", 1, 0);
		docNameEdt.sendKeys(docName);
		addressEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 1));
		feeEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 2));
		docContactEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 3));
		String email = eLib.getDataFromExcel("addDoctor", 1, 4)+jLib.getRandomNumber();
		docEmailEdt.sendKeys(email);
		passwordEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 5));
		cfpasswordEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 6));
		submitBtn.click();
		
		wLib.switchtoAlertAndAccept(driver);
		
		String actName = driver.findElement(By.xpath("//td[text()='"+speciazation+"']//following-sibling::td[1]")).getText();
		Assert.assertEquals(docName, actName);
		Reporter.log(docName+" is successfully added",true);
	}
	
	
	
}
