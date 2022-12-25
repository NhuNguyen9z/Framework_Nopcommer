package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductAttributes() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_ATTRIBUTES);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_ATTRIBUTES);
	}

	public UserProductDetailPageObject openEditProductPage() {
		waitForElementVisible(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void clickToRemoveButton() {
		waitForElementVisible(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
	}

	public String getEmtyMessage() {
		waitForElementVisible(driver, BasePageUI.EMPTY_MESSAGE);
		return getElementText(driver, BasePageUI.EMPTY_MESSAGE);
	}

	public boolean isProductNameUnDisplayed(String atributeValue, String productName) {
		waitForElementUndisplayed(driver, BasePageUI.DYNAMIC_PRODUCT_NAME, atributeValue, productName);
		return isElementUndisplayed(driver, BasePageUI.DYNAMIC_PRODUCT_NAME, atributeValue, productName);
	}

	public void openPopupEstimateShipping() {
		waitForElementVisible(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
	}

	public boolean isPopupEstimateShippingDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_POPUP);
		return isElementDisplayed(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_POPUP);
	}

	public boolean isShippingMethoddisplayed(String methodName) {
		waitForElementVisible(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_METHOD, methodName);
		return isElementDisplayed(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_METHOD, methodName);
	}

	public void checkToShippingMethodByName(String methodName) {
		waitForElementVisible(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_METHOD, methodName);
		checkToDefaultCheckboxOrRadio(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_METHOD, methodName);
	}

	public boolean isPopupEstimateShippingUnDisplayed() {
		waitForElementUndisplayed(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_POPUP);
		return isElementUndisplayed(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_POPUP);
	}

	public UserCheckoutPageObject openCheckoutPage(String dynamicValues) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_ID, dynamicValues);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_ID, dynamicValues);
		return PageGeneratorManager.getUserCheckoutPage(driver);
	}

	public boolean isShippingMethodDisplayed(String dynamicValues) {
		waitForElementVisible(driver, UserShoppingCartPageUI.SHIPPING_METHOD, dynamicValues);
		return isElementDisplayed(driver, UserShoppingCartPageUI.SHIPPING_METHOD, dynamicValues);
	}

	public void inputToTextboxByClass(String atributeValue, String textValue) {
		waitForElementVisible(driver, UserShoppingCartPageUI.DYNAMIC_TEXTBOX_BY_CLASS, atributeValue);
		sendkeyToElement(driver, UserShoppingCartPageUI.DYNAMIC_TEXTBOX_BY_CLASS, textValue, atributeValue);

	}

}
