package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueTextboxById(String dynamicValues) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, dynamicValues);
		return getElementValueByJSXpath(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, dynamicValues);
	}

	public boolean isNewAddressDropdownDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.NEW_ADDRESS_DROPDOWN);
		return isElementDisplayed(driver, UserCheckoutPageUI.NEW_ADDRESS_DROPDOWN);
	}

	public String getPaymentInfor() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_INFOR);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_INFOR);

	}

	public void clickToButtonByClass(String attributeValue, String dynamicValues) {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON, attributeValue, dynamicValues);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON, attributeValue, dynamicValues);

	}

	public String getTotalInforByClass(String dynamicValues) {
		waitForElementVisible(driver, UserCheckoutPageUI.DYNAMIC_TOTAL_INFOR, dynamicValues);
		return getElementText(driver, UserCheckoutPageUI.DYNAMIC_TOTAL_INFOR, dynamicValues);
	}

	public String getOrderCompleteMessageByClass(String dynamicValues) {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_COMPLETED, dynamicValues);
		return getElementText(driver, UserCheckoutPageUI.ORDER_COMPLETED, dynamicValues);
	}

	public boolean isOderNumberDisplayed(String dynamicValues) {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_COMPLETED, dynamicValues);
		return isElementDisplayed(driver, UserCheckoutPageUI.ORDER_COMPLETED, dynamicValues);
	}

}
