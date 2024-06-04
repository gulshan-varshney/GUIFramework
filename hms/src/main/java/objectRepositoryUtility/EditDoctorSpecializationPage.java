package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.fileutility.ExcelUtility;
import generic.webdriverutility.WebDriverUtility;

public class EditDoctorSpecializationPage {

	WebDriver driver;
	public EditDoctorSpecializationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "doctorspecilization")
	private WebElement doctorSpecilizationEdt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//p[@style='color:red;']")
	private WebElement cnfMessage;
	
	public WebElement getDoctorSpecilizationEdt() {
		return doctorSpecilizationEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void editSpecialization() throws Throwable {
		
		ExcelUtility eLib = new ExcelUtility();
		String specialization = eLib.getDataFromExcel("specialization", 3, 0);
		driver.findElement(By.xpath("//td[text()='"+specialization+"']//following-sibling::td[3]//a[1]")).click();
		doctorSpecilizationEdt.clear();
		doctorSpecilizationEdt.sendKeys(eLib.getDataFromExcel("specialization", 2, 0));
		submitBtn.click();
		Assert.assertEquals(cnfMessage.getText(), "Doctor Specialization updated successfully !!");
		Reporter.log("Doctor Specialization updated successfully", true);
	}
	
	public void deleteSpecialization() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String specialization = eLib.getDataFromExcel("specialization", 2, 0);
		driver.findElement(By.xpath("//td[text()='"+specialization+"']//following-sibling::td[3]//a[2]")).click();
		wLib.switchtoAlertAndAccept(driver);
		boolean status = cnfMessage.getText().equalsIgnoreCase("data deleted !!");
		Assert.assertEquals(status, true);
		Reporter.log("data deleted successfully",true);
		
	}
}
