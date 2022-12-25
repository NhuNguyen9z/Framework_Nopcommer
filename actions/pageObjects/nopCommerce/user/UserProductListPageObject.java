package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserProductListPageUI;

public class UserProductListPageObject extends BasePage {
	WebDriver driver;

	public UserProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleByTextDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserProductDetailPageObject openProductDetailPage(String textLabel) {
		waitForElementClickable(driver, BasePageUI.PRODUCT_NAME_LIST_BY_TEXT, textLabel);
		clickToElement(driver, BasePageUI.PRODUCT_NAME_LIST_BY_TEXT, textLabel);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void selectItemInSortByID(String attributeValue, String textItem) {
		waitForElementClickable(driver, UserProductListPageUI.SELECT_DROPDOWN, attributeValue);
		selectItemInDefaultDropdown(driver, UserProductListPageUI.SELECT_DROPDOWN, textItem, attributeValue);
	}

	public boolean isProductNameSortByAscending() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME);
		for (WebElement element : elements) {
			productNameUI.add(element.getText());
			System.out.println("Product Name  = " + element.getText());
		}

		ArrayList<String> sortProduct = new ArrayList<String>();
		for (String product : productNameUI) {
			sortProduct.add(product);
			System.out.println("Product Name copy = " + product);
		}
		Collections.sort(sortProduct);
		for (String name : sortProduct) {
			System.out.println("Product Name Sort ASC = " + name);
		}

		return sortProduct.equals(productNameUI);
	}

	public boolean isProductNameSortByDescending() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME);
		for (WebElement element : elements) {
			productNameUI.add(element.getText());
			System.out.println("Product Name  = " + element.getText());
		}
		ArrayList<String> sortProduct = new ArrayList<String>();
		for (String name : productNameUI) {
			sortProduct.add(name);
			System.out.println("Product Name copy = " + name);
		}
		Collections.sort(sortProduct);
		for (String name : sortProduct) {
			System.out.println("Product Name Sort ASC = " + name);
		}

		Collections.reverse(sortProduct);
		for (String name : sortProduct) {
			System.out.println("Product Name Sort DESC = " + name);
		}

		return sortProduct.equals(productNameUI);
	}

	public boolean isProductPriceSortByAscending() {
		String number = "";
		ArrayList<Float> productPriceUI = new ArrayList<Float>();
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_PRICE);
		for (WebElement element : elements) {
			number = element.getText().substring(1);
			productPriceUI.add(Float.parseFloat(number.replace(",", "")));
			System.out.println("Product Price  = " + element.getText());
		}

		ArrayList<Float> sortPrice = new ArrayList<Float>();
		for (Float price : productPriceUI) {
			sortPrice.add(price);
			System.out.println("Product Price copy = " + price);
		}
		Collections.sort(sortPrice);
		for (Float price : sortPrice) {
			System.out.println("Product Price Sort ASC = " + price);
		}

		return sortPrice.equals(productPriceUI);
	}

	public boolean isProductPriceSortByDescending() {
		String number = "";
		ArrayList<Float> productPriceUI = new ArrayList<Float>();
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_PRICE);
		for (WebElement element : elements) {
			number = element.getText().replace("$", "");
			productPriceUI.add(Float.parseFloat(number.replace(",", "")));
			System.out.println("Product Price = " + element.getText());
		}

		ArrayList<Float> sortPrice = new ArrayList<Float>();
		for (Float price : productPriceUI) {
			sortPrice.add(price);
			System.out.println("Product Price copy = " + price);
		}
		Collections.sort(sortPrice);
		for (Float price : sortPrice) {
			System.out.println("Product Price Sort ASC = " + price);
		}

		Collections.reverse(sortPrice);
		for (Float price : sortPrice) {
			System.out.println("Product Name Sort DESC = " + price);
		}

		return sortPrice.equals(productPriceUI);
	}

	public boolean isProductDisplay3PerPage() {
		waitForAllElementVisible(driver, UserProductListPageUI.PRODUCT_NAME);
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME);
		if (elements.size() <= 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isProductDisplay6PerPage() {
		waitForAllElementVisible(driver, UserProductListPageUI.PRODUCT_NAME);
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME);
		if (elements.size() <= 6) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isProductDisplay9PerPage() {
		waitForAllElementVisible(driver, UserProductListPageUI.PRODUCT_NAME);
		List<WebElement> elements = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME);
		if (elements.size() <= 9) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPagingDisplayedByClass(String attributeValue) {
		waitForElementVisible(driver, UserProductListPageUI.CURRENT_PAGE, attributeValue);
		return isElementDisplayed(driver, UserProductListPageUI.CURRENT_PAGE, attributeValue);
	}

	public void clickToIndividualPage() {
		waitForElementClickable(driver, UserProductListPageUI.INDIVIDUAL_PAGE);
		clickToElement(driver, UserProductListPageUI.INDIVIDUAL_PAGE);
	}

	public boolean isPagingUnDisplayed() {
		waitForElementUndisplayed(driver, UserProductListPageUI.PAGING);
		return isElementUndisplayed(driver, UserProductListPageUI.PAGING);
	}

	public void addProductToCompare(String productName) {
		waitForElementClickable(driver, UserProductListPageUI.COMPARE_LIST_BUTTON, productName);
		clickToElement(driver, UserProductListPageUI.COMPARE_LIST_BUTTON, productName);
	}

	public UserCompareProductPageObject openCompareProductPage(String attributeValue) {
		waitForElementClickable(driver, BasePageUI.FOOTER_LINK_BY_TEXT, attributeValue);
		clickToElement(driver, BasePageUI.FOOTER_LINK_BY_TEXT, attributeValue);
		return PageGeneratorManager.getCompareProductsPage(driver);
	}

}
