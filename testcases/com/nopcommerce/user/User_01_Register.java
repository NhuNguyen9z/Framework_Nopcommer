package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

@Listeners(commons.MethodListener.class)
public class User_01_Register extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAddess = "akp" + generateFakeNumber() + "@hotmail.com";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01 - Step 01: Click register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register_01 - Step 02: Click register button");
		registerPage.clickToRegisterButton();

		log.info("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02 - Step 01: Click register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123g@123");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_02 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		log.info("Register_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorWrongEmailMessage(), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
		log.info("Register_03 - Step 01: Click register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_03 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		log.info("Register_03 - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register_03 - Step 05: Click logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {
		log.info("Register_04 - Step 01: Click register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register_04 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_04 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		log.info("Register_04 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		log.info("Register_05 - Step 01: Click register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register_05 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		log.info("Register_05 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		log.info("Register_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		log.info("Register_06 - Step 01: Click register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register_06 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddess);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAddess);

		log.info("Register_06 - Step 03: Click register button");
		registerPage.clickToRegisterButton();

		log.info("Register_06 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String firstName, lastName, emailAddess, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
}
