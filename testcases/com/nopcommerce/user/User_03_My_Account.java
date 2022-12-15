package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductCategoryPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserProductListPageObject;
import pageObjects.nopCommerce.user.UserProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class User_03_My_Account extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {

		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + getRandomEmail() + "@hotmail.com";
		oldPassword = "123456";
		newPassword = "654321";
		day = "10";
		month = "May";
		year = "1999";
		companyName = "Automation TC";

		firstName_Address = "Automation_Address";
		lastName_Address = "Testing_Address";
		emailAddress_Address = "update" + getRandomEmail() + "@hotmail.com";
		companyName_Address = "Automation Address";
		country = "Viet Nam";
		state = "Other";
		city = "Dan Nang";
		address_1 = "123/04 Le Lai";
		address_2 = "234/05 Hai Phong";
		zipCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "9876543210";

		productReviewTitle = "Review Title";
		productReviewText = "Review text";
		productName = "Build your own computer";

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-condition - Step 02: Enter to Fistname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 05: Enter to Password textbox with value is '" + oldPassword + "'");
		registerPage.inputToPasswordTextbox(oldPassword);

		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is '" + oldPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(oldPassword);

		log.info("Pre-condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Pre-condition - Step 10: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 11: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 12: Enter to Password textbox with value is '" + oldPassword + "'");
		loginPage.inputToPasswordTextbox(oldPassword);

		log.info("Pre-condition - Step 13: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-condition - Step 14: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void My_Account_01_Customer_Infor() {
		log.info("Customer-Infor - Step 01: Navigate to 'Customer Info' page ");
		customerInfoPage = homePage.openCustomerInforPage();

		log.info("Customer-Infor - Step 02: Verify 'Customer Info' page is displayed");
		verifyTrue(customerInfoPage.isSideBarPageDisplayed(driver, "My account - Customer info"));

		log.info("Customer-Infor - Step 03: Select Radio is Female");
		customerInfoPage.clickToRadioByText(driver, "Female");

		log.info("Customer-Infor - Step 04: Enter to Fistname textbox with value is '" + firstName + "'");
		customerInfoPage.inputToTextboxById(driver, "FirstName", firstName);

		log.info("Customer-Infor - Step 05: Enter to LastName textbox with value is '" + lastName + "'");
		customerInfoPage.inputToTextboxById(driver, "LastName", lastName);

		log.info("Customer-Infor - Step 06: Select day with value is '" + day + "'");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Customer-Infor - Step 07: Select month with value is '" + month + "'");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Customer-Infor - Step 08: Select year with value is '" + year + "'");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Customer-Infor - Step 09: Enter to Email textbox with value is '" + emailAddress + "'");
		customerInfoPage.inputToTextboxById(driver, "Email", emailAddress);

		log.info("Customer-Infor - Step 10: Select Newslatter textbox");
		customerInfoPage.clickToCheckboxByText(driver, "Newsletter");

		log.info("Customer-Infor - Step 11: Enter to Company textbox with value is '" + companyName + "'");
		customerInfoPage.inputToTextboxById(driver, "Company", companyName);
		customerInfoPage.sleepInSecond(1);

		log.info("Customer-Infor - Step 12: Click to button Save");
		customerInfoPage.clickToButtonByText(driver, "Save");

		log.info("Customer-Infor - Step 13: Verify 'Radio' value is displayed");
		Assert.assertTrue(customerInfoPage.isRadioByTextDisplayedByText(driver, "Female"));

		log.info("Customer-Infor - Step 14: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("Customer-Infor - Step 15: Verify 'Last Name' is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("Customer-Infor - Step 16: Verify 'Day' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthDay", day), day);

		log.info("Customer-Infor - Step 17: Verify 'Month' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthMonth", month), month);

		log.info("Customer-Infor - Step 18: Verify 'Year' value is correctly");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "DateOfBirthYear", year), year);

		log.info("Customer-Infor - Step 19: Verify 'Email' value is correctly with value is '" + emailAddress + "'");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("Customer-Infor - Step 20: Verify 'Checkbox' Newsletter is displayed");
		Assert.assertTrue(customerInfoPage.isCheckboxByTextDisplayedByText(driver, "Newsletter"));

		log.info("Customer-Infor - Step 21: Verify 'Company Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company"), companyName);

	}

	@Test
	public void My_Account_02_Addresses() {
		log.info("Addresses - Step 01: Navigate to 'Addresses' page ");
		addressPage = customerInfoPage.openAddressPage(driver);

		log.info("Addresses - Step 02: Click to button Add new ");
		addressPage.clickToButtonByText(driver, "Add new");

		log.info("Addresses - Step 03: Enter to Fistname textbox with value is '" + firstName_Address + "'");
		addressPage.inputToTextboxById(driver, "Address_FirstName", firstName_Address);

		log.info("Addresses - Step 04: Enter to LastName textbox with value is '" + lastName_Address + "'");
		addressPage.inputToTextboxById(driver, "Address_LastName", lastName_Address);

		log.info("Addresses - Step 05: Enter to Email textbox with value is '" + emailAddress_Address + "'");
		addressPage.inputToTextboxById(driver, "Address_Email", emailAddress_Address);

		log.info("Addresses - Step 06: Enter to Company textbox with value is '" + companyName_Address + "'");
		addressPage.inputToTextboxById(driver, "Address_Company", companyName_Address);

		log.info("Addresses - Step 07: Select Country");
		addressPage.selectToDropdownByName(driver, "Address.CountryId", country);

		log.info("Addresses - Step 08: Select State");
		addressPage.selectToDropdownByName(driver, "Address.StateProvinceId", state);

		log.info("Addresses - Step 09: Enter to City textbox with value is '" + city + "'");
		addressPage.inputToTextboxById(driver, "Address_City", city);

		log.info("Addresses - Step 10: Enter to Address 1 textbox with value is '" + address_1 + "'");
		addressPage.inputToTextboxById(driver, "Address_Address1", address_1);

		log.info("Addresses - Step 11: Enter to Address 2 textbox with value is '" + address_2 + "'");
		addressPage.inputToTextboxById(driver, "Address_Address2", address_2);

		log.info("Addresses - Step 12: Enter to Zipcode textbox with value is '" + zipCode + "'");
		addressPage.inputToTextboxById(driver, "Address_ZipPostalCode", zipCode);

		log.info("Addresses - Step 13: Enter to Phone Number textbox with value is '" + phoneNumber + "'");
		addressPage.inputToTextboxById(driver, "Address_PhoneNumber", phoneNumber);

		log.info("Addresses - Step 14: Enter to Fax Number textbox with value is '" + faxNumber + "'");
		addressPage.inputToTextboxById(driver, "Address_FaxNumber", faxNumber);

		log.info("Addresses - Step 15: Verify Address_FirstName with value is '" + firstName_Address + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_FirstName"), firstName_Address);

		log.info("Addresses - Step 16: Verify Address_LastName with value is '" + lastName_Address + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_LastName"), lastName_Address);

		log.info("Addresses - Step 17: Verify Address_Email with value is '" + emailAddress_Address + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_Email"), emailAddress_Address);

		log.info("Addresses - Step 18: Verify Address_Company with value is '" + companyName_Address + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_Company"), companyName_Address);

		log.info("Addresses - Step 19: Verify Country with value is '" + country + "'");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "Address.CountryId", country), country);

		log.info("Addresses- Step 20: Verify State with value is '" + state + "'");
		Assert.assertEquals(customerInfoPage.getDropdownValueByID(driver, "Address.StateProvinceId", state), state);

		log.info("Addresses - Step 21: Verify City with value is '" + city + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_City"), city);

		log.info("Addresses - Step 22: Verify Address_1 with value is '" + address_1 + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_Address1"), address_1);

		log.info("Addresses - Step 23: Verify address_2 with value is '" + address_2 + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_Address2"), address_2);

		log.info("Addresses - Step 24: Verify ZipCode with value is '" + zipCode + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_ZipPostalCode"), zipCode);

		log.info("Addresses - Step 25: Verify phoneNumber with value is '" + phoneNumber + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_PhoneNumber"), phoneNumber);

		log.info("Addresses - Step 26: Verify faxNumber with value is '" + faxNumber + "'");
		Assert.assertEquals(addressPage.getTextboxValueByID(driver, "Address_FaxNumber"), faxNumber);

	}

	@Test
	public void My_Account_03_Change_Password() {
		log.info("Change_Password - Step 01: open Change Password Page");
		changePasswordPage = addressPage.openChangePasswordPage(driver, "Change password");

		log.info("Change_Password - Step 02: Enter to OldPassword textbox with value is '" + oldPassword + "'");
		changePasswordPage.inputToTextboxById(driver, "OldPassword", oldPassword);

		log.info("Change_Password - Step 03: Enter to NewPassword textbox with value is '" + newPassword + "'");
		changePasswordPage.inputToTextboxById(driver, "NewPassword", newPassword);

		log.info("Change_Password - Step 04: Enter to ConfirmNewPassword textbox with value is '" + newPassword + "'");
		changePasswordPage.inputToTextboxById(driver, "ConfirmNewPassword", newPassword);

		log.info("Change_Password - Step 05: Click button Change Password");
		changePasswordPage.clickToButtonByText(driver, "Change password");

		log.info("Change_Password - Step 06: Close Alert Change Password Success");
		changePasswordPage.clickToCloseNotificationSucess();
		changePasswordPage.sleepInSecond(2);

		log.info("Change_Password - Step 07: Click to Logout link");
		homePage = changePasswordPage.clickToLogoutLinkAtUserPage(driver);

		log.info("Change_Password - Step 08: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Change_Password - Step 09: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Change_Password - Step 10: Enter to OldPassword textbox with value is '" + oldPassword + "'");
		loginPage.inputToPasswordTextbox(oldPassword);

		log.info("Change_Password - Step 11: Click to Login Button");
		loginPage.clickToLoginButton();

		log.info("Change_Password - Step 12: Verify alert Login was unsuccessful");
		Assert.assertEquals(loginPage.getErrorMessageUnSuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		log.info("Change_Password - Step 13: Enter to Password textbox with value is '" + newPassword + "'");
		loginPage.inputToPasswordTextbox(newPassword);

		log.info("Change_Password - Step 14: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Change_Password - Step 15: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void My_Account_04_My_Product_Reviews() {
		log.info("My_Product_Reviews - Step 01: Click to Header menu");
		productCategoryPage = homePage.clickToHeaderMenuByText("Computers");

		log.info("My_Product_Reviews - Step 02: Verify Page Title correctly");
		Assert.assertTrue(productCategoryPage.isPageTitleByTextDisplayed(driver, "page-title", "Computers"));

		log.info("My_Product_Reviews - Step 03: Click to Category");
		productListPage = productCategoryPage.clickToCategoryByName("Desktops");

		log.info("My_Product_Reviews - Step 04: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Desktops"));

		log.info("My_Product_Reviews - Step 05: Click to Product title");
		productDetailPage = productListPage.clickToProductByName(productName);

		log.info("My_Product_Reviews - Step 06: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", productName));

		log.info("My_Product_Reviews - Step 07: Click to Add your review");
		productReviewPage = productDetailPage.clickAddYourReview();

		log.info("My_Product_Reviews - Step 08: Verify Product Name correctly in the Product Review Page");
		Assert.assertTrue(productReviewPage.isProductReviewByTextDisplayed(productName));

		log.info("My_Product_Reviews - Step 09: Enter to Review Title");
		productReviewPage.inputToTextboxById(driver, "AddProductReview_Title", productReviewTitle);

		log.info("My_Product_Reviews - Step 10: Enter to Review Text");
		productReviewPage.inputToReviewText(productReviewText);

		log.info("My_Product_Reviews - Step 11: Select Rating");
		productReviewPage.selectRatingByText("Not good");

		log.info("My_Product_Reviews - Step 12: Click to button Submit Review");
		productReviewPage.clickToButtonByText(driver, "Submit review");

		log.info("My_Product_Reviews - Step 13: Verify message 'Product review is successfully added.'");
		Assert.assertTrue(productReviewPage.isProductReviewSuccessDisplayed());

		log.info("My_Product_Reviews - Step 14: Click to My Account link");
		customerInfoPage = productReviewPage.openMyAccountPage(driver);

		log.info("My_Product_Reviews - Step 15: Verify 'My account - Customer info' page is displayed");
		verifyTrue(customerInfoPage.isSideBarPageDisplayed(driver, "My account - Customer info"));

		log.info("My_Product_Reviews - Step 16: Click to 'My product reviews' link");
		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);

		log.info("My_Product_Reviews - Step 17: Verify 'My account - My product reviews' page is displayed");
		verifyTrue(myProductReviewPage.isSideBarPageDisplayed(driver, "My account - My product reviews"));

		log.info("My_Product_Reviews - Step 18: Verify 'Review title' is displayed");
		verifyTrue(myProductReviewPage.isReviewTitleByTextDisplayed(productReviewTitle));

		log.info("My_Product_Reviews - Step 19: Verify 'Review Text' is displayed");
		verifyTrue(myProductReviewPage.isReviewTextByTextDisplayed(productReviewText));

		log.info("My_Product_Reviews - Step 20: Verify 'Product title' is displayed");
		verifyTrue(myProductReviewPage.isProductTitleByTextDisplayed(productReviewText, productName));

		log.info("My_Product_Reviews - Step 21: Verify 'Rating' is displayed");
		verifyTrue(myProductReviewPage.isRatingDisplayed(productReviewTitle, "40"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String firstName, lastName, emailAddress, oldPassword, newPassword, companyName, day, month, year;
	private String firstName_Address, lastName_Address, emailAddress_Address, companyName_Address, country;
	private String state, city, address_1, address_2, zipCode, phoneNumber, faxNumber, productReviewTitle, productReviewText, productName;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserProductCategoryPageObject productCategoryPage;
	private UserProductListPageObject productListPage;
	private UserProductDetailPageObject productDetailPage;
	private UserProductReviewPageObject productReviewPage;
	private UserMyProductReviewPageObject myProductReviewPage;
}
