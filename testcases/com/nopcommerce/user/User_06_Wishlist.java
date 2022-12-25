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
import pageObjects.nopCommerce.user.UserCompareProductPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserProductCategoryPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserProductListPageObject;
import pageObjects.nopCommerce.user.UserRecentlyViewedProductsPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishListPageObject;

public class User_06_Wishlist extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		wishlistProduct = "Digital Storm VANQUISH 3 Custom Performance PC";
		firstName = "Jonhny";
		lastName = "Depp";

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 02: Set all Coolies and reload page");
		loginPage.setCookie(driver, Common_02_Register_Cookie.loggedCookies);
		loginPage.refreshCurrentoPage(driver);

		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Pre-condition - Step 04: Open Computers Page");
		productCategoryPage = homePage.openProductCategoryPage(driver, "Computers");

		log.info("Pre-condition - Step 05: Verify Page Title correctly");
		Assert.assertTrue(productCategoryPage.isPageTitleByTextDisplayed(driver, "page-title", "Computers"));

		log.info("Pre-condition - Step 06: Click to Category");
		productListPage = productCategoryPage.clickToCategoryByName("Desktops");

		log.info("Pre-condition - Step 07: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Desktops"));

	}

	@Test
	public void Wishlist_01_Add_To_Wishlist() {

		log.info("Add_To_Wishlist - Step 01: Open Product detail page");
		productDetailPage = productListPage.openProductDetailPage(productName);

		log.info("Add_To_Wishlist - Step 02: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", productName));

		log.info("Add_To_Wishlist - Step 03: Click to button Add to Wishlist");
		productDetailPage.clickToButtonAddToWishlist();

		log.info("Add_To_Wishlist - Step 04: Verify message 'The product has been added to your wishlist' is dispplayed");
		Assert.assertTrue(productDetailPage.isBarNotificationDisplayed(driver));

		log.info("Add_To_Wishlist - Step 05: Close Bar Notification");
		productDetailPage.clickCloseBarNotification(driver);

		log.info("Add_To_Wishlist - Step 06: Open Wishlist page");
		wishlistPage = productDetailPage.openWishlistPage(driver, "ico-wishlist");

		log.info("Add_To_Wishlist - Step 07: Verify Page Title 'Wishlist' is displayed");
		Assert.assertTrue(wishlistPage.isPageTitleByTextDisplayed(driver, "page-title", "Wishlist"));

		log.info("Add_To_Wishlist - Step 08: Verify the product name '" + productName + "' is displayed");
		Assert.assertTrue(wishlistPage.isProductNameDisplayed(driver, "product-name", productName));

		log.info("Add_To_Wishlist - Step 09: Click View wishlist from share link");
		wishlistPage.clickToShareLink("share-link");

		log.info("Add_To_Wishlist - Step 10: Verify 'Page Title' is displayed: 'Wishlist of " + firstName + " " + lastName + "'");
		Assert.assertTrue(wishlistPage.isPageTitleByTextDisplayed(driver, "page-title", "Wishlist of " + firstName + " " + lastName));
		wishlistPage.sleepInSecond(2);

		log.info("Add_To_Wishlist - Step 11: Verify the product name is displayed");
		Assert.assertTrue(wishlistPage.isProductNameDisplayed(driver, "product-name", productName));
	}

	@Test
	public void Wishlist_02_Add_Product_To_Cart_From_Wishlist() {
		log.info("Add_Product_To_Cart_From_Wishlist - Step 01: Open My Account page");
		customerInforPage = homePage.openMyAccountPage(driver);

		log.info("Add_Product_To_Cart_From_Wishlist - Step 02: Open Wishlist page");
		customerInforPage.openWishlistPage(driver, "ico-wishlist");

		log.info("Add_Product_To_Cart_From_Wishlist - Step 03: Click to checkbox Add to Cart");
		wishlistPage.clickToCheckboxAddToCart(productName);

		log.info("Add_Product_To_Cart_From_Wishlist - Step 04: Click to button Add to Cart");
		shoppingCartPage = wishlistPage.clickToButtonAddToCart();

		log.info("Add_Product_To_Cart_From_Wishlist - Step 05: Verify Shopping Cart page is displayed");
		Assert.assertTrue(shoppingCartPage.isPageTitleByTextDisplayed(driver, "page-title", "Shopping cart"));

		log.info("Add_Product_To_Cart_From_Wishlist - Step 06: Verify Product Name  '" + productName + "' is displayed in Shopping cart page");
		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(driver, "product-name", productName));

		log.info("Add_Product_To_Cart_From_Wishlist - Step 07: Open Wishlist page");
		wishlistPage = shoppingCartPage.openWishlistPage(driver, "ico-wishlist");

		log.info("Add_Product_To_Cart_From_Wishlist - Step 08: Verify Product Name  '" + productName + "' is Undisplayed in Wishlist page");
		Assert.assertTrue(wishlistPage.isProductNameUnDisplayed("product-name", productName));

	}

	@Test
	public void Wishlist_03_Remove_Product_In_Wishlist() {
		log.info("Remove_Product_In_Wishlist - Step 01: Click to Header menu");
		productCategoryPage = homePage.openProductCategoryPage(driver, "Computers");

		log.info("Remove_Product_In_Wishlist - Step 02: Verify Page Title correctly");
		Assert.assertTrue(productCategoryPage.isPageTitleByTextDisplayed(driver, "page-title", "Computers"));

		log.info("Remove_Product_In_Wishlist - Step 03: Click to Category");
		productListPage = productCategoryPage.clickToCategoryByName("Desktops");

		log.info("Remove_Product_In_Wishlist - Step 04: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Desktops"));

		log.info("Remove_Product_In_Wishlist - Step 05: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage(wishlistProduct);

		log.info("Remove_Product_In_Wishlist - Step 06: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", wishlistProduct));

		log.info("Remove_Product_In_Wishlist - Step 07: Click to button Add to Wishlist");
		productDetailPage.clickToButtonAddToWishlist();

		log.info("Remove_Product_In_Wishlist - Step 08: Verify message 'The product has been added to your wishlist' is dispplayed");
		Assert.assertTrue(productDetailPage.isBarNotificationDisplayed(driver));

		log.info("Remove_Product_In_Wishlist - Step 09: Close Bar Notification");
		productDetailPage.clickCloseBarNotification(driver);

		log.info("Remove_Product_In_Wishlist - Step 10: Open Wishlist page");
		wishlistPage = productDetailPage.openWishlistPage(driver, "ico-wishlist");

		log.info("Remove_Product_In_Wishlist - Step 11: Verify Page Title 'Wishlist' is displayed");
		Assert.assertTrue(wishlistPage.isPageTitleByTextDisplayed(driver, "page-title", "Wishlist"));

		log.info("Remove_Product_In_Wishlist - Step 12: Verify the product name '" + wishlistProduct + "' is displayed");
		Assert.assertTrue(wishlistPage.isProductNameDisplayed(driver, "product-name", wishlistProduct));

		log.info("Remove_Product_In_Wishlist - Step 13: Click to Remove button");
		wishlistPage.clickToRemoveButton(wishlistProduct);

		log.info("Remove_Product_In_Wishlist - Step 14: Verify message 'The wishlist is empty!' is displayed");
		Assert.assertTrue(wishlistPage.isMessageEmptytDisplayed(driver));

		log.info("Remove_Product_In_Wishlist - Step 15: Verify Product Name is Undisplayed in Wishlist page");
		Assert.assertTrue(wishlistPage.isProductNameUnDisplayed("product-name", wishlistProduct));

	}

	@Test
	public void Wishlist_04_Add_Product_To_Compare() {
		log.info("Add_Product_To_Compare - Step 01: Click to Header menu");
		productCategoryPage = homePage.openProductCategoryPage(driver, "Computers");

		log.info("Add_Product_To_Compare - Step 02: Verify Page Title correctly");
		Assert.assertTrue(productCategoryPage.isPageTitleByTextDisplayed(driver, "page-title", "Computers"));

		log.info("Add_Product_To_Compare - Step 03: Click to Category");
		productListPage = productCategoryPage.clickToCategoryByName("Desktops");

		log.info("Add_Product_To_Compare - Step 04: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Desktops"));

		log.info("Add_Product_To_Compare - Step 05: Add product to Compare");
		productListPage.addProductToCompare(wishlistProduct);

		log.info("Add_Product_To_Compare - Step 06: Verify message 'The product has been added to your product comparison' ");
		Assert.assertTrue(productListPage.isBarNotificationDisplayed(driver));

		log.info("Add_Product_To_Compare - Step 07: Close Bar Notification");
		productListPage.clickCloseBarNotification(driver);
		productListPage.sleepInSecond(1);

		log.info("Add_Product_To_Compare - Step 08: Add product to Compare");
		productListPage.addProductToCompare(productName);

		log.info("Add_Product_To_Compare - Step 09: Verify message 'The product has been added to your product comparison' ");
		Assert.assertTrue(productListPage.isBarNotificationDisplayed(driver));

		log.info("Add_Product_To_Compare - Step 10: Close Bar Notification");
		productListPage.clickCloseBarNotification(driver);
		productListPage.sleepInSecond(1);

		log.info("Add_Product_To_Compare - Step 11: Open Compare product page ");
		compareProductPage = productListPage.openCompareProductPage("Compare products list");

		log.info("Add_Product_To_Compare - Step 12: Verify page title 'Compare products' is displayed correctly ");
		Assert.assertTrue(compareProductPage.isPageTitleByTextDisplayed(driver, "page-title", "Compare products"));

		log.info("Add_Product_To_Compare - Step 13: Verify remove button displayed ");
		Assert.assertTrue(compareProductPage.isRemoveButtonDisplayed("2"));

		log.info("Add_Product_To_Compare - Step 14: Verify product name displayed ");
		Assert.assertTrue(compareProductPage.isProductNameDisplayed(wishlistProduct));

		log.info("Add_Product_To_Compare - Step 15: Verify product price displayed ");
		Assert.assertTrue(compareProductPage.isProductPriceDisplayed("$1,259.00"));

		log.info("Add_Product_To_Compare - Step 16: Verify remove button displayed ");
		Assert.assertTrue(compareProductPage.isRemoveButtonDisplayed("3"));

		log.info("Add_Product_To_Compare - Step 17: Verify product name displayed ");
		Assert.assertTrue(compareProductPage.isProductNameDisplayed(productName));

		log.info("Add_Product_To_Compare - Step 18: Verify product price displayed ");
		Assert.assertTrue(compareProductPage.isProductPriceDisplayed("$500.00"));

		log.info("Add_Product_To_Compare - Step 19: Click to Clear List button");
		compareProductPage.clickToClearListButton("clear-list");

		log.info("Add_Product_To_Compare - Step 20: Verify message 'You have no items to compare.' is displayed ");
		Assert.assertTrue(compareProductPage.isMessageEmptytDisplayed(driver));

		log.info("Add_Product_To_Compare - Step 21: Verify product name Undisplayed ");
		Assert.assertTrue(compareProductPage.isProductNameUnDisplayed(wishlistProduct));

		log.info("Add_Product_To_Compare - Step 22: Verify product name Undisplayed ");
		Assert.assertTrue(compareProductPage.isProductNameUnDisplayed(productName));

	}

	@Test
	public void Wishlist_05_Recently_Viewed_Products() {
		log.info("Recently_Viewed_Products - Step 01: Open Product Category page");
		productCategoryPage = homePage.openProductCategoryPage(driver, "Computers");

		log.info("Recently_Viewed_Products - Step 02: Verify Page Title correctly");
		Assert.assertTrue(productCategoryPage.isPageTitleByTextDisplayed(driver, "page-title", "Computers"));

		log.info("Recently_Viewed_Products - Step 03: Click to Category");
		productListPage = productCategoryPage.clickToCategoryByName("Notebooks");

		log.info("Recently_Viewed_Products - Step 04: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Recently_Viewed_Products - Step 05: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Apple MacBook Pro 13-inch");

		log.info("Recently_Viewed_Products - Step 06: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Apple MacBook Pro 13-inch"));

		log.info("Recently_Viewed_Products - Step 07: Hover To Header Menu");
		productDetailPage.hoverToHeaderMenu(driver, "Computers");

		log.info("Recently_Viewed_Products - Step 08: Click to Sub-menu");
		productListPage = productDetailPage.clickToSubMenu(driver, "Computers", "Notebooks");

		log.info("Recently_Viewed_Products - Step 09: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Recently_Viewed_Products - Step 10: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Asus N551JK-XO076H Laptop");

		log.info("Recently_Viewed_Products - Step 11: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Asus N551JK-XO076H Laptop"));

		log.info("Recently_Viewed_Products - Step 12: Hover To Header Menu");
		productDetailPage.hoverToHeaderMenu(driver, "Computers");

		log.info("Recently_Viewed_Products - Step 13: Click to Sub-menu");
		productListPage = productDetailPage.clickToSubMenu(driver, "Computers", "Notebooks");

		log.info("Recently_Viewed_Products - Step 14: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Recently_Viewed_Products - Step 15: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("HP Envy 6-1180ca 15.6-Inch Sleekbook");

		log.info("Recently_Viewed_Products - Step 16: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "HP Envy 6-1180ca 15.6-Inch Sleekbook"));

		log.info("Recently_Viewed_Products - Step 17: Hover To Header Menu");
		productDetailPage.hoverToHeaderMenu(driver, "Computers");

		log.info("Recently_Viewed_Products - Step 18: Click to Sub-menu");
		productListPage = productDetailPage.clickToSubMenu(driver, "Computers", "Notebooks");

		log.info("Recently_Viewed_Products - Step 19: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Recently_Viewed_Products - Step 20: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("HP Spectre XT Pro UltraBook");

		log.info("Recently_Viewed_Products - Step 21: Verify Product Name correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "HP Spectre XT Pro UltraBook"));

		log.info("Recently_Viewed_Products - Step 22: Hover To Header Menu");
		productDetailPage.hoverToHeaderMenu(driver, "Computers");

		log.info("Recently_Viewed_Products - Step 23: Click to Sub-menu");
		productListPage = productDetailPage.clickToSubMenu(driver, "Computers", "Notebooks");

		log.info("Recently_Viewed_Products - Step 24: Verify Page Title correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Recently_Viewed_Products - Step 25: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Lenovo Thinkpad X1 Carbon Laptop");

		log.info("Recently_Viewed_Products - Step 26: Verify Product Name correctly 'Lenovo Thinkpad X1 Carbon Laptop' ");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Lenovo Thinkpad X1 Carbon Laptop"));

		log.info("Recently_Viewed_Products - Step 27: Open 'Recently viewed products' page");
		recentlyViewedProductsPage = productDetailPage.openRecentlyViewedProductsPage("Recently viewed products");

		log.info("Recently_Viewed_Products - Step 28: Verify Page Title 'Recently viewed products' is displayed");
		Assert.assertTrue(recentlyViewedProductsPage.isPageTitleByTextDisplayed(driver, "page-title", "Recently viewed products"));

		log.info("Recently_Viewed_Products - Step 29: Verify just last 3 product are displayed");
		Assert.assertTrue(recentlyViewedProductsPage.isProductTitletDisplayed("product-title", "Lenovo Thinkpad X1 Carbon Laptop"));
		Assert.assertTrue(recentlyViewedProductsPage.isProductTitletDisplayed("product-title", "HP Spectre XT Pro UltraBook"));
		Assert.assertTrue(recentlyViewedProductsPage.isProductTitletDisplayed("product-title", "HP Spectre XT Pro UltraBook"));

		log.info("Recently_Viewed_Products - Step 30: Click to Logout link");
		homePage = recentlyViewedProductsPage.clickToLogoutLink(driver, "ico-logout");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String productName, wishlistProduct, firstName, lastName;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserProductCategoryPageObject productCategoryPage;
	private UserProductDetailPageObject productDetailPage;
	private UserProductListPageObject productListPage;
	private UserWishListPageObject wishlistPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserCompareProductPageObject compareProductPage;
	private UserRecentlyViewedProductsPageObject recentlyViewedProductsPage;
}
