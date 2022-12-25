package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserOrderDetailsPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserProductListPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;

public class User_07_Order extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		processer = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		processerEdit = "2.2 GHz Intel Pentium Dual-Core E2200";
		productCount = "There are 1 item(s) in your cart.";
		productName = "Build your own computer";
		productAttributes = "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\nRAM: 8GB [+$60.00]\nHDD: 400 GB [+$100.00]\nOS: Vista Premium [+$60.00]\nSoftware: Microsoft Office [+$50.00]\nSoftware: Acrobat Reader [+$10.00]\nSoftware: Total Commander [+$5.00]";
		productUnitPrice = "Unit price: $1,500.00";
		productQuantity = "Quantity: 1";
		productTotals = "Sub-Total: $1,500.00";
		barNotificationSucess = "The product has been added to your shopping cart";
		editProductUnitPrice = "$1,320.00";
		editProductAttributes = "Processor: 2.2 GHz Intel Pentium Dual-Core E2200\nRAM: 4GB [+$20.00]\nHDD: 320 GB\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]";
		editProductCount = "There are 2 item(s) in your cart.";
		editProductQuantity = "Quantity: 2";
		editCartProductUnitPrice = "Unit price: $1,320.00";
		editProductTotals = "Sub-Total: $2,640.00";
		editProductSubTotal = "$2,640.00";

		paymentInfor = "Mail Personal or Business Check, Cashier's Check or money order to:\n\nNOP SOLUTIONS\nyour address here,\nNew York, NY 10001\nUSA\nNotice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\nP.S. You can edit this text from admin panel.";
		paymentMethodMoney = "Payment Method: Check / Money Order";
		paymentMethodCreditCard = "Payment Method: Credit Card";
		shippingMethod2ndDay = "Shipping Method: 2nd Day Air";
		shippingMethodNextDay = "Shipping Method: Next Day Air";
		productCheckout = "Apple MacBook Pro 13-inch";
		orderDate = "Order Date: Saturday, December 24, 2022";
		visa = "4242424242424242";
		masterCard = "5555555555554444";
		cardName = "Zhang San";
		expirationMonth = "12";
		expirationYear = "2024";
		cvv = "567";
		creditCardType = "Master card";

		reorderSubTotalPrice = "$18,000.00";
		unitPrice = "$1,800.00";

		firstName_bill = "Jonhny";
		lastName_bill = "Depp";
		emailAddress_bill = "jonh" + getRandomEmail() + "@hotmail.com";
		password = "123456";
		phone_bill = "6505554100";
		city_bill = "Bend";
		state_bill = "Oregon";
		address_bill = "3637 Shamley Drive";
		zipCode_bill = "97702";
		country = "United States";

		firstName_shipping = "Nora";
		lastName_shipping = "Heart";
		emailAddress_shipping = "nora" + getRandomEmail() + "@yahoo.com";
		phone_shipping = "7505552222";
		city_shipping = "San Diego";
		state_shipping = "California";
		address_shipping = "3006 Signature Pt";
		zipCode_shipping = "92130";

		nameBilling = firstName_bill + " " + lastName_bill;
		emailBilling = "Email:" + " " + emailAddress_bill;
		phoneBilling = "Phone:" + " " + phone_bill;
		cityStateZipBilling = city_bill + "," + state_bill + "," + zipCode_bill;

		nameShipping = firstName_shipping + " " + lastName_shipping;
		emailShipping = "Email:" + " " + emailAddress_shipping;
		phoneShipping = "Phone:" + " " + phone_shipping;
		cityStateZipShipping = city_shipping + "," + state_shipping + "," + zipCode_shipping;

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-condition - Step 02: Enter to Fistname textbox with value is '" + firstName_bill + "'");
		registerPage.inputToFirstnameTextbox(firstName_bill);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName_bill + "'");
		registerPage.inputToLastnameTextbox(lastName_bill);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value is '" + emailAddress_bill + "'");
		registerPage.inputToEmailTextbox(emailAddress_bill);

		log.info("Pre-condition - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 10: Enter to Email textbox with value is '" + emailAddress_bill + "'");
		loginPage.inputToEmailTextbox(emailAddress_bill);

		log.info("Pre-condition - Step 11: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 12: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-condition - Step 13: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	public void Order_01_Add_Product_To_Cart() {
		log.info("Add_Product_To_Cart - Step 01: Hover To Header Menu");
		homePage.hoverToHeaderMenu(driver, "Computers");

		log.info("Add_Product_To_Cart - Step 02: Click to Sub-menu Desktops");
		productListPage = homePage.clickToSubMenu(driver, "Computers", "Desktops");
		productListPage.sleepInSecond(2);

		log.info("Add_Product_To_Cart - Step 03: Verify Page Title 'Desktops' is displayed correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Desktops"));

		log.info("Add_Product_To_Cart - Step 04: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Build your own computer");

		log.info("Add_Product_To_Cart - Step 05: Verify Product Name 'Build your own computer' is displayed correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Build your own computer"));

		log.info("Add_Product_To_Cart - Step 06: Select Processor");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_1", processer);

		log.info("Add_Product_To_Cart - Step 07: Select RAM");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_2", "8GB [+$60.00]");

		log.info("Add_Product_To_Cart - Step 08: Check HDD");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_3_7");

		log.info("Add_Product_To_Cart - Step 09: Choose OS is 'Vista Premium [+$60.00]' ");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_4_9");

		log.info("Add_Product_To_Cart - Step 10: Choose Software");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_5_10");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_5_11");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_5_12");

		log.info("Add_Product_To_Cart - Step 11: Click to Add to Cart button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");
		productDetailPage.sleepInSecond(2);

		log.info("Add_Product_To_Cart - Step 12: Verify message '' is dispplayed");
		Assert.assertTrue(productDetailPage.isBarNotificationDisplayed(driver));

		log.info("Add_Product_To_Cart - Step 13: Verify Shopping cart (1) is dispplayed");
		Assert.assertEquals(productDetailPage.getShoppingCartQty(driver, "ico-cart"), "Shopping cart (1)");

		log.info("Add_Product_To_Cart - Step 14: Hover into Shopping cart link");
		productDetailPage.hoverToShoppingCartLink("ico-cart");

		log.info("Add_Product_To_Cart - Step 15: Verify message 'There are 1 item(s) in your cart.' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("count"), productCount);
		System.out.println(productDetailPage.getProductInfoCartByClass("count"));

		log.info("Add_Product_To_Cart - Step 16: Verify product name is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("name"), productName);
		System.out.println(productDetailPage.getProductInfoCartByClass("name"));

		log.info("Add_Product_To_Cart - Step 17: Verify product attributes is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("attributes"), productAttributes);
		System.out.println(productDetailPage.getProductInfoCartByClass("attributes"));

		log.info("Add_Product_To_Cart - Step 18: Verify product price is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("price"), productUnitPrice);
		System.out.println(productDetailPage.getProductInfoCartByClass("price"));

		log.info("Add_Product_To_Cart - Step 19: Verify product quantity is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("quantity"), productQuantity);
		System.out.println(productDetailPage.getProductInfoCartByClass("quantity"));

		log.info("Add_Product_To_Cart - Step 20: Verify product totals is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("totals"), productTotals);
		System.out.println(productDetailPage.getProductInfoCartByClass("totals"));

	}

	public void Order_02_Edit_Product_In_Shopping_Cart() {
		log.info("Edit_Product_In_Shopping_Cart - Step 01: open Shopping Cart page");
		shoppingCartPage = productDetailPage.openShoppingCartPage("Go to cart");

		log.info("Edit_Product_In_Shopping_Cart - Step 02: Verify Page Title 'Shopping cart' is displayed correctly");
		Assert.assertTrue(shoppingCartPage.isPageTitleByTextDisplayed(driver, "page-title", "Shopping cart"));

		log.info("Edit_Product_In_Shopping_Cart - Step 03: Verify Product Name  '" + productName + "' is displayed in Shopping cart page");
		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(driver, "product-name", productName));

		log.info("Edit_Product_In_Shopping_Cart - Step 04: Verify Product attribute is displayed correctly");
		Assert.assertEquals(shoppingCartPage.getProductAttributes(), productAttributes);
		System.out.println(shoppingCartPage.getProductAttributes());

		log.info("Edit_Product_In_Shopping_Cart - Step 05: Open Edit Product page");
		productDetailPage = shoppingCartPage.openEditProductPage();

		log.info("Edit_Product_In_Shopping_Cart - Step 06: Verify Product Name  '" + productName + "' is displayed correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", productName));

		log.info("Edit_Product_In_Shopping_Cart - Step 07: Select Processor '" + processerEdit + "'");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_1", processerEdit);

		log.info("Edit_Product_In_Shopping_Cart - Step 08: Select RAM '4GB [+$20.00] ");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_2", "4GB [+$20.00]");

		log.info("Edit_Product_In_Shopping_Cart - Step 09: Check HDD '320 GB' ");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_3_6");

		log.info("Edit_Product_In_Shopping_Cart - Step 10: Choose OS is 'Vista Home [+$50.00]' ");
		productDetailPage.checkToCheckboxOrRadioByID(driver, "product_attribute_4_8");

		log.info("Edit_Product_In_Shopping_Cart - Step 11: Check Software 'Microsoft Office [+$50.00]' ");
		productDetailPage.uncheckToCheckboxOrRadioByID(driver, "product_attribute_5_11");
		productDetailPage.uncheckToCheckboxOrRadioByID(driver, "product_attribute_5_12");
		productDetailPage.sleepInSecond(1);

		log.info("Edit_Product_In_Shopping_Cart - Step 12: Entered 2 product");
		productDetailPage.inputToTextboxById(driver, "product_enteredQuantity_1", "2");

		log.info("Edit_Product_In_Shopping_Cart - Step 13: Verify Product Price '" + editProductUnitPrice + "' is dispplayed");
		Assert.assertEquals(productDetailPage.getProductUnitPrice(), editProductUnitPrice);

		log.info("Edit_Product_In_Shopping_Cart - Step 14: Click to Update button");
		productDetailPage.clickToButtonByText(driver, "Update");
		productDetailPage.sleepInSecond(1);

		log.info("Edit_Product_In_Shopping_Cart - Step 15: Verify message '" + barNotificationSucess + "' is dispplayed");
		Assert.assertEquals(productDetailPage.getBarNotificationSuccess(driver), barNotificationSucess);

		log.info("Edit_Product_In_Shopping_Cart - Step 16: Verify Shopping cart (2) is dispplayed");
		Assert.assertEquals(productDetailPage.getShoppingCartQty(driver, "ico-cart"), "Shopping cart (2)");

		log.info("Edit_Product_In_Shopping_Cart - Step 17: Hover into Shopping cart link");
		productDetailPage.hoverToShoppingCartLink("ico-cart");

		log.info("Edit_Product_In_Shopping_Cart - Step 18: Verify message 'There are 1 item(s) in your cart.' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("count"), editProductCount);
		System.out.println(productDetailPage.getProductInfoCartByClass("count"));

		log.info("Edit_Product_In_Shopping_Cart - Step 19: Verify product name is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("name"), productName);
		System.out.println(productDetailPage.getProductInfoCartByClass("name"));

		log.info("Edit_Product_In_Shopping_Cart - Step 20: Verify product attributes is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("attributes"), editProductAttributes);
		System.out.println(productDetailPage.getProductInfoCartByClass("attributes"));

		log.info("Edit_Product_In_Shopping_Cart - Step 21: Verify product price is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("price"), editCartProductUnitPrice);
		System.out.println(productDetailPage.getProductInfoCartByClass("price"));

		log.info("Edit_Product_In_Shopping_Cart - Step 22: Verify product quantity is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("quantity"), editProductQuantity);
		System.out.println(productDetailPage.getProductInfoCartByClass("quantity"));

		log.info("Edit_Product_In_Shopping_Cart - Step 23: Verify product totals '" + editProductTotals + "' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("totals"), editProductTotals);
		System.out.println(productDetailPage.getProductInfoCartByClass("totals"));

	}

	public void Order_03_Remove_From_Cart() {
		log.info("Remove_From_Cart - Step 01: open Shopping Cart page");
		shoppingCartPage = productDetailPage.openShoppingCartPage("Go to cart");

		log.info("Remove_From_Cart - Step 02: Verify Page Title 'Shopping cart' is displayed correctly");
		Assert.assertTrue(shoppingCartPage.isPageTitleByTextDisplayed(driver, "page-title", "Shopping cart"));

		log.info("Remove_From_Cart - Step 03: Verify Product Name  '" + productName + "' is displayed in Shopping cart page");
		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(driver, "product-name", productName));

		log.info("Remove_From_Cart - Step 04: Verify Product attribute is displayed correctly");
		Assert.assertEquals(shoppingCartPage.getProductAttributes(), editProductAttributes);
		System.out.println(shoppingCartPage.getProductAttributes());

		log.info("Remove_From_Cart - Step 05: Verify Product Unit Price is equals '" + editProductUnitPrice + "' ");
		Assert.assertEquals(shoppingCartPage.getProductInforByClass(driver, "product-unit-price"), editProductUnitPrice);
		System.out.println(shoppingCartPage.getProductInforByClass(driver, "product-unit-price"));

		log.info("Remove_From_Cart - Step 06: Verify Product Subtotal is equals '" + editProductSubTotal + "' ");
		Assert.assertEquals(shoppingCartPage.getProductInforByClass(driver, "product-subtotal"), editProductSubTotal);
		System.out.println(shoppingCartPage.getProductInforByClass(driver, "product-subtotal"));

		log.info("Remove_From_Cart - Step 07: Click to Remove button ");
		shoppingCartPage.clickToRemoveButton();

		log.info("Remove_From_Cart - Step 08: Verify message 'Your Shopping Cart is empty!' is displayed ");
		Assert.assertEquals(shoppingCartPage.getEmtyMessage(), "Your Shopping Cart is empty!");

		log.info("Remove_From_Cart - Step 09: Verify product name '" + productName + "' is Undisplayed in shopping cart page ");
		Assert.assertTrue(shoppingCartPage.isProductNameUnDisplayed("product-name", productName));

	}

	public void Order_04_Update_Shopping_Cart() {
		log.info("Update_Shopping_Cart - Step 01: Hover To Header Menu Computers");
		homePage.hoverToHeaderMenu(driver, "Computers");

		log.info("Update_Shopping_Cart - Step 02: Click to Sub-menu Desktops");
		productListPage = homePage.clickToSubMenu(driver, "Computers", "Desktops");
		productListPage.sleepInSecond(2);

		log.info("Update_Shopping_Cart - Step 03: Verify Page Title 'Desktops' is displayed correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Desktops"));

		log.info("Update_Shopping_Cart - Step 04: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Update_Shopping_Cart - Step 05: Verify Product Name 'Lenovo IdeaCentre 600 All-in-One PC' is displayed correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("Update_Shopping_Cart - Step 06: Entered 5 product");
		productDetailPage.inputToTextboxById(driver, "product_enteredQuantity_3", "5");

		log.info("Update_Shopping_Cart - Step 07: Verify Product Unit Price '$500.00' is dispplayed");
		Assert.assertEquals(productDetailPage.getProductUnitPrice(), "$500.00");

		log.info("Update_Shopping_Cartt - Step 08: Click to Add to cart button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");
		productDetailPage.sleepInSecond(1);

		log.info("Update_Shopping_Cart - Step 09: Verify message '" + barNotificationSucess + "' is dispplayed");
		Assert.assertEquals(productDetailPage.getBarNotificationSuccess(driver), barNotificationSucess);

		log.info("Update_Shopping_Cart - Step 10: Verify Shopping cart (5) is dispplayed");
		Assert.assertEquals(productDetailPage.getShoppingCartQty(driver, "ico-cart"), "Shopping cart (5)");

		log.info("Update_Shopping_Cart - Step 11: Hover into Shopping cart link");
		productDetailPage.hoverToShoppingCartLink("ico-cart");

		log.info("Update_Shopping_Cart - Step 12: Verify message 'There are 5 item(s) in your cart.' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("count"), "There are 5 item(s) in your cart.");
		System.out.println(productDetailPage.getProductInfoCartByClass("count"));

		log.info("Update_Shopping_Cart - Step 13: Verify product name Lenovo IdeaCentre 600 All-in-One PC' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("name"), "Lenovo IdeaCentre 600 All-in-One PC");
		System.out.println(productDetailPage.getProductInfoCartByClass("name"));

		log.info("Update_Shopping_Cart - Step 14: Verify product unit price '$500.00' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("price"), "Unit price: $500.00");
		System.out.println(productDetailPage.getProductInfoCartByClass("price"));

		log.info("Update_Shopping_Cart - Step 15: Verify product quantity is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("quantity"), "Quantity: 5");
		System.out.println(productDetailPage.getProductInfoCartByClass("quantity"));

		log.info("Update_Shopping_Cart - Step 16: Verify product totals 'Sub-Total: $2,500.00' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("totals"), "Sub-Total: $2,500.00");
		System.out.println(productDetailPage.getProductInfoCartByClass("totals"));

		log.info("Update_Shopping_Cart - Step 17: open Shopping Cart page");
		shoppingCartPage = productDetailPage.openShoppingCartPage("Go to cart");

		log.info("Update_Shopping_Cart - Step 18: Verify Page Title 'Shopping cart' is displayed correctly");
		Assert.assertTrue(shoppingCartPage.isPageTitleByTextDisplayed(driver, "page-title", "Shopping cart"));

		log.info("Update_Shopping_Cart - Step 19: Verify Product Name  'Apple MacBook Pro 13-inch' is displayed in Shopping cart page");
		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(driver, "product-name", "Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("Update_Shopping_Cart - Step 20: Click to Remove button ");
		shoppingCartPage.clickToRemoveButton();

		log.info("Update_Shopping_Cart - Step 21: Verify message 'Your Shopping Cart is empty!' is displayed ");
		Assert.assertEquals(shoppingCartPage.getEmtyMessage(), "Your Shopping Cart is empty!");

		log.info("Update_Shopping_Cart - Step 22: Verify product name 'Lenovo IdeaCentre 600 All-in-One PC' is Undisplayed in shopping cart page ");
		Assert.assertTrue(shoppingCartPage.isProductNameUnDisplayed("product-name", "Lenovo IdeaCentre 600 All-in-One PC"));

	}

	public void Order_05_Checkout_By_Money() {

		log.info("Checkout - Step 01: Hover To Header Menu Computers");
		homePage.hoverToHeaderMenu(driver, "Computers");

		log.info("Checkout - Step 02: Click to Sub-menu Desktops");
		productListPage = homePage.clickToSubMenu(driver, "Computers", "Notebooks");
		productListPage.sleepInSecond(2);

		log.info("Checkout - Step 03: Verify Page Title 'Notebooks' is displayed correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Checkout - Step 04: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Apple MacBook Pro 13-inch");

		log.info("Checkout - Step 05: Verify Product Name 'Apple MacBook Pro 13-inch' is displayed correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Apple MacBook Pro 13-inch"));

		log.info("Checkout - Step 07: Verify Product Unit Price '" + unitPrice + "' is dispplayed");
		Assert.assertEquals(productDetailPage.getProductUnitPrice(), unitPrice);

		log.info("Checkout - Step 08: Click to Add to cart button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");
		productDetailPage.sleepInSecond(1);

		log.info("Checkout - Step 09: Verify message '" + barNotificationSucess + "' is dispplayed");
		Assert.assertEquals(productDetailPage.getBarNotificationSuccess(driver), barNotificationSucess);

		log.info("Checkout - Step 10: Verify Shopping cart (2) is dispplayed");
		Assert.assertEquals(productDetailPage.getShoppingCartQty(driver, "ico-cart"), "Shopping cart (2)");

		log.info("Checkout - Step 11: Hover into Shopping cart link");
		productDetailPage.hoverToShoppingCartLink("ico-cart");

		log.info("Checkout - Step 12: Verify message 'There are 2 item(s) in your cart.' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("count"), "There are 2 item(s) in your cart.");
		System.out.println(productDetailPage.getProductInfoCartByClass("count"));

		log.info("Checkout - Step 13: Verify product name '" + productCheckout + "' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("name"), productCheckout);
		System.out.println(productDetailPage.getProductInfoCartByClass("name"));

		log.info("Checkout - Step 14: Verify product unit price '" + unitPrice + "' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("price"), "Unit price: " + unitPrice + "");
		System.out.println(productDetailPage.getProductInfoCartByClass("price"));

		log.info("Checkout - Step 15: Verify product quantity is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("quantity"), "Quantity: 2");
		System.out.println(productDetailPage.getProductInfoCartByClass("quantity"));

		log.info("Checkout - Step 16: Verify product totals 'Sub-Total: $3,600.00' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("totals"), "Sub-Total: $3,600.00");
		System.out.println(productDetailPage.getProductInfoCartByClass("totals"));

		log.info("Checkout - Step 17: open Shopping Cart page");
		shoppingCartPage = productDetailPage.openShoppingCartPage("Go to cart");

		log.info("Checkout - Step 18: Verify Page Title 'Shopping cart' is displayed correctly");
		Assert.assertTrue(shoppingCartPage.isPageTitleByTextDisplayed(driver, "page-title", "Shopping cart"));

		log.info("Checkout - Step 19: Verify Product Name  '" + productCheckout + "' is displayed in Shopping cart page");
		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(driver, "product-name", productCheckout));

		log.info("Checkout - Step 20: Open popup Estimate shipping");
		shoppingCartPage.openPopupEstimateShipping();

		log.info("Checkout - Step 21: Verify popup Estimate shipping is displayed ");
		Assert.assertTrue(shoppingCartPage.isPopupEstimateShippingDisplayed());

		log.info("Checkout - Step 22: Select Country ");
		shoppingCartPage.selectToDropdownByName(driver, "CountryId", "United States");

		log.info("Checkout - Step 23: Select State ");
		shoppingCartPage.selectToDropdownByName(driver, "StateProvinceId", "New York");

		log.info("Checkout - Step 24: Input ZipCode ");
		shoppingCartPage.inputToTextboxById(driver, "ZipPostalCode", "10012");
		shoppingCartPage.sleepInSecond(3);

		log.info("Checkout - Step 25: Verify shipping method are displayed");
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("Ground"));
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("Next Day Air"));
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("2nd Day Air"));

		log.info("Checkout - Step 26: Choose shipping method is '2nd Day Air' ");
		shoppingCartPage.checkToShippingMethodByName("2nd Day Air");

		log.info("Checkout - Step 27: Click Apply button");
		shoppingCartPage.clickToButtonByText(driver, "Apply");

		log.info("Checkout - Step 28: Verify popup Estimate shipping is Undisplayed");
		Assert.assertTrue(shoppingCartPage.isPopupEstimateShippingUnDisplayed());

		log.info("Checkout - Step 29: Verify shipping method 2nd Day Air is displayed");
		Assert.assertTrue(shoppingCartPage.isShippingMethodDisplayed("(2nd Day Air)"));

		log.info("Checkout - Step 30: Choose checkbox 'I agree with the terms of service and I adhere to them unconditionally' ");
		shoppingCartPage.checkToCheckboxOrRadioByID(driver, "termsofservice");

		log.info("Checkout - Step 31: Open checkout page");
		checkoutPage = shoppingCartPage.openCheckoutPage("checkout");

		log.info("Checkout - Step 32: Verify Page Title 'Checkout' is displayed correctly");
		Assert.assertTrue(checkoutPage.isPageTitleByTextDisplayed(driver, "page-title", "Checkout"));

		log.info("Checkout - Step 32: Uncheck to checkbox Ship to the same address");
		checkoutPage.uncheckToCheckboxOrRadioByID(driver, "ShipToSameAddress");

		log.info("Checkout - Step 33: Verify Value First name is displayed correctly");
		Assert.assertEquals(checkoutPage.getValueTextboxById("BillingNewAddress_FirstName"), firstName_bill);
		System.out.println(checkoutPage.getValueTextboxById("BillingNewAddress_FirstName"));

		log.info("Checkout - Step 34: Verify Title Last name is displayed correctly");
		Assert.assertEquals(checkoutPage.getValueTextboxById("BillingNewAddress_LastName"), lastName_bill);
		System.out.println(checkoutPage.getValueTextboxById("BillingNewAddress_LastName"));

		log.info("Checkout - Step 35: Verify Title Email is displayed correctly");
		Assert.assertEquals(checkoutPage.getValueTextboxById("BillingNewAddress_Email"), emailAddress_bill);
		System.out.println(checkoutPage.getValueTextboxById("BillingNewAddress_Email"));

		log.info("Checkout - Step 36: Select Country");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", country);

		log.info("Checkout - Step 37: Select State");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.StateProvinceId", state_bill);

		log.info("Checkout - Step 38: Input City");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_City", city_bill);

		log.info("Checkout - Step 39: Input Address 1");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_Address1", address_bill);

		log.info("Checkout - Step 40: Input ZipCode");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_ZipPostalCode", zipCode_bill);

		log.info("Checkout - Step 41: Input phone number");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_PhoneNumber", phone_bill);

		log.info("Checkout - Step 42: Click to Continue button");
		checkoutPage.clickToButtonByText(driver, "Continue");

		log.info("Checkout - Step 43: Select New  shipping sddress");
		checkoutPage.selectToDropdownByName(driver, "shipping_address_id", "New Address");

		log.info("Checkout - Step 44: Verify Dropdow new addess is displayed");
		Assert.assertTrue(checkoutPage.isNewAddressDropdownDisplayed());

		log.info("Checkout - Step 45: Input First Name");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_FirstName", firstName_shipping);

		log.info("Checkout - Step 46: Input Last Name");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_LastName", lastName_shipping);

		log.info("Checkout - Step 47: Input Email");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_Email", emailAddress_shipping);

		log.info("Checkout - Step 48: Select Country");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.CountryId", country);
		checkoutPage.sleepInSecond(1);

		log.info("Checkout - Step 49: Select State");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.StateProvinceId", state_shipping);

		log.info("Checkout - Step 50: Input City");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_City", city_shipping);

		log.info("Checkout - Step 51: Input Address 1");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_Address1", address_bill);

		log.info("Checkout - Step 52: Input ZipCode");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_ZipPostalCode", zipCode_shipping);

		log.info("Checkout - Step 53: Input phone number");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_PhoneNumber", phone_shipping);

		log.info("Checkout - Step 54: Click to Continue button");
		checkoutPage.clickToButtonByClass("shipping", "new-address");

		log.info("Checkout - Step 55: Select to shipping method ' 2nd Day Air'");
		checkoutPage.checkToCheckboxOrRadioByID(driver, "shippingoption_2");

		log.info("Checkout - Step 56: Click to Continue button");
		checkoutPage.clickToButtonByClass("shipping-method", "shipping-method");

		log.info("Checkout - Step 57: Choose Payment method is Money Order");
		checkoutPage.checkToCheckboxOrRadioByID(driver, "paymentmethod_0");

		log.info("Checkout - Step 58: Click to Continue button");
		checkoutPage.clickToButtonByClass("payment-method", "payment-method");

		log.info("Checkout - Step 59: Verify payment information is displayed");
		Assert.assertEquals(checkoutPage.getPaymentInfor(), paymentInfor);
		System.out.println(checkoutPage.getPaymentInfor());

		log.info("Checkout - Step 60: Click to Continue button");
		checkoutPage.clickToButtonByClass("payment-info", "payment-info");

		log.info("Checkout - Step 61: Verify Billing infor address");
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "name"), nameBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "email"), emailBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "phone"), phoneBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "address1"), address_bill);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "city-state-zip"), cityStateZipBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "country"), country);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "payment-method-info", "payment-method"), paymentMethodMoney);

		log.info("Checkout - Step 62: Verify Shipping infor address");
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "name"), nameShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "email"), emailShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "phone"), phoneShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "address1"), address_bill);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "city-state-zip"), cityStateZipShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "country"), country);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-method-info", "shipping-method"), shippingMethod2ndDay);

		log.info("Checkout - Step 63: Verify SKU number is correctly");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "sku-number"), "AP_MBP_13");

		log.info("Checkout - Step 64: Verify Product Name  '" + productCheckout + "' is displayed correctly");
		Assert.assertTrue(checkoutPage.isProductNameDisplayed(driver, "product-name", productCheckout));

		log.info("Checkout - Step 65: Verify Product Unit Price is equals '$1,800.00' ");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-unit-price"), "$1,800.00");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-unit-price"));

		log.info("Checkout - Step 66: Verify product qty is correctly");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-quantity"), "2");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-quantity"));

		log.info("Checkout - Step 67: Verify Product Subtotal is equals '$3,600.00' ");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-subtotal"), "$3,600.00");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-subtotal"));

		log.info("Checkout - Step 68: Verify 'Gift wrapping: No' is displayed correctly");
		Assert.assertEquals(checkoutPage.getCheckoutAttributesByClass(driver), "Gift wrapping: No");

		log.info("Checkout - Step 69: Verify Total Infor is displayed correctly");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("order-subtotal"), "Sub-Total: $3,600.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("shipping-cost"), "Shipping: (2nd Day Air) $0.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("tax-value"), "Tax: $0.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("order-total"), "Total: $3,600.00");

		log.info("Checkout - Step 70: Click to Confirm button");
		checkoutPage.clickToButtonByText(driver, "Confirm");

		log.info("Checkout - Step 71: Verify Page Title 'Thank you' is displayed correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Thank you"));

		log.info("Checkout - Step 72: Verify message 'Your order has been successfully processed!' is displayed correctly");
		Assert.assertEquals(checkoutPage.getOrderCompleteMessageByClass("title"), "Your order has been successfully processed!");

		log.info("Checkout - Step 73: Verify message 'order-number' is displayed");
		Assert.assertTrue(checkoutPage.isOderNumberDisplayed("details"));

		log.info("Checkout - Step 74: Open My Customer Infor page");
		customerInforPage = checkoutPage.openMyAccountPage(driver);

		log.info("Checkout - Step 75: Open My Oders page");
		ordersPage = customerInforPage.openMyOderPage("Orders");

		log.info("Checkout - Step 76: Verify Page Title 'My account - Orders' is displayed correctly");
		Assert.assertTrue(ordersPage.isPageTitleByTextDisplayed(driver, "page-title", "My account - Orders"));

		log.info("Checkout - Step 77: Verify Order Number is displayed correctly");
		Assert.assertTrue(ordersPage.isOrderNumberDisplayed());

		log.info("Checkout - Step 78: Click to Details link");
		orderDetails = ordersPage.openOrderDetailsPage("Details");

		log.info("Checkout - Step 79: Verify Page Title 'Order information' is displayed correctly");
		Assert.assertTrue(orderDetails.isPageTitleByTextDisplayed(driver, "page-title", "Order information"));

		log.info("Checkout - Step 80: Verify Order Number is displayed correctly");
		orderDetails.isOderNumberDisplayedInDetailsPage();

		log.info("Checkout - Step 81: Verify Order Overview Content are displayed correctly");
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-date"), orderDate);
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-status"), "Order Status: Pending");
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-total"), "Order Total: $3,600.00");

		log.info("Checkout - Step 82: Verify Billing infor address");
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "name"), nameBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "email"), emailBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "phone"), phoneBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "address1"), address_bill);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "city-state-zip"), cityStateZipBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "country"), country);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "payment-method-info", "payment-method"), paymentMethodMoney);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "payment-method-info", "payment-method-status"), "Payment Status: Pending");

		log.info("Checkout - Step 83: Verify Shipping infor address");
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "name"), nameShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "email"), emailShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "phone"), phoneShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "address1"), address_bill);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "city-state-zip"), cityStateZipShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "country"), country);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-method-info", "shipping-method"), shippingMethod2ndDay);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-method-info", "shipping-status"), "Shipping Status: Not yet shipped");

		log.info("Checkout - Step 84: Verify SKU number is correctly");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "sku-number"), "AP_MBP_13");

		log.info("Checkout - Step 85: Verify Product Name  '" + productCheckout + "' is displayed correctly");
		Assert.assertEquals(orderDetails.getProductName(productCheckout), productCheckout);

		log.info("Checkout - Step 86: Verify Product Unit Price is equals '$1,800.00' ");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-unit-price"), "$1,800.00");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-unit-price"));

		log.info("Checkout - Step 87: Verify product qty is correctly");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-quantity"), "2");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-quantity"));

		log.info("Checkout - Step 88: Verify Product Subtotal is equals '$3,600.00' ");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-subtotal"), "$3,600.00");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-subtotal"));

		log.info("Checkout - Step 89: Verify 'Gift wrapping: No' is displayed correctly");
		Assert.assertEquals(orderDetails.getCheckoutAttributesByClass(driver), "Gift wrapping: No");

		log.info("Checkout - Step 90: Verify Total Infor is displayed correctly");
		Assert.assertEquals(orderDetails.getCartTotalInfor(), "Sub-Total: $3,600.00\nShipping: $0.00\nTax: $0.00\nOrder Total: $3,600.00");

	}

	@Test
	public void Order_06_Checkout_By_Card() {
		log.info("Checkout - Step 01: Hover To Header Menu Computers");
		homePage.hoverToHeaderMenu(driver, "Computers");

		log.info("Checkout - Step 02: Click to Sub-menu Desktops");
		productListPage = homePage.clickToSubMenu(driver, "Computers", "Notebooks");
		productListPage.sleepInSecond(2);

		log.info("Checkout - Step 03: Verify Page Title 'Notebooks' is displayed correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Notebooks"));

		log.info("Checkout - Step 04: Click to Product Name");
		productDetailPage = productListPage.openProductDetailPage("Apple MacBook Pro 13-inch");

		log.info("Checkout - Step 05: Verify Product Name 'Apple MacBook Pro 13-inch' is displayed correctly");
		Assert.assertTrue(productDetailPage.isPageTitleByTextDisplayed(driver, "product-name", "Apple MacBook Pro 13-inch"));

		log.info("Checkout - Step 07: Verify Product Unit Price '$1,800.00' is dispplayed");
		Assert.assertEquals(productDetailPage.getProductUnitPrice(), "$1,800.00");

		log.info("Checkout - Step 08: Click to Add to cart button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");
		productDetailPage.sleepInSecond(1);

		log.info("Checkout - Step 09: Verify message '" + barNotificationSucess + "' is dispplayed");
		Assert.assertEquals(productDetailPage.getBarNotificationSuccess(driver), barNotificationSucess);

		log.info("Checkout - Step 10: Verify Shopping cart (2) is dispplayed");
		Assert.assertEquals(productDetailPage.getShoppingCartQty(driver, "ico-cart"), "Shopping cart (2)");

		log.info("Checkout - Step 11: Hover into Shopping cart link");
		productDetailPage.hoverToShoppingCartLink("ico-cart");

		log.info("Checkout - Step 12: Verify message 'There are 2 item(s) in your cart.' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("count"), "There are 2 item(s) in your cart.");
		System.out.println(productDetailPage.getProductInfoCartByClass("count"));

		log.info("Checkout - Step 13: Verify product name 'Apple MacBook Pro 13-inch' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("name"), "Apple MacBook Pro 13-inch");
		System.out.println(productDetailPage.getProductInfoCartByClass("name"));

		log.info("Checkout - Step 14: Verify product unit price '$1,800.00' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("price"), "Unit price: $1,800.00");
		System.out.println(productDetailPage.getProductInfoCartByClass("price"));

		log.info("Checkout - Step 15: Verify product quantity is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("quantity"), "Quantity: 2");
		System.out.println(productDetailPage.getProductInfoCartByClass("quantity"));

		log.info("Checkout - Step 16: Verify product totals 'Sub-Total: $3,600.00' is displayed");
		Assert.assertEquals(productDetailPage.getProductInfoCartByClass("totals"), "Sub-Total: $3,600.00");
		System.out.println(productDetailPage.getProductInfoCartByClass("totals"));

		log.info("Checkout - Step 17: open Shopping Cart page");
		shoppingCartPage = productDetailPage.openShoppingCartPage("Go to cart");

		log.info("Checkout - Step 18: Verify Page Title 'Shopping cart' is displayed correctly");
		Assert.assertTrue(shoppingCartPage.isPageTitleByTextDisplayed(driver, "page-title", "Shopping cart"));

		log.info("Checkout - Step 19: Verify Product Name  'Apple MacBook Pro 13-inch' is displayed in Shopping cart page");
		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(driver, "product-name", "Apple MacBook Pro 13-inch"));

		log.info("Checkout - Step 20: Open popup Estimate shipping");
		shoppingCartPage.openPopupEstimateShipping();

		log.info("Checkout - Step 21: Verify popup Estimate shipping is displayed ");
		Assert.assertTrue(shoppingCartPage.isPopupEstimateShippingDisplayed());

		log.info("Checkout - Step 22: Select Country ");
		shoppingCartPage.selectToDropdownByName(driver, "CountryId", "United States");

		log.info("Checkout - Step 23: Select State ");
		shoppingCartPage.selectToDropdownByName(driver, "StateProvinceId", "New York");

		log.info("Checkout - Step 24: Input ZipCode ");
		shoppingCartPage.inputToTextboxById(driver, "ZipPostalCode", "10012");
		shoppingCartPage.sleepInSecond(3);

		log.info("Checkout - Step 25: Verify shipping method are displayed");
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("Ground"));
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("Next Day Air"));
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("2nd Day Air"));

		log.info("Checkout - Step 26: Choose shipping method is '2nd Day Air' ");
		shoppingCartPage.checkToShippingMethodByName("2nd Day Air");

		log.info("Checkout - Step 27: Click Apply button");
		shoppingCartPage.clickToButtonByText(driver, "Apply");

		log.info("Checkout - Step 28: Verify popup Estimate shipping is Undisplayed");
		Assert.assertTrue(shoppingCartPage.isPopupEstimateShippingUnDisplayed());

		log.info("Checkout - Step 29: Verify shipping method 2nd Day Air is displayed");
		Assert.assertTrue(shoppingCartPage.isShippingMethodDisplayed("(2nd Day Air)"));

		log.info("Checkout - Step 30: Choose checkbox 'I agree with the terms of service and I adhere to them unconditionally' ");
		shoppingCartPage.checkToCheckboxOrRadioByID(driver, "termsofservice");

		log.info("Checkout - Step 31: Open checkout page");
		checkoutPage = shoppingCartPage.openCheckoutPage("checkout");

		log.info("Checkout - Step 32: Verify Page Title 'Checkout' is displayed correctly");
		Assert.assertTrue(checkoutPage.isPageTitleByTextDisplayed(driver, "page-title", "Checkout"));

		log.info("Checkout - Step 32: Uncheck to checkbox Ship to the same address");
		checkoutPage.uncheckToCheckboxOrRadioByID(driver, "ShipToSameAddress");

		log.info("Checkout - Step 33: Verify Value First name is displayed correctly");
		Assert.assertEquals(checkoutPage.getValueTextboxById("BillingNewAddress_FirstName"), firstName_bill);
		System.out.println(checkoutPage.getValueTextboxById("BillingNewAddress_FirstName"));

		log.info("Checkout - Step 34: Verify Title Last name is displayed correctly");
		Assert.assertEquals(checkoutPage.getValueTextboxById("BillingNewAddress_LastName"), lastName_bill);
		System.out.println(checkoutPage.getValueTextboxById("BillingNewAddress_LastName"));

		log.info("Checkout - Step 35: Verify Title Email is displayed correctly");
		Assert.assertEquals(checkoutPage.getValueTextboxById("BillingNewAddress_Email"), emailAddress_bill);
		System.out.println(checkoutPage.getValueTextboxById("BillingNewAddress_Email"));

		log.info("Checkout - Step 36: Select Country");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", country);

		log.info("Checkout - Step 37: Select State");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.StateProvinceId", state_bill);

		log.info("Checkout - Step 38: Input City");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_City", city_bill);

		log.info("Checkout - Step 39: Input Address 1");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_Address1", address_bill);

		log.info("Checkout - Step 40: Input ZipCode");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_ZipPostalCode", zipCode_bill);

		log.info("Checkout - Step 41: Input phone number");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_PhoneNumber", phone_bill);

		log.info("Checkout - Step 42: Click to Continue button");
		checkoutPage.clickToButtonByText(driver, "Continue");

		log.info("Checkout - Step 43: Select New  shipping sddress");
		checkoutPage.selectToDropdownByName(driver, "shipping_address_id", "New Address");

		log.info("Checkout - Step 44: Verify Dropdow new addess is displayed");
		Assert.assertTrue(checkoutPage.isNewAddressDropdownDisplayed());

		log.info("Checkout - Step 45: Input First Name");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_FirstName", firstName_shipping);

		log.info("Checkout - Step 46: Input Last Name");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_LastName", lastName_shipping);

		log.info("Checkout - Step 47: Input Email");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_Email", emailAddress_shipping);

		log.info("Checkout - Step 48: Select Country");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.CountryId", country);
		checkoutPage.sleepInSecond(1);

		log.info("Checkout - Step 49: Select State");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.StateProvinceId", state_shipping);

		log.info("Checkout - Step 50: Input City");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_City", city_shipping);

		log.info("Checkout - Step 51: Input Address 1");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_Address1", address_bill);

		log.info("Checkout - Step 52: Input ZipCode");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_ZipPostalCode", zipCode_shipping);

		log.info("Checkout - Step 53: Input phone number");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_PhoneNumber", phone_shipping);

		log.info("Checkout - Step 54: Click to Continue button");
		checkoutPage.clickToButtonByClass("shipping", "new-address");

		log.info("Checkout - Step 55: Select to shipping method ' 2nd Day Air'");
		checkoutPage.checkToCheckboxOrRadioByID(driver, "shippingoption_2");

		log.info("Checkout - Step 56: Click to Continue button");
		checkoutPage.clickToButtonByClass("shipping-method", "shipping-method");

		log.info("Checkout - Step 57: Choose Payment method is Credit Card");
		checkoutPage.checkToCheckboxOrRadioByID(driver, "paymentmethod_1");

		log.info("Checkout - Step 58: Click to Continue button");
		checkoutPage.clickToButtonByClass("payment-method", "payment-method");

		log.info("Checkout - Step 58: Select credit card is visa");
		checkoutPage.selectToDropdownByName(driver, "CreditCardType", creditCardType);

		log.info("Checkout - Step 58: Input Card holder name");
		checkoutPage.inputToTextboxById(driver, "CardholderName", cardName);

		log.info("Checkout - Step 58: Input Card number");
		checkoutPage.inputToTextboxById(driver, "CardNumber", masterCard);

		log.info("Checkout - Step 58: Select expiration month");
		checkoutPage.selectToDropdownByName(driver, "ExpireMonth", expirationMonth);

		log.info("Checkout - Step 58: Select expiration year");
		checkoutPage.selectToDropdownByName(driver, "ExpireYear", expirationYear);

		log.info("Checkout - Step 58: Input Card code");
		checkoutPage.inputToTextboxById(driver, "CardCode", cvv);

		log.info("Checkout - Step 58: Click to Continue button");
		checkoutPage.clickToButtonByClass("payment-info", "payment-info");

		log.info("Checkout - Step 61: Verify Billing infor address");
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "name"), nameBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "email"), emailBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "phone"), phoneBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "address1"), address_bill);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "city-state-zip"), cityStateZipBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "country"), country);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "payment-method-info", "payment-method"), paymentMethodCreditCard);

		log.info("Checkout - Step 62: Verify Shipping infor address");
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "name"), nameShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "email"), emailShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "phone"), phoneShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "address1"), address_bill);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "city-state-zip"), cityStateZipShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "country"), country);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-method-info", "shipping-method"), shippingMethod2ndDay);

		log.info("Checkout - Step 63: Verify SKU number is correctly");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "sku-number"), "AP_MBP_13");

		log.info("Checkout - Step 64: Verify Product Name  '" + productCheckout + "' is displayed correctly");
		Assert.assertTrue(checkoutPage.isProductNameDisplayed(driver, "product-name", productCheckout));

		log.info("Checkout - Step 65: Verify Product Unit Price is equals '$1,800.00' ");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-unit-price"), "$1,800.00");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-unit-price"));

		log.info("Checkout - Step 66: Verify product qty is correctly");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-quantity"), "2");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-quantity"));

		log.info("Checkout - Step 67: Verify Product Subtotal is equals '$3,600.00' ");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-subtotal"), "$3,600.00");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-subtotal"));

		log.info("Checkout - Step 68: Verify 'Gift wrapping: No' is displayed correctly");
		Assert.assertEquals(checkoutPage.getCheckoutAttributesByClass(driver), "Gift wrapping: No");

		log.info("Checkout - Step 69: Verify Total Infor is displayed correctly");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("order-subtotal"), "Sub-Total: $3,600.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("shipping-cost"), "Shipping: (2nd Day Air) $0.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("tax-value"), "Tax: $0.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("order-total"), "Total: $3,600.00");

		log.info("Checkout - Step 70: Click to Confirm button");
		checkoutPage.clickToButtonByText(driver, "Confirm");

		log.info("Checkout - Step 71: Verify Page Title 'Thank you' is displayed correctly");
		Assert.assertTrue(productListPage.isPageTitleByTextDisplayed(driver, "page-title", "Thank you"));

		log.info("Checkout - Step 72: Verify message 'Your order has been successfully processed!' is displayed correctly");
		Assert.assertEquals(checkoutPage.getOrderCompleteMessageByClass("title"), "Your order has been successfully processed!");

		log.info("Checkout - Step 73: Verify message 'order-number' is displayed");
		Assert.assertTrue(checkoutPage.isOderNumberDisplayed("details"));

		log.info("Checkout - Step 74: Open My Customer Infor page");
		customerInforPage = checkoutPage.openMyAccountPage(driver);

		log.info("Checkout - Step 75: Open My Oders page");
		ordersPage = customerInforPage.openMyOderPage("Orders");

		log.info("Checkout - Step 76: Verify Page Title 'My account - Orders' is displayed correctly");
		Assert.assertTrue(ordersPage.isPageTitleByTextDisplayed(driver, "page-title", "My account - Orders"));

		log.info("Checkout - Step 77: Verify Order Number is displayed correctly");
		Assert.assertTrue(ordersPage.isOrderNumberDisplayed());

		log.info("Checkout - Step 78: Click to Details link");
		orderDetails = ordersPage.openOrderDetailsPage("Details");

		log.info("Checkout - Step 79: Verify Page Title 'Order information' is displayed correctly");
		Assert.assertTrue(orderDetails.isPageTitleByTextDisplayed(driver, "page-title", "Order information"));

		log.info("Checkout - Step 80: Verify Order Number is displayed correctly");
		orderDetails.isOderNumberDisplayedInDetailsPage();

		log.info("Checkout - Step 81: Verify Order Overview Content are displayed correctly");
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-date"), orderDate);
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-status"), "Order Status: Pending");
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-total"), "Order Total: $3,600.00");

		log.info("Checkout - Step 82: Verify Billing infor address");
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "name"), nameBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "email"), emailBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "phone"), phoneBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "address1"), address_bill);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "city-state-zip"), cityStateZipBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "country"), country);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "payment-method-info", "payment-method"), paymentMethodCreditCard);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "payment-method-info", "payment-method-status"), "Payment Status: Pending");

		log.info("Checkout - Step 83: Verify Shipping infor address");
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "name"), nameShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "email"), emailShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "phone"), phoneShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "address1"), address_bill);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "city-state-zip"), cityStateZipShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "country"), country);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-method-info", "shipping-method"), shippingMethod2ndDay);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-method-info", "shipping-status"), "Shipping Status: Not yet shipped");

		log.info("Checkout - Step 84: Verify SKU number is correctly");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "sku-number"), "AP_MBP_13");

		log.info("Checkout - Step 85: Verify Product Name  '" + productCheckout + "' is displayed correctly");
		Assert.assertEquals(orderDetails.getProductName(productCheckout), productCheckout);

		log.info("Checkout - Step 86: Verify Product Unit Price is equals '$1,800.00' ");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-unit-price"), "$1,800.00");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-unit-price"));

		log.info("Checkout - Step 87: Verify product qty is correctly");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-quantity"), "2");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-quantity"));

		log.info("Checkout - Step 88: Verify Product Subtotal is equals '$3,600.00' ");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-subtotal"), "$3,600.00");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-subtotal"));

		log.info("Checkout - Step 89: Verify 'Gift wrapping: No' is displayed correctly");
		Assert.assertEquals(orderDetails.getCheckoutAttributesByClass(driver), "Gift wrapping: No");

		log.info("Checkout - Step 90: Verify Total Infor is displayed correctly");
		Assert.assertEquals(orderDetails.getCartTotalInfor(), "Sub-Total: $3,600.00\nShipping: $0.00\nTax: $0.00\nOrder Total: $3,600.00");

	}

	@Test
	public void Order_07_Re_Order() {

		log.info("Checkout - Step 07: Click button Re-order");
		shoppingCartPage = orderDetails.clickToButtonByText("Re-order");

		log.info("Checkout - Step 07: Input Qty is 10");
		shoppingCartPage.inputToTextboxByClass("qty-input", "10");

		log.info("Checkout - Step 07: Click button");
		shoppingCartPage.clickToButtonByText(driver, "Update shopping cart");

		log.info("Checkout - Step 20: Open popup Estimate shipping");
		shoppingCartPage.openPopupEstimateShipping();

		log.info("Checkout - Step 21: Verify popup Estimate shipping is displayed ");
		Assert.assertTrue(shoppingCartPage.isPopupEstimateShippingDisplayed());

		log.info("Checkout - Step 22: Select Country ");
		shoppingCartPage.selectToDropdownByName(driver, "CountryId", "United States");

		log.info("Checkout - Step 23: Select State ");
		shoppingCartPage.selectToDropdownByName(driver, "StateProvinceId", "New York");

		log.info("Checkout - Step 24: Input ZipCode ");
		shoppingCartPage.inputToTextboxById(driver, "ZipPostalCode", "10019");
		shoppingCartPage.sleepInSecond(3);

		log.info("Checkout - Step 25: Verify shipping method are displayed");
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("Ground"));
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("Next Day Air"));
		Assert.assertTrue(shoppingCartPage.isShippingMethoddisplayed("2nd Day Air"));

		log.info("Checkout - Step 26: Choose shipping method is 'Next Day Air' ");
		shoppingCartPage.checkToShippingMethodByName("Next Day Air");

		log.info("Checkout - Step 27: Click Apply button");
		shoppingCartPage.clickToButtonByText(driver, "Apply");

		log.info("Checkout - Step 28: Verify popup Estimate shipping is Undisplayed");
		Assert.assertTrue(shoppingCartPage.isPopupEstimateShippingUnDisplayed());

		log.info("Checkout - Step 29: Verify shipping method 2nd Day Air is displayed");
		Assert.assertTrue(shoppingCartPage.isShippingMethodDisplayed("(Next Day Air)"));

		log.info("Checkout - Step 30: Choose checkbox 'I agree with the terms of service and I adhere to them unconditionally' ");
		shoppingCartPage.checkToCheckboxOrRadioByID(driver, "termsofservice");

		log.info("Checkout - Step 31: Open checkout page");
		checkoutPage = shoppingCartPage.openCheckoutPage("checkout");

		log.info("Checkout - Step 32: Verify Page Title 'Checkout' is displayed correctly");
		Assert.assertTrue(checkoutPage.isPageTitleByTextDisplayed(driver, "page-title", "Checkout"));

		log.info("Checkout - Step 32: Uncheck to checkbox Ship to the same address");
		checkoutPage.uncheckToCheckboxOrRadioByID(driver, "ShipToSameAddress");

		log.info("Checkout - Step 32: Select a billing address is 'new address'");
		checkoutPage.selectToDropdownByName(driver, "billing_address_id", "New Address");

		log.info("Checkout - Step 45: Input First Name");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_FirstName", firstName_bill);

		log.info("Checkout - Step 46: Input Last Name");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_LastName", lastName_bill);

		log.info("Checkout - Step 47: Input Email");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_Email", emailAddress_bill);

		log.info("Checkout - Step 36: Select Country");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", country);
		checkoutPage.sleepInSecond(1);

		log.info("Checkout - Step 37: Select State");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.StateProvinceId", state_bill);

		log.info("Checkout - Step 38: Input City");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_City", city_bill);

		log.info("Checkout - Step 39: Input Address 1");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_Address1", address_bill);

		log.info("Checkout - Step 40: Input ZipCode");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_ZipPostalCode", zipCode_bill);

		log.info("Checkout - Step 41: Input phone number");
		checkoutPage.inputToTextboxById(driver, "BillingNewAddress_PhoneNumber", phone_bill);

		log.info("Checkout - Step 42: Click to Continue button");
		checkoutPage.clickToButtonByText(driver, "Continue");

		log.info("Checkout - Step 43: Select New  shipping sddress");
		checkoutPage.selectToDropdownByName(driver, "shipping_address_id", "New Address");

		log.info("Checkout - Step 44: Verify Dropdow new addess is displayed");
		Assert.assertTrue(checkoutPage.isNewAddressDropdownDisplayed());

		log.info("Checkout - Step 45: Input First Name");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_FirstName", firstName_shipping);

		log.info("Checkout - Step 46: Input Last Name");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_LastName", lastName_shipping);

		log.info("Checkout - Step 47: Input Email");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_Email", emailAddress_shipping);

		log.info("Checkout - Step 48: Select Country");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.CountryId", country);
		checkoutPage.sleepInSecond(1);

		log.info("Checkout - Step 49: Select State");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.StateProvinceId", state_shipping);

		log.info("Checkout - Step 50: Input City");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_City", city_shipping);

		log.info("Checkout - Step 51: Input Address 1");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_Address1", address_bill);

		log.info("Checkout - Step 52: Input ZipCode");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_ZipPostalCode", zipCode_shipping);

		log.info("Checkout - Step 53: Input phone number");
		checkoutPage.inputToTextboxById(driver, "ShippingNewAddress_PhoneNumber", phone_shipping);

		log.info("Checkout - Step 54: Click to Continue button");
		checkoutPage.clickToButtonByClass("shipping", "new-address");

		log.info("Checkout - Step 55: Select to shipping method 'Next Day Air'");
		checkoutPage.checkToCheckboxOrRadioByID(driver, "shippingoption_1");

		log.info("Checkout - Step 56: Click to Continue button");
		checkoutPage.clickToButtonByClass("shipping-method", "shipping-method");

		log.info("Checkout - Step 57: Choose Payment method is Credit Card");
		checkoutPage.checkToCheckboxOrRadioByID(driver, "paymentmethod_1");

		log.info("Checkout - Step 58: Click to Continue button");
		checkoutPage.clickToButtonByClass("payment-method", "payment-method");

		log.info("Checkout - Step 58: Select credit card is visa");
		checkoutPage.selectToDropdownByName(driver, "CreditCardType", "Visa");

		log.info("Checkout - Step 58: Input Card holder name");
		checkoutPage.inputToTextboxById(driver, "CardholderName", cardName);

		log.info("Checkout - Step 58: Input Card number");
		checkoutPage.inputToTextboxById(driver, "CardNumber", visa);

		log.info("Checkout - Step 58: Select expiration month");
		checkoutPage.selectToDropdownByName(driver, "ExpireMonth", expirationMonth);

		log.info("Checkout - Step 58: Select expiration year");
		checkoutPage.selectToDropdownByName(driver, "ExpireYear", expirationYear);

		log.info("Checkout - Step 58: Input Card code");
		checkoutPage.inputToTextboxById(driver, "CardCode", cvv);
		checkoutPage.sleepInSecond(1);

		log.info("Checkout - Step 58: Click to Continue button");
		checkoutPage.clickToButtonByClass("payment-info", "payment-info");

		log.info("Checkout - Step 61: Verify Billing infor address");
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "name"), nameBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "email"), emailBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "phone"), phoneBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "address1"), address_bill);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "city-state-zip"), cityStateZipBilling);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "billing-info", "country"), country);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "payment-method-info", "payment-method"), paymentMethodCreditCard);

		log.info("Checkout - Step 62: Verify Shipping infor address");
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "name"), nameShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "email"), emailShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "phone"), phoneShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "address1"), address_bill);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "city-state-zip"), cityStateZipShipping);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-info", "country"), country);
		Assert.assertEquals(checkoutPage.getBillingInfor(driver, "shipping-method-info", "shipping-method"), shippingMethodNextDay);

		log.info("Checkout - Step 63: Verify SKU number is correctly");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "sku-number"), "AP_MBP_13");

		log.info("Checkout - Step 64: Verify Product Name  '" + productCheckout + "' is displayed correctly");
		Assert.assertTrue(checkoutPage.isProductNameDisplayed(driver, "product-name", productCheckout));

		log.info("Checkout - Step 65: Verify Product Unit Price is equals '" + unitPrice + "' ");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-unit-price"), unitPrice);
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-unit-price"));

		log.info("Checkout - Step 66: Verify product qty is correctly");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-quantity"), "10");
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-quantity"));

		log.info("Checkout - Step 67: Verify Product Subtotal is equals '" + reorderSubTotalPrice + "' ");
		Assert.assertEquals(checkoutPage.getProductInforByClass(driver, "product-subtotal"), reorderSubTotalPrice);
		System.out.println(checkoutPage.getProductInforByClass(driver, "product-subtotal"));

		log.info("Checkout - Step 68: Verify 'Gift wrapping: No' is displayed correctly");
		Assert.assertEquals(checkoutPage.getCheckoutAttributesByClass(driver), "Gift wrapping: No");

		log.info("Checkout - Step 69: Verify Total Infor is displayed correctly");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("order-subtotal"), "Sub-Total: " + reorderSubTotalPrice + "");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("shipping-cost"), "Shipping: (Next Day Air) $0.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("tax-value"), "Tax: $0.00");
		Assert.assertEquals(checkoutPage.getTotalInforByClass("order-total"), "Total: " + reorderSubTotalPrice + "");
		checkoutPage.sleepInSecond(7);

		log.info("Checkout - Step 70: Click to Confirm button");
		checkoutPage.clickToButtonByText(driver, "Confirm");

		log.info("Checkout - Step 71: Verify Page Title 'Thank you' is displayed correctly");
		Assert.assertTrue(checkoutPage.isPageTitleByTextDisplayed(driver, "page-title", "Thank you"));

		log.info("Checkout - Step 72: Verify message 'Your order has been successfully processed!' is displayed correctly");
		Assert.assertEquals(checkoutPage.getOrderCompleteMessageByClass("title"), "Your order has been successfully processed!");

		log.info("Checkout - Step 73: Verify message 'order-number' is displayed");
		Assert.assertTrue(checkoutPage.isOderNumberDisplayed("details"));

		log.info("Checkout - Step 74: Open My Customer Infor page");
		customerInforPage = checkoutPage.openMyAccountPage(driver);

		log.info("Checkout - Step 75: Open My Oders page");
		ordersPage = customerInforPage.openMyOderPage("Orders");

		log.info("Checkout - Step 76: Verify Page Title 'My account - Orders' is displayed correctly");
		Assert.assertTrue(ordersPage.isPageTitleByTextDisplayed(driver, "page-title", "My account - Orders"));

		log.info("Checkout - Step 77: Verify Order Number is displayed correctly");
		Assert.assertTrue(ordersPage.isOrderNumberDisplayed());

		log.info("Checkout - Step 78: Click to Details link");
		orderDetails = ordersPage.openOrderDetailsPage("Details");

		log.info("Checkout - Step 79: Verify Page Title 'Order information' is displayed correctly");
		Assert.assertTrue(orderDetails.isPageTitleByTextDisplayed(driver, "page-title", "Order information"));

		log.info("Checkout - Step 80: Verify Order Number is displayed correctly");
		orderDetails.isOderNumberDisplayedInDetailsPage();

		log.info("Checkout - Step 81: Verify Order Overview Content are displayed correctly");
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-date"), orderDate);
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-status"), "Order Status: Pending");
		Assert.assertEquals(orderDetails.getOrderOverviewContentByClass("order-total"), "Order Total: " + reorderSubTotalPrice + "");

		log.info("Checkout - Step 82: Verify Billing infor address");
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "name"), nameBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "email"), emailBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "phone"), phoneBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "address1"), address_bill);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "city-state-zip"), cityStateZipBilling);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "billing-info", "country"), country);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "payment-method-info", "payment-method"), paymentMethodCreditCard);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "payment-method-info", "payment-method-status"), "Payment Status: Pending");

		log.info("Checkout - Step 83: Verify Shipping infor address");
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "name"), nameShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "email"), emailShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "phone"), phoneShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "address1"), address_bill);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "city-state-zip"), cityStateZipShipping);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-info", "country"), country);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-method-info", "shipping-method"), shippingMethodNextDay);
		Assert.assertEquals(orderDetails.getBillingInfor(driver, "shipping-method-info", "shipping-status"), "Shipping Status: Not yet shipped");

		log.info("Checkout - Step 84: Verify SKU number is correctly");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "sku-number"), "AP_MBP_13");

		log.info("Checkout - Step 85: Verify Product Name  '" + productCheckout + "' is displayed correctly");
		Assert.assertEquals(orderDetails.getProductName(productCheckout), productCheckout);

		log.info("Checkout - Step 86: Verify Product Unit Price is equals '" + unitPrice + "' ");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-unit-price"), unitPrice);
		System.out.println(orderDetails.getProductInforByClass(driver, "product-unit-price"));

		log.info("Checkout - Step 87: Verify product qty is correctly");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-quantity"), "10");
		System.out.println(orderDetails.getProductInforByClass(driver, "product-quantity"));

		log.info("Checkout - Step 88: Verify Product Subtotal is equals '" + reorderSubTotalPrice + "' ");
		Assert.assertEquals(orderDetails.getProductInforByClass(driver, "product-subtotal"), reorderSubTotalPrice);
		System.out.println(orderDetails.getProductInforByClass(driver, "product-subtotal"));

		log.info("Checkout - Step 89: Verify 'Gift wrapping: No' is displayed correctly");
		Assert.assertEquals(orderDetails.getCheckoutAttributesByClass(driver), "Gift wrapping: No");

		log.info("Checkout - Step 90: Verify Total Infor is displayed correctly");
		Assert.assertEquals(orderDetails.getCartTotalInfor(), "Sub-Total: " + reorderSubTotalPrice + "\nShipping: $0.00\nTax: $0.00\nOrder Total: " + reorderSubTotalPrice + "");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowserAndDriver();
	}

	private WebDriver driver;
	String shippingMethodNextDay, reorderSubTotalPrice, unitPrice;
	String nameBilling, emailBilling, phoneBilling, cityStateZipBilling, paymentMethodMoney, paymentMethodCreditCard, shippingMethod2ndDay, productCheckout;
	String nameShipping, emailShipping, phoneShipping, cityStateZipShipping, orderDate, visa, cardName, expirationMonth, expirationYear, cvv, creditCardType, masterCard;
	String firstName_bill, lastName_bill, emailAddress_bill, password, paymentInfor, state_bill, city_bill, address_bill, zipCode_bill, phone_bill;
	String firstName_shipping, lastName_shipping, emailAddress_shipping, country, state_shipping, city_shipping, address_shipping, zipCode_shipping, phone_shipping;
	private String processer, barNotificationSucess, productName, productCount, productAttributes, productUnitPrice, productQuantity, productTotals;
	private String processerEdit, editProductUnitPrice, editProductAttributes, editProductCount, editProductQuantity, editProductTotals, editProductSubTotal, editCartProductUnitPrice;
	private UserHomePageObject homePage;
	private UserProductListPageObject productListPage;
	private UserCheckoutPageObject checkoutPage;
	private UserLoginPageObject loginPage;
	private UserProductDetailPageObject productDetailPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserOrdersPageObject ordersPage;
	private UserOrderDetailsPageObject orderDetails;

}
