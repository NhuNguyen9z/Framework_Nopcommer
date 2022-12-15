package pageUIs.nopCommerce.user;

public class UserMyProductReviewPageUI {
	public static final String REVIEW_TITLE = "xpath=//div[@class='review-title']/strong[text()='%s']";
	public static final String REVIEW_TEXT = "xpath=//div[@class='review-text' and text()='%s']";
	public static final String PRODUCT_NAME = "xpath=//div[@class='review-text' and text()='%s']/following-sibling::div//a[text()='%s']";
	public static final String RATING = "xpath=//div[@class='review-title']/strong[text()='%s']/parent::div/following-sibling::div//div[contains(@style,'%s')]";
}
