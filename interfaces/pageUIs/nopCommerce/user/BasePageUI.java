package pageUIs.nopCommerce.user;

public class BasePageUI {
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String DYNAMIC_PAGES_NAME_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String ICON_HEADER_DISPLAYED = "xpath=//div[@id='navbarText']//i[contains(@class,'fa-cogs')]";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String DYNAMIC_LINK_BY_CLASS = "xpath=//a[@class='%s']";

	// Pattern Object
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_TEXT = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_DROPDOWN_VALUE = "xpath=//select[@name='%s']/option[text()='%s']";
	public static final String DYNAMIC_RADIO_VALUE_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";

	public static final String DYNAMIC_PRODUCT_NAME = "xpath=//div[@class='%s']/h1[text()='%s']";
	public static final String HEADER_MENU_BY_TEXT = "xpath=//ul[contains(@class,'notmobile')]//a[contains(text(),'%s')]";
	public static final String PRODUCT_CATEGORY_BY_TEXT = "xpath=//div[@class='sub-category-item']//a[contains(text(),'%s')]";
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//div[@class='products-container']//div[@class='item-box']//a[text()='%s']";

	public static final String BAR_NOTIFICATION_SUCCESS = "xpath=//div[contains(@class,'success')]//span";

	public static final String FOOTER_LINK_BY_TEXT = "xpath=//div[@class='footer']//a[text()='%s']";

	public static final String BAR_NOTIFICATION_CONTENT = "xpath=//div[@id='bar-notification']//p";
	public static final String EMPTY_MESSAGE = "xpath=//div[@class='no-data']";

}
