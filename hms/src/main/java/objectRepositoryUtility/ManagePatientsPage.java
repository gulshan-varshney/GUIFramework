package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientsPage {

	WebDriver driver;

	public ManagePatientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
