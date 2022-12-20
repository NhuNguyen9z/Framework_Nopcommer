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

	public void hoverToHeaderMenu(String dynamicValues) {
		waitForElementVisible(driver, BasePageUI.HEADER_MENU_BY_TEXT, dynamicValues);
		hoverMouse(driver, BasePageUI.HEADER_MENU_BY_TEXT, dynamicValues);

	}

	public UserProductListPageObject clickToSubMenu(String dynamicValues, String textLabel) {
		clickToElement(driver, UserProductDetailPageUI.SUB_MENU, dynamicValues, textLabel);
		return PageGeneratorManager.getUserProductListPage(driver);
	}

	public UserRecentlyViewedProductsPageObject openRecentlyViewedProductsPage(String dynamicValues) {
		waitForElementClickable(driver, BasePageUI.FOOTER_LINK_BY_TEXT, dynamicValues);
		clickToElement(driver, BasePageUI.FOOTER_LINK_BY_TEXT, dynamicValues);
		return PageGeneratorManager.getUserRecentlyViewedProductsPage(driver);
	}

}
