package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.fileutility.ExcelUtility;

public class DoctorLoginPage {

	WebDriver driver;
	public DoctorLoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement docUsernameEdt;

	@FindBy(name = "password")
	private WebElement docPasswordEdt;

	@FindBy(name = "submit")
	private WebElement docLoginBtn;
	
	public WebElement getDocUsernameEdt() {
		return docUsernameEdt;
	}

	public WebElement getDocPasswordEdt() {
		return docPasswordEdt;
	}

	public WebElement getDocLoginBtn() {
		return docLoginBtn;
	}
	
	public void doctorLogin() throws Throwable {
		ExcelUtility eLib= new ExcelUtility();
		
		HomePage hp = new HomePage(driver);
		hp.getDoctorLoginBtn().click();
		
		AddDoctorPage adp = new AddDoctorPage(driver);
		docUsernameEdt.sendKeys(adp.docEmail);
		docPasswordEdt.sendKeys(eLib.getDataFromExcel("addDoctor", 1, 5));
		docLoginBtn.click();
		
	}
	
	
}
