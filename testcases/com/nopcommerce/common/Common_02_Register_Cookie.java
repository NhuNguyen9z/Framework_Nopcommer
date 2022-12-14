package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_02_Register_Cookie extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Jonhny";
		lastName = "Depp";
		emailAddress = "jonh" + getRandomEmail() + "@hotmail.com";
		password = "123456";

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-condition - Step 02: Enter to Fistname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// log.info("Pre-condition - Step 09: Click to Logout link");
		// homePage = registerPage.clickToLogoutLink();

		log.info("Pre-condition - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 10: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 11: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 12: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		loggedCookies = registerPage.getAllCookies(driver);

		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserLoginPageObject loginPage;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> loggedCookies;
	// Bi???n static thu???c Class qu???n l?? ko thu???c instance qu???n l?? - n??n Class m?? run xong th?? c??c bi???n instance t??? ?????ng h???y nh??ng bi???n static v???n c??n t???n t???i
	// Khi n??o m??y ???o java n?? ko ch???y n???a (all c??c class ?????u dc run xong) th?? c??c bi???n static m???i b??? h???y ??i

	// C??c action chuy???n trang th?? l??u ??:
	// - N??n t???o page class m???i khi 1 page c?? action/ element (vi???t h??m/ define c??c locator t????ng ???ng): PO + UI
	// - Follow theo business c???a app ch??? ko follow theo c??i UI c???a app, UI c?? nhi???u page html nh??ng business v???n l?? 1 page -> define th??nh 1 page class

}
