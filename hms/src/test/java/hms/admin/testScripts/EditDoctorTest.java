package hms.admin.testScripts;

import org.testng.annotations.Test;

import generic.basetest.BaseClass;
import objectRepositoryUtility.AddDoctorPage;
import objectRepositoryUtility.AdminLoginPage;
import objectRepositoryUtility.AdminPage;
import objectRepositoryUtility.EditDoctorPage;

/**
 * 
 * @author gulshan
 *
 */
public class EditDoctorTest extends BaseClass {

	/**
	 * test script for edit doctor's details
	 * 
	 * @throws Throwable
	 */
	@Test
	public void editDoctorDetails() throws Throwable {

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginToapp();
		AdminPage ap = new AdminPage(driver);
		ap.getDoctorDD().click();
		ap.getAddDoctorLink().click();
		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.addDoctor();

		EditDoctorPage edp = new EditDoctorPage(driver);
		edp.editDoctor();
		ap.logout();
	}
}
