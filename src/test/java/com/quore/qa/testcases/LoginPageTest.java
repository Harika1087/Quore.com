package com.quore.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quore.qa.base.TestBase;
import com.quore.qa.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
	}

	

	@Test(priority = 1)
	public void invalidUserName() throws IOException {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory("Login");

		test.log(LogStatus.INFO, "Enter Username");
		loginPage.enterUserName("dummyUsername");

		loginPage.clickLogin();

		String actualMsg = loginPage.getErrorMessage();
		String expMsg = "Your username is invalid! ×";

		if (expMsg.contentEquals(actualMsg)) {
			test.log(LogStatus.PASS, "User is not logged in and error message displayed correcly");
		} else {
			test.log(LogStatus.FAIL, "User is not logged in and error message displayed wrong");
			test.log(LogStatus.INFO, "Expected Error Message" + expMsg);
			test.log(LogStatus.INFO, "Actual Error Message" + actualMsg);
		}

	}

	@Test(priority = 2)
	public void invalidPassword() throws IOException {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory("Login");

		test.log(LogStatus.INFO, "Enter Username");
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword("dummyPassword");
		loginPage.clickLogin();

		String actualMsg = loginPage.getErrorMessage();

		String expMsg = "Your password is invalid! ×";

		if (expMsg.contentEquals(actualMsg)) {
			test.log(LogStatus.PASS, "User is not logged in and error message displayed correcly");
		} else {
			test.log(LogStatus.FAIL, "User is not logged in and error message displayed wrong");
			test.log(LogStatus.INFO, "Expected Error Message" + expMsg);
			test.log(LogStatus.INFO, "Actual Error Message" + actualMsg);

		}

	}

	@Test(priority = 3)
	public void invalidLogin() throws IOException {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory("Login");

		test.log(LogStatus.INFO, "Enter Username");
		loginPage.enterUserName("dummyUsername");
		loginPage.enterPassword("dummypassword");
		loginPage.clickLogin();

		String actualMsg = loginPage.getErrorMessage();
		String expMsg = "Your username is invalid! ";

		if (expMsg.contentEquals(actualMsg)) {
			test.log(LogStatus.PASS, "User is not logged in and error message displayed correcly");
		} else {
			test.log(LogStatus.FAIL, "User is not logged in and error message displayed wrong");
			test.log(LogStatus.INFO, "Expected Error Message" + expMsg);
			test.log(LogStatus.INFO, "Actual Error Message" + actualMsg);
		}

	}
	
	@Test(priority = 4)
	public void validLogin() throws IOException {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()).assignCategory("Login");

		test.log(LogStatus.INFO, "Enter Username");
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLogin();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
