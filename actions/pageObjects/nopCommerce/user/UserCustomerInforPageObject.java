package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserCustomerInforPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public UserOrdersPageObject openMyOderPage(String dynamicValues) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA, dynamicValues);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA, dynamicValues);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}

}
