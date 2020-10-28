package com.globalhunt.pages;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globalhunt.base.BaseSetUp;
import com.globalhunt.wait.Wait;

public class DeletingCartPage extends BaseSetUp {

	public DeletingCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Cart']")
	WebElement btnCart;
	@FindBy(xpath = "//a[text()='Delete']")
	WebElement lnkDelete;
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement btnPlaceOrder;
	@FindBy(xpath = "//tbody/tr/td[text()='Dell i7 8gb']")
	List<WebElement> productNames;

	public void navigateToCart() {
		Wait.explicitWait(driver, btnCart, lowWaitTime);
		btnCart.click();
	}

	public void deleteProduct(String ProductName) {
		Wait.explicitWait(driver, btnPlaceOrder, lowWaitTime);
		lnkDelete.click();

	}

	public boolean isProductRemoved(String productName) {
		Wait.explicitWait(driver, btnPlaceOrder, lowWaitTime);
		if (productNames.size() == 0) {
			return true;
		} else
			return false;

	}

}
