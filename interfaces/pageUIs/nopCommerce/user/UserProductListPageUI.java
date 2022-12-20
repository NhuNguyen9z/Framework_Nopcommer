package pageUIs.nopCommerce.user;

public class UserProductListPageUI {
	public static final String SELECT_DROPDOWN = "xpath=//select[@id='%s']";
	public static final String PRODUCT_NAME = "xpath=//div[@class='products-container']//h2[@class='product-title']";
	public static final String PRODUCT_PRICE = "xpath=//div[@class='products-container']//div[@class='prices']/span";
	public static final String CURRENT_PAGE = "xpath=//div[@class='products-container']//div[@class='pager']//li[@class='current-page']/parent::ul//li[@class='%s']";
	public static final String INDIVIDUAL_PAGE = "xpath=//div[@class='products-container']//div[@class='pager']//li[@class='individual-page']";
	public static final String PAGING = "xpath=//div[@class='products-container']//div[@class='pager']";
	public static final String COMPARE_LIST_BUTTON = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[3]//button[contains(@class,'compare-list')]";
}
