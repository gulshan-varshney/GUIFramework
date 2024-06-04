package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.fileutility.ExcelUtility;

public class AddDoctorSpecializationPage {

	WebDriver driver;
	public AddDoctorSpecializationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "doctorspecilization")
	private WebElement specilizationnEdt;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//p[@style='color:red;']")
	private WebElement confirmMsg;
	
	
	
	public void addDoctorSpecialization() throws Throwable {
		AdminPage ap = new AdminPage(driver);
		ap.getDoctorDD().click();
		ap.getDoctorSpecializationLink().click();
		ExcelUtility eLib = new ExcelUtility();
		String specialization = eLib.getDataFromExcel("specialization", 1, 0);
		specilizationnEdt.sendKeys(specialization);
		submitBtn.click();
		boolean status = confirmMsg.getText().equalsIgnoreCase("Doctor Specialization added successfully !!");
		Assert.assertEquals(status, true);
		Reporter.log(specialization+" added successfully", true);
	}
	
	
	
	
	
	
	
	
	
}
