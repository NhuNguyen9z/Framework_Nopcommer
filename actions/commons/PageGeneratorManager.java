package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserCompareProductPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserEditProductPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrderDetailsPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserProductCategoryPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserProductListPageObject;
import pageObjects.nopCommerce.user.UserProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRecentlyViewedProductsPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishListPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {

		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {

		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {

		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInforPageObject getCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserAddressPageObject getAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver); // khi khởi tạo xong thì sẽ trả về 1 Object của class này
	}

	public static UserRewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static UserMyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static AdminLoginPageObject getAminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static UserProductListPageObject getUserProductListPage(WebDriver driver) {

		return new UserProductListPageObject(driver);
	}

	public static UserProductDetailPageObject getUserProductDetailPage(WebDriver driver) {

		return new UserProductDetailPageObject(driver);
	}

	public static UserProductCategoryPageObject getUserProductCategoryPage(WebDriver driver) {
		return new UserProductCategoryPageObject(driver);
	}

	public static UserProductReviewPageObject getUserProductReviewPage(WebDriver driver) {

		return new UserProductReviewPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

	public static UserWishListPageObject getUserWishListPage(WebDriver driver) {

		return new UserWishListPageObject(driver);
	}

	public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver) {

		return new UserShoppingCartPageObject(driver);
	}

	public static UserCompareProductPageObject getCompareProductsPage(WebDriver driver) {

		return new UserCompareProductPageObject(driver);
	}

	public static UserRecentlyViewedProductsPageObject getUserRecentlyViewedProductsPage(WebDriver driver) {

		return new UserRecentlyViewedProductsPageObject(driver);
	}

	public static UserEditProductPageObject getUserEditProductPage(WebDriver driver) {

		return new UserEditProductPageObject(driver);
	}

	public static UserCheckoutPageObject getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserOrderDetailsPageObject getUserOrderDetails(WebDriver driver) {
		return new UserOrderDetailsPageObject(driver);
	}
}
