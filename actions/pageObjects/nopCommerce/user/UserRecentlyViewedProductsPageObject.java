package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRecentlyViewedProductsPageUI;

public class UserRecentlyViewedProductsPageObject extends BasePage {
	WebDriver driver;

	public UserRecentlyViewedProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductTitletDisplayed(String attributeValue, String productName) {
		waitForElementVisible(driver, UserRecentlyViewedProductsPageUI.DYNAMIC_PRODUCT_TITLE, attributeValue, productName);
		return isElementDisplayed(driver, UserRecentlyViewedProductsPageUI.DYNAMIC_PRODUCT_TITLE, attributeValue, productName);
	}

}
