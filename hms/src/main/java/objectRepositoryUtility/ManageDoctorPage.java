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

public class ManageDoctorPage {

	WebDriver driver;
	public ManageDoctorPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@style='color:red;']")
	private WebElement message;
	
	public void deleteDoc() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		String speciazation = eLib.getDataFromExcel("specialization", 1, 0);
	    String time = driver.findElement(By.xpath("//td[text()='"+speciazation+"']/following-sibling::td[2]")).getText();
		driver.findElement(By.xpath("//td[contains(text(),'"+time+"')]/following-sibling::td//a[2]")).click();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.switchtoAlertAndAccept(driver);
		
		boolean status = message.getText().equalsIgnoreCase("data deleted !!");
		Assert.assertEquals(status, true);
		Reporter.log("data deleted successfully",true);
		
	}
	
	
}
