package com.quore.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quora.qa.util.TestUtil;
import com.quore.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//span[@class='message flex-grow-1')")
	WebElement errorMsg;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUserName(String userName) throws IOException {
		username.clear();
		username.sendKeys(userName);
		System.out.println();
		test.log(LogStatus.INFO, "UserName Entered Successfully:" + prop.getProperty("username"));
		test.log(LogStatus.INFO, test.addScreenCapture(TestUtil.takeScreenShot()));
	}

	public void enterPassword(String Password) {
		password.clear();
		password.sendKeys(Password);

		test.log(LogStatus.INFO, "Password Entered Successfully:");

	}

	public void clickLogin() {
		loginBtn.click();
		
		test.log(LogStatus.INFO, "Login button clicked Successfully:");
	}

	public String getErrorMessage(){
		return errorMsg.getText();
	}
}
