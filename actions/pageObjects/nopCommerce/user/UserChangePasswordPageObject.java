package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCloseNotificationSucess() {
		waitForElementVisible(driver, BasePageUI.BAR_NOTIFICATION_SUCCESS);
		clickToElement(driver, BasePageUI.BAR_NOTIFICATION_SUCCESS);
	}

}
