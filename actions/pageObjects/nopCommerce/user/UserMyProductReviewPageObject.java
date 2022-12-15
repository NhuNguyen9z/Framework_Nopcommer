package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyProductReviewPagePageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReviewTitleByTextDisplayed(String textLabel) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE, textLabel);
		return isElementDisplayed(driver, UserMyProductReviewPageUI.REVIEW_TITLE, textLabel);
	}

	public boolean isReviewTextByTextDisplayed(String textLabel) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT, textLabel);
		return isElementDisplayed(driver, UserMyProductReviewPageUI.REVIEW_TEXT, textLabel);
	}

	public boolean isProductTitleByTextDisplayed(String reviewText, String textLabel) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.PRODUCT_NAME, reviewText, textLabel);
		return isElementDisplayed(driver, UserMyProductReviewPageUI.PRODUCT_NAME, reviewText, textLabel);
	}

	public boolean isRatingDisplayed(String reviewTitle, String textLabel) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.RATING, reviewTitle, textLabel);
		return isElementDisplayed(driver, UserMyProductReviewPageUI.RATING, reviewTitle, textLabel);
	}

}
