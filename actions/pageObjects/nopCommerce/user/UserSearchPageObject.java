package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonSearch() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isWarningSearchDisplayed() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_WARNING);
		return isElementDisplayed(driver, UserSearchPageUI.SEARCH_WARNING);
	}

	public void inputToSearchTextbox(String textValue) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, textValue);
	}

	public boolean isNoResultMessageDisplayed() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		return isElementDisplayed(driver, UserSearchPageUI.SEARCH_TEXTBOX);
	}

	public boolean isProductNameDisplayed(String textLabel) {
		waitForElementVisible(driver, UserSearchPageUI.PRODUCT_NAME_RELATIVE, textLabel);
		scrollToElement(driver, UserSearchPageUI.PRODUCT_NAME_RELATIVE, textLabel);
		return isElementDisplayed(driver, UserSearchPageUI.PRODUCT_NAME_RELATIVE, textLabel);
	}

	public void checkedSearchCheckboxByID(String atributeName) {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX, atributeName);
		checkToDefaultCheckboxOrRadio(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX, atributeName);
	}

}
