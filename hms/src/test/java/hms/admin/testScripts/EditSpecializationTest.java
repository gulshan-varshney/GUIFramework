package hms.admin.testScripts;

import org.testng.annotations.Test;

import generic.basetest.BaseClass;
import objectRepositoryUtility.AdminLoginPage;
import objectRepositoryUtility.AdminPage;
import objectRepositoryUtility.EditDoctorSpecializationPage;

public class EditSpecializationTest extends BaseClass {

	@Test
	public void editSpecialization() throws Throwable {

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginToapp();
		AdminPage ap = new AdminPage(driver);
		ap.getDoctorDD().click();
		ap.getDoctorSpecializationLink().click();
		EditDoctorSpecializationPage eds = new EditDoctorSpecializationPage(driver);
		eds.editSpecialization();
		ap.logout();
	}

}
