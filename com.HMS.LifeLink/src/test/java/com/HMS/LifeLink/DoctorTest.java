package com.HMS.LifeLink;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Doctor_AddMedicalHistoryPage;
import com.comcast.crm.objectrepositoryutility.Doctor_AddPatientPage;
import com.comcast.crm.objectrepositoryutility.Doctor_AppoinmentHistoryPage;
import com.comcast.crm.objectrepositoryutility.Doctor_ChangePassword;
import com.comcast.crm.objectrepositoryutility.Doctor_DashboardPage;
import com.comcast.crm.objectrepositoryutility.Doctor_EditPatientPage;
import com.comcast.crm.objectrepositoryutility.Doctor_HomePage;
import com.comcast.crm.objectrepositoryutility.Doctor_LoginPage;
import com.comcast.crm.objectrepositoryutility.Doctor_ManagePatientsPage;
import com.comcast.crm.objectrepositoryutility.Doctor_SearchPage;
import com.comcast.crm.objectrepositoryutility.Doctor_UpdateProfilePage;

public class DoctorTest extends BaseClass {

	public WebDriverUtility Wlib = new WebDriverUtility();

	@Test
	public void Doctor__appointmentHistoryTest() throws Throwable {

		// verify user able see the appointment history
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
//		dhp.getAppoinmentHistory().click();
		dhp.logout();

	}

	@Test
	public void Doctor_Cancel_appointmentHistoryTest() throws Throwable {
		// verify user able to Cancel the appointment history
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.getAppoinmentHistory().click();
		Doctor_AppoinmentHistoryPage dahp = new Doctor_AppoinmentHistoryPage(driver);
		// dahp.getCancelbutton();
		driver.findElement(By.xpath("//td[@class='hidden-xs']/../../tr/td[8]/div/a")).click();
		Wlib.alertpopup(driver);
		Doctor_AppoinmentHistoryPage ahp = new Doctor_AppoinmentHistoryPage(driver);
		String msg = ahp.getVerifycancelmsg().getText();
		Assert.assertNotNull(msg);
		dhp.logout();

	}

	@Test
	public void Doctor_addPatientTest() throws Throwable {

		// verify user is able to add the patients
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.addPatientButton();
		Doctor_AddPatientPage addpatpage = new Doctor_AddPatientPage(driver);
		addpatpage.addPatient();
		dhp.getPatientslink().click();
		dhp.getPatientmanagelnk().click();
		dhp.logout();
	}

	@Test
	public void Doctor_editpatientDetailes() throws Throwable {
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.managepatient();
		Doctor_ManagePatientsPage mph = new Doctor_ManagePatientsPage(driver);
		mph.editButton();
		Doctor_EditPatientPage epp = new Doctor_EditPatientPage(driver);
		epp.editaddPatient();
		dhp.logout();
	}

	@Test
	public void Doctor_AddMedicalHistoryTest() throws Throwable {
		// verify user is able to add the medical history
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.addPatientButton();
		dhp.managepatient();
		Doctor_ManagePatientsPage mph = new Doctor_ManagePatientsPage(driver);
		mph.viewicon();
		Doctor_AddMedicalHistoryPage amhp = new Doctor_AddMedicalHistoryPage(driver);
		amhp.addmedicalhistory();
		dhp.logout();

	}

	@Test
	public void Doctor_searchpatientTest() throws Throwable {

		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.getSearchlink().click();
		Doctor_SearchPage dsp = new Doctor_SearchPage(driver);
		dsp.searchPatient();
		dhp.logout();
	}

	@Test
	public void Doctor_updateProfileTest() throws Throwable {
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.getDashboardlink().click();
		Doctor_DashboardPage dp = new Doctor_DashboardPage(driver);
		dp.getUpdateprofilelink().click();
		Doctor_UpdateProfilePage upp = new Doctor_UpdateProfilePage(driver);
		upp.updateProfile();
		dhp.logout();

	}

	@Test
	public void addPatientAndSearchPatientTest() throws Throwable {
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.addPatientButton();
		Doctor_AddPatientPage addpatpage = new Doctor_AddPatientPage(driver);
		addpatpage.addPatient();
		dhp.managepatient();
		Doctor_ManagePatientsPage mph = new Doctor_ManagePatientsPage(driver);
		mph.viewicon();
		Doctor_AddMedicalHistoryPage amhp = new Doctor_AddMedicalHistoryPage(driver);
		amhp.addmedicalhistory();
		dhp.getSearchlink().click();
		Doctor_SearchPage dsp = new Doctor_SearchPage(driver);
		dsp.searchPatient();
		dhp.logout();
	}

	@Test
	public void change_PasswordTest() throws Throwable {
		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.clickonchangeps();
		Doctor_ChangePassword cp = new Doctor_ChangePassword(driver);
		cp.changePassword();
		dhp.logout();
	}

	@Test
	public void SearchPatientAndAddMedicalHistory() throws Throwable {

		Doctor_LoginPage dlp = new Doctor_LoginPage(driver);
		dlp.login();
		Doctor_HomePage dhp = new Doctor_HomePage(driver);
		dhp.getSearchlink().click();
		Doctor_SearchPage dsp = new Doctor_SearchPage(driver);
		dsp.searchPatient();
		dsp.clickoneyeicon();
		Doctor_ManagePatientsPage mpp = new Doctor_ManagePatientsPage(driver);
		mpp.getAddmedicalhistory().click();
		Doctor_AddMedicalHistoryPage amh = new Doctor_AddMedicalHistoryPage(driver);
		amh.addmedicalhistory();
		dhp.logout();
	}

}
