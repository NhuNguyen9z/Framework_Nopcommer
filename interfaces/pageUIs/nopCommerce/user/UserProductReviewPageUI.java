package pageUIs.nopCommerce.user;

public class UserProductReviewPageUI {
	public static final String PRODUCT_REVIEW_BY_TEXT = "xpath=//div[contains(@class,'product-reviews-page')]//a[text()='%s']";
	public static final String REVIEW_TEXT = "xpath=//textarea[@id='AddProductReview_ReviewText']";
	public static final String RATING_BY_LABEL = "xpath=//div[@class='rating-options']//input[@aria-label='%s']";
	public static final String PRODUCT_REVIEW_SUCCESS = "xpath=//div[@class='result' and contains(text(),'Product review is successfully added.')]";
}
