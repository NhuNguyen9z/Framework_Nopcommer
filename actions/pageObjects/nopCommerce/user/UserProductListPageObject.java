package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserProductListPageObject extends BasePage {
	WebDriver driver;

	public UserProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleByTextDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserProductDetailPageObject clickToProductByName(String textLabel) {
		waitForElementClickable(driver, BasePageUI.PRODUCT_NAME_BY_TEXT, textLabel);
		clickToElement(driver, BasePageUI.PRODUCT_NAME_BY_TEXT, textLabel);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

}
