package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserOrdersPageUI;

public class UserOrdersPageObject extends BasePage {
	WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOrderNumberDisplayed() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_NUMBER);
		return isElementDisplayed(driver, UserOrdersPageUI.ORDER_NUMBER);
	}

	public UserOrderDetailsPageObject openOrderDetailsPage(String dynamicValues) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, dynamicValues);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, dynamicValues);
		return PageGeneratorManager.getUserOrderDetails(driver);
	}

}
