package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.fileutility.ExcelUtility;

/**
 * this pom class contains web elements of edit doctor details page
 * 
 * @author gulshan
 *
 */
public class EditDoctorPage {

	WebDriver driver;

	public EditDoctorPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement specDD;

	@FindBy(name = "docname")
	private WebElement dNameEdt;

	@FindBy(name = "clinicaddress")
	private WebElement addressEdtt;

	@FindBy(name = "docfees")
	private WebElement feesEdt;

	@FindBy(name = "doccontact")
	private WebElement contactEdt;

	@FindBy(name = "docemail")
	private WebElement emailIdEdt;

	@FindBy(name = "submit")
	private WebElement submitBtnn;

	@FindBy(xpath = "//h5[@style='color: green; font-size:18px; ']")
	private WebElement headerMsg;

	public WebElement getSpecDD() {
		return specDD;
	}

	public WebElement getdNameEdt() {
		return dNameEdt;
	}

	public WebElement getAddressEdtt() {
		return addressEdtt;
	}

	public WebElement getFeesEdt() {
		return feesEdt;
	}

	public WebElement getContactEdt() {
		return contactEdt;
	}

	public WebElement getEmailIdEdt() {
		return emailIdEdt;
	}

	public WebElement getSubmitBtnn() {
		return submitBtnn;
	}

	/**
	 * this method is handling the doctor details modification
	 * 
	 * @throws Throwable
	 */
	public void editDoctor() throws Throwable {

		ExcelUtility eLib = new ExcelUtility();
		String docNmae = eLib.getDataFromExcel("addDoctor", 1, 0);
		driver.findElement(By.xpath("//td[text()='" + docNmae + "']//following-sibling::td[2]//a[@tooltip='Edit']"))
				.click();
		contactEdt.clear();
		contactEdt.sendKeys("(555)987-789");
		submitBtnn.click();

		boolean status = headerMsg.getText().contains("Details updated Successfully");
		Assert.assertEquals(status, true);
		Reporter.log("Details updated Successfully", true);
	}

}
