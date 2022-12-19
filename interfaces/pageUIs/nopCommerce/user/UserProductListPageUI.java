package pageUIs.nopCommerce.user;

public class UserProductListPageUI {
	public static final String SELECT_DROPDOWN = "xpath=//select[@id='%s']";
	public static final String PRODUCT_NAME = "xpath=//div[@class='products-container']//h2[@class='product-title']";
	public static final String PRODUCT_PRICE = "xpath=//div[@class='products-container']//div[@class='prices']/span";
	public static final String CURRENT_PAGE = "xpath=//div[@class='products-container']//div[@class='pager']//li[@class='current-page']/parent::ul//li[@class='%s']";
	public static final String INDIVIDUAL_PAGE = "xpath=//div[@class='products-container']//div[@class='pager']//li[@class='individual-page']";
	public static final String PAGING = "xpath=//div[@class='products-container']//div[@class='pager']";
}
