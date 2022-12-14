package pageUIs.nopCommerce.user;

public class UserProductDetailPageUI {
	public static final String BAR_NOTIFICATION_CLOSE = "xpath=//div[@id='bar-notification']//span[@class='close']";
	public static final String ADD_YOUR_REVIEW = "xpath=//div[@class='product-review-links']//a[text()='Add your review']";
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//div[@class='product-name']/h1[text()='%s']";
	public static final String ADD_TO_WISHLIST = "xpath=//div[@class='add-to-wishlist']";
	public static final String SUB_MENU = "xpath=//ul[contains(@class,'notmobile')]//a[contains(text(),'%s')]/parent::li//a[contains(text(),'%s')]";
	public static final String DYNAMIC_PRODUCT_INFOR = "xpath=//div[@class='mini-shopping-cart']//div[@class='%s']";
	public static final String SHOPPING_CART_QTY = "xpath=//a[@class='ico-cart']//span[@class='cart-qty' and text()='%s']";
	public static final String PRODUCT_UINIT_PRICE = "css=div.product-price>span";

}
