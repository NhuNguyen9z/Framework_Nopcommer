package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewPageObject clickAddYourReview() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

}
