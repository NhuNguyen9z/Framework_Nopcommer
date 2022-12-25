package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewPageObject clickAddYourReview() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

	public void clickToButtonAddToWishlist() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_WISHLIST);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_WISHLIST);
	}

	public UserRecentlyViewedProductsPageObject openRecentlyViewedProductsPage(String dynamicValues) {
		waitForElementClickable(driver, BasePageUI.FOOTER_LINK_BY_TEXT, dynamicValues);
		clickToElement(driver, BasePageUI.FOOTER_LINK_BY_TEXT, dynamicValues);
		return PageGeneratorManager.getUserRecentlyViewedProductsPage(driver);
	}

	public void hoverToShoppingCartLink(String attributeValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LINK_BY_CLASS, attributeValue);
		hoverMouse(driver, BasePageUI.DYNAMIC_LINK_BY_CLASS, attributeValue);

	}

	public String getProductInfoCartByClass(String attributeValue) {
		waitForElementVisible(driver, UserProductDetailPageUI.DYNAMIC_PRODUCT_INFOR, attributeValue);
		return getElementText(driver, UserProductDetailPageUI.DYNAMIC_PRODUCT_INFOR, attributeValue);
	}

	public UserShoppingCartPageObject openShoppingCartPage(String dynamicValues) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, dynamicValues);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, dynamicValues);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public String getProductUnitPrice() {
		waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_UINIT_PRICE);
		return getElementText(driver, UserProductDetailPageUI.PRODUCT_UINIT_PRICE);
	}
}
