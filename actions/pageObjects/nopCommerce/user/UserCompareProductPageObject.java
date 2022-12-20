package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserCompareProducstPageUI;

public class UserCompareProductPageObject extends BasePage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRemoveButtonDisplayed(String attributeValue) {
		waitForElementVisible(driver, UserCompareProducstPageUI.DYNAMIC_REMOVE_BUTTON, attributeValue);
		return isElementDisplayed(driver, UserCompareProducstPageUI.DYNAMIC_REMOVE_BUTTON, attributeValue);
	}

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(driver, UserCompareProducstPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayed(driver, UserCompareProducstPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public boolean isProductPriceDisplayed(String productPrice) {
		waitForElementVisible(driver, UserCompareProducstPageUI.DYNAMIC_PRODUCT_PRICE, productPrice);
		return isElementDisplayed(driver, UserCompareProducstPageUI.DYNAMIC_PRODUCT_PRICE, productPrice);
	}

	public void clickToClearListButton(String attributeValue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LINK_BY_CLASS, attributeValue);
		clickToElement(driver, BasePageUI.DYNAMIC_LINK_BY_CLASS, attributeValue);
	}

	public boolean isProductNameUnDisplayed(String productName) {
		waitForElementUndisplayed(driver, UserCompareProducstPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUndisplayed(driver, UserCompareProducstPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

}
