package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishListPageObject extends BasePage {
	WebDriver driver;

	public UserWishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToShareLink(String attributeValue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LINK_BY_CLASS, attributeValue);
		clickToElement(driver, BasePageUI.DYNAMIC_LINK_BY_CLASS, attributeValue);
	}

	public void clickToCheckboxAddToCart(String attributeValue) {
		waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX, attributeValue);
		checkToDefaultCheckboxOrRadio(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX, attributeValue);
	}

	public UserShoppingCartPageObject clickToButtonAddToCart() {
		waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public boolean isProductNameUnDisplayed(String attributeValue, String productName) {
		waitForElementUndisplayed(driver, BasePageUI.DYNAMIC_PRODUCT_NAME, attributeValue, productName);
		return isElementUndisplayed(driver, BasePageUI.DYNAMIC_PRODUCT_NAME, attributeValue, productName);
	}

	public void clickToRemoveButton(String productName) {
		waitForElementClickable(driver, UserWishlistPageUI.REMOVE_BUTTON, productName);
		clickToElement(driver, UserWishlistPageUI.REMOVE_BUTTON, productName);
	}

}
