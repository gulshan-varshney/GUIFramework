package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_DashboardPage {
@FindBy(xpath ="//div[@class='panel-body']/descendant::a[@href='edit-profile.php']")
private WebElement  updateprofilelink;

WebDriver driver;
public Doctor_DashboardPage(WebDriver driver) {

	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public WebElement getUpdateprofilelink() {
	return updateprofilelink;
}

}
