package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {

	public static final String NEW_ADDRESS_DROPDOWN = "css=select#shipping-address-select";
	public static final String PAYMENT_INFOR = "css=div.info";
	public static final String CONTINUE_BUTTON = "xpath=//div[contains(@id,'%s')]//button[contains(@class,'%s')]";
	public static final String DYNAMIC_BILLING_INFOR = "xpath=//div[@class='%s']//li[@class='%s']";
	public static final String CHECKOUT_ATTRIBUTES = "css=div.selected-checkout-attributes";
	public static final String DYNAMIC_TOTAL_INFOR = "xpath=//tr[@class='%s']";
	public static final String ORDER_COMPLETED = "xpath=//div[contains(@class,'order-completed')]//div[@class='%s']//strong";

}
