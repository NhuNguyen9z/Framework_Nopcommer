package pageUIs.nopCommerce.user;

public class UserShoppingCartPageUI {

	public static final String PRODUCT_ATTRIBUTES = "xpath=//div[@class='order-summary-content']//div[@class='attributes']";
	public static final String EDIT_LINK = "xpath=//div[@class='edit-item']/a";
	public static final String DYNAMIC_PRODUCT_INFOR = "xpath=//span[@class='%s']";
	public static final String REMOVE_BUTTON = "css=button.remove-btn";
	public static final String ESTIMATE_SHIPPING_BUTTON = "css=a#open-estimate-shipping-popup";
	public static final String ESTIMATE_SHIPPING_POPUP = "css=div#estimate-shipping-popup";
	public static final String ESTIMATE_SHIPPING_METHOD = "xpath=//div[contains(@class,'shipping-item') and text()='%s']";
	public static final String SHIPPING_METHOD = "xpath=//tr[@class='shipping-cost']//span[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_CLASS = "xpath=//input[@class='%s']";

}
