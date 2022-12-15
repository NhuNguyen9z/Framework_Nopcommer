package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductReviewByTextDisplayed(String textLabel) {
		waitForElementVisible(driver, UserProductReviewPageUI.PRODUCT_REVIEW_BY_TEXT, textLabel);
		return isElementDisplayed(driver, UserProductReviewPageUI.PRODUCT_REVIEW_BY_TEXT, textLabel);
	}

	public void inputToReviewText(String productReviewText) {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXT);
		sendkeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXT, productReviewText);

	}

	public void selectRatingByText(String textLabel) {
		waitForElementClickable(driver, UserProductReviewPageUI.RATING_BY_LABEL, textLabel);
		checkToDefaultCheckboxOrRadio(driver, UserProductReviewPageUI.RATING_BY_LABEL, textLabel);

	}

	public boolean isProductReviewSuccessDisplayed() {
		waitForElementVisible(driver, UserProductReviewPageUI.PRODUCT_REVIEW_SUCCESS);
		return isElementDisplayed(driver, UserProductReviewPageUI.PRODUCT_REVIEW_SUCCESS);
	}

}
