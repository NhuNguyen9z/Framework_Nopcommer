package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserProductCategoryPageObject extends BasePage {
	WebDriver driver;

	public UserProductCategoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductListPageObject clickToCategoryByName(String textLabel) {
		waitForElementClickable(driver, BasePageUI.PRODUCT_CATEGORY_BY_TEXT, textLabel);
		clickToElement(driver, BasePageUI.PRODUCT_CATEGORY_BY_TEXT, textLabel);
		return PageGeneratorManager.getUserProductListPage(driver);
	}

}
