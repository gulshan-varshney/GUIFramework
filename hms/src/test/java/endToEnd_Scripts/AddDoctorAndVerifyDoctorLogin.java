package endToEnd_Scripts;

import org.testng.annotations.Test;

import generic.basetest.BaseClass;
import objectRepositoryUtility.AddDoctorPage;
import objectRepositoryUtility.AdminLoginPage;
import objectRepositoryUtility.AdminPage;
import objectRepositoryUtility.DoctorLoginPage;

public class AddDoctorAndVerifyDoctorLogin extends BaseClass {

	@Test
	public void verifyDoctorLogin() throws Throwable {

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginToapp();

		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.addDoctor();
		
		AdminPage ap = new AdminPage(driver);
		ap.logout();
		
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.doctorLogin();
	}

}
