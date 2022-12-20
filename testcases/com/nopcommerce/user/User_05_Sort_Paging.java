package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserProductCategoryPageObject;
import pageObjects.nopCommerce.user.UserProductListPageObject;

public class User_05_Sort_Paging extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Click to Header menu");
		productCategoryPage = homePage.openProductCategoryPage(driver, "Computers ");

		log.info("Pre-condition - Step 02: Verify Page Title correctly");
		Assert.assertTrue(productCategoryPage.isPageTitleByTextDisplayed(driver, "page-title", "Computers"));

		log.info("Pre-condition - Step 03: Click to Category");
		productListPage = productCategoryPage.clickToCategoryByName("Notebooks");

		log.info("Pre-condition - Step 04: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

	}

	@Test
	public void Sort_Paging_01_Sort_A_to_Z() {
		log.info("Sort_A_to_Z - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-orderby", "Name: A to Z");

		log.info("Sort_A_to_Z - Step 02: Verify Product Name sort by Ascending");
		Assert.assertTrue(productListPage.isProductNameSortByAscending());
	}

	public void Sort_Paging_02_Sort_Z_to_A() {
		log.info("Sort_Z_to_A - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-orderby", "Name: Z to A");
		productListPage.sleepInSecond(1);

		log.info("Sort_Z_to_A - Step 02: Verify Product Name sort by Descending");
		Assert.assertTrue(productListPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_Paging_03_Sort_Low_To_High() {
		log.info("Sort_Low_To_High - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-orderby", "Price: Low to High");
		productListPage.sleepInSecond(1);

		log.info("Sort_Low_To_High - Step 02: Verify Product Price sort by Ascending");
		Assert.assertTrue(productListPage.isProductPriceSortByAscending());
	}

	@Test
	public void Sort_Paging_04_Sort_High_To_Low() {
		log.info("Sort_High_To_Low - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-orderby", "Price: High to Low");
		productListPage.sleepInSecond(1);

		log.info("Sort_High_To_Low - Step 02: Verify Product Price sort by Descending");
		Assert.assertTrue(productListPage.isProductPriceSortByDescending());
	}

	@Test
	public void Sort_Paging_05_Paging_Display_3_Per_Page() {
		log.info("Paging_Display_3_Per_Page - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-pagesize", "3");
		productListPage.sleepInSecond(1);

		log.info("Paging_Display_3_Per_Page - Step 02: Verify displayed <= 3 product per page");
		Assert.assertTrue(productListPage.isProductDisplay3PerPage());

		log.info("Paging_Display_3_Per_Page - Step 03: Verify displayed next icon at page 1");
		Assert.assertTrue(productListPage.isPagingDisplayedByClass("next-page"));

		log.info("Paging_Display_3_Per_Page - Step 04: Click to page 2");
		productListPage.clickToIndividualPage();

		log.info("Paging_Display_3_Per_Page - Step 05: Verify displayed previous icon at page 2");
		Assert.assertTrue(productListPage.isPagingDisplayedByClass("previous-page"));
	}

	@Test
	public void Sort_Paging_06_Paging_Display_6_Per_Page() {
		log.info("Paging_Display_6_Per_Page - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-pagesize", "6");

		log.info("Paging_Display_6_Per_Page - Step 02: Verify displayed <= 6 product per page");
		Assert.assertTrue(productListPage.isProductDisplay6PerPage());

		log.info("Paging_Display_6_Per_Page - Step 03: Verify paging Undisplayed ");
		Assert.assertTrue(productListPage.isPagingUnDisplayed());
	}

	@Test
	public void Sort_Paging_07_Paging_Display_9_Per_Page() {
		log.info("Paging_Display_9_Per_Page - Step 01: Select item in Sort by dropdown");
		productListPage.selectItemInSortByID("products-pagesize", "9");

		log.info("Paging_Display_9_Per_Page - Step 02: Verify displayed <= 9 product per page");
		Assert.assertTrue(productListPage.isProductDisplay9PerPage());

		log.info("Paging_Display_9_Per_Page - Step 03: Verify paging Undisplayed ");
		Assert.assertTrue(productListPage.isPagingUnDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserProductCategoryPageObject productCategoryPage;
	private UserProductListPageObject productListPage;

}
