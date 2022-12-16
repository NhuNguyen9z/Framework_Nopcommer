package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_02_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;

public class User_04_Search_Advanced_Search extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		dataNotExist = "Macbook Pro 2050";
		productNameRelative = "Lenovo";
		productNameAbsolute = "Lenovo IdeaCentre 600 All-in-One PC";
		advancedSearch = "Apple MacBook Pro";
		category = "Computers";
		incorrectManufacturer = "HP";
		correctManufacturer = "Apple";

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 02: Set all Coolies and reload page");
		loginPage.setCookie(driver, Common_02_Register_Cookie.loggedCookies);
		loginPage.refreshCurrentoPage(driver);

		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Pre-condition - Step 04: Open Search page at Footer");
		searchPage = homePage.openSearchPageAtFooter(driver, "Search");

	}

	@Test
	public void Search_01_Empty_Data() {
		log.info("Empty_Data - Step 01: Click to Seach button");
		searchPage.clickToButtonSearch();

		log.info("Empty_Data - Step 02: Verify 'Search term minimum length is 3 characters' warning is displayed");
		Assert.assertTrue(searchPage.isWarningSearchDisplayed());
		searchPage.sleepInSecond(2);
	}

	@Test
	public void Search_02_Data_Not_Exist() {
		log.info("Data_Not_Exist - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Data_Not_Exist - Step 02: Input to Textbox Search with value is '" + dataNotExist + "'");
		searchPage.inputToSearchTextbox(dataNotExist);

		log.info("Data_Not_Exist - Step 03: Click to Seach button");
		searchPage.clickToButtonSearch();

		log.info("Data_Not_Exist - Step 04: Verify 'No products were found that matched your criteria.' message is displayed");
		Assert.assertTrue(searchPage.isNoResultMessageDisplayed());
		searchPage.sleepInSecond(2);
	}

	@Test
	public void Search_03_Relate_Search() {
		log.info("Relate_Search - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Relate_Search - Step 02: Input to Textbox Search with value is '" + productNameRelative + "'");
		searchPage.inputToSearchTextbox(productNameRelative);

		log.info("Relate_Search - Step 03: Click to Seach button");
		searchPage.clickToButtonSearch();

		log.info("Relate_Search - Step 04: Verify Relative Product Name is displayed");
		Assert.assertTrue(searchPage.isProductNameDisplayed(productNameRelative));
	}

	@Test
	public void Search_04_Absolute_Search() {
		log.info("Absolute_Search - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Absolute_Search - Step 02: Input to Textbox Search with value is '" + productNameAbsolute + "'");
		searchPage.inputToSearchTextbox(productNameAbsolute);

		log.info("Absolute_Search - Step 03: Click to Seach button");
		searchPage.clickToButtonSearch();

		log.info("Absolute_Search - Step 04: Verify Absolute Product Name is displayed");
		Assert.assertTrue(searchPage.isProductNameDisplayed(productNameAbsolute));
	}

	@Test
	public void Search_05_Advanced_Search_Parent_Categories() {
		log.info("Advanced_Search_Parent_Categories - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Advanced_Search_Parent_Categories - Step 02: Input to Textbox Search with value is '" + advancedSearch + "'");
		searchPage.inputToSearchTextbox(advancedSearch);

		log.info("Advanced_Search_Parent_Categories - Step 03: Click to Advanced Search checkbox");
		searchPage.checkedSearchCheckboxByID("advs");

		log.info("Advanced_Search_Parent_Categories - Step 04: Select Category");
		searchPage.selectToDropdownByName(driver, "cid", category);
		searchPage.sleepInSecond(2);

		log.info("Advanced_Search_Parent_Categories - Step 05: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Advanced_Search_Parent_Categories - Step 06: Verify 'No products were found that matched your criteria.' message is displayed");
		Assert.assertTrue(searchPage.isNoResultMessageDisplayed());
	}

	@Test
	public void Search_06_Advanced_Sub_Categories() {
		log.info("Advanced_Sub_Categories - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Advanced_Sub_Categories - Step 02: Input to Textbox Search with value is '" + advancedSearch + "'");
		searchPage.inputToSearchTextbox(advancedSearch);

		log.info("Advanced_Sub_Categories - Step 03: Checked to Advanced Search checkbox");
		searchPage.checkedSearchCheckboxByID("advs");

		log.info("Advanced_Sub_Categories - Step 04: Select Category");
		searchPage.selectToDropdownByName(driver, "cid", category);

		log.info("Advanced_Sub_Categories - Step 05: Checked to Automatically search sub categories");
		searchPage.checkedSearchCheckboxByID("isc");

		log.info("Advanced_Sub_Categories - Step 06: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Advanced_Sub_Categories - Step 07: Verify Product Name displayed is '" + advancedSearch + "'");
		Assert.assertTrue(searchPage.isProductNameDisplayed(advancedSearch));
	}

	@Test
	public void Search_07_Advanced_Incorrect_Manufacturer() {
		log.info("Advanced_Incorrect_Manufacturer - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Advanced_Incorrect_Manufacturer - Step 02: Input to Textbox Search with value is '" + advancedSearch + "'");
		searchPage.inputToSearchTextbox(advancedSearch);

		log.info("Advanced_Incorrect_Manufacturer - Step 03: Checked to Advanced Search checkbox");
		searchPage.checkedSearchCheckboxByID("advs");

		log.info("Advanced_Incorrect_Manufacturer - Step 04: Select Category");
		searchPage.selectToDropdownByName(driver, "cid", category);
		searchPage.sleepInSecond(2);

		log.info("Advanced_Incorrect_Manufacturer - Step 05: Checked to Automatically search sub categories");
		searchPage.checkedSearchCheckboxByID("isc");

		log.info("Advanced_Incorrect_Manufacturer - Step 06: Select Manufacturer");
		searchPage.selectToDropdownByName(driver, "mid", incorrectManufacturer);
		searchPage.sleepInSecond(2);

		log.info("Advanced_Incorrect_Manufacturer - Step 07: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Advanced_Incorrect_Manufacturer - Step 08: Verify 'No products were found that matched your criteria.' message is displayed");
		Assert.assertTrue(searchPage.isNoResultMessageDisplayed());
		searchPage.sleepInSecond(3);
	}

	@Test
	public void Search_08_Advanced_Correct_Manufacturer() {
		log.info("Advanced_Correct_Manufacturer - Step 01: Open Search page at Footer");
		searchPage.openSearchPageAtFooter(driver, "Search");

		log.info("Advanced_Correct_Manufacturer - Step 02: Input to Textbox Search with value is '" + advancedSearch + "'");
		searchPage.inputToSearchTextbox(advancedSearch);

		log.info("Advanced_Correct_Manufacturer - Step 03: Checked to Advanced Search checkbox");
		searchPage.checkedSearchCheckboxByID("advs");

		log.info("Advanced_Correct_Manufacturer - Step 04: Select Category");
		searchPage.selectToDropdownByName(driver, "cid", category);
		searchPage.sleepInSecond(2);

		log.info("Advanced_Correct_Manufacturer - Step 05: Checked to Automatically search sub categories");
		searchPage.checkedSearchCheckboxByID("isc");

		log.info("Advanced_Correct_Manufacturer - Step 06: Select Manufacturer");
		searchPage.selectToDropdownByName(driver, "mid", correctManufacturer);
		searchPage.sleepInSecond(2);

		log.info("Advanced_Correct_Manufacturer - Step 07: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Advanced_Correct_Manufacturer - Step 08: Verify Product Name displayed is '" + advancedSearch + "'");
		Assert.assertTrue(searchPage.isProductNameDisplayed(advancedSearch));
		searchPage.sleepInSecond(2);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String dataNotExist, productNameRelative, productNameAbsolute, advancedSearch, category, incorrectManufacturer, correctManufacturer;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;
}
