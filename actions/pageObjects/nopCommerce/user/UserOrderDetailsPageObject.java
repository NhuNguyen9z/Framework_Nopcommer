package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserOrderDetailsPageUI;

public class UserOrderDetailsPageObject extends BasePage {
	WebDriver driver;

	public UserOrderDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void isOderNumberDisplayedInDetailsPage() {
		waitForElementVisible(driver, UserOrderDetailsPageUI.ODER_NUMBER);
		isElementDisplayed(driver, UserOrderDetailsPageUI.ODER_NUMBER);
	}

	public String getOrderOverviewContentByClass(String dynamicValues) {
		waitForElementVisible(driver, UserOrderDetailsPageUI.DYNAMIC_ORDER_OVERVIEW, dynamicValues);
		return getElementText(driver, UserOrderDetailsPageUI.DYNAMIC_ORDER_OVERVIEW, dynamicValues);
	}

	public String getCartTotalInfor() {
		waitForElementVisible(driver, UserOrderDetailsPageUI.CART_TOTAL_INFOR);
		return getElementText(driver, UserOrderDetailsPageUI.CART_TOTAL_INFOR);
	}

	public String getProductName(String dynamicValues) {
		waitForElementVisible(driver, UserOrderDetailsPageUI.DYNAMIC_PRODUCT_NAME, dynamicValues);
		return getElementText(driver, UserOrderDetailsPageUI.DYNAMIC_PRODUCT_NAME, dynamicValues);
	}

	public UserShoppingCartPageObject clickToButtonByText(String dynamicValues) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, dynamicValues);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, dynamicValues);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

}
