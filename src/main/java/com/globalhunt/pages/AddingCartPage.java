package com.globalhunt.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globalhunt.base.BaseSetUp;
import com.globalhunt.base.Browser;
import com.globalhunt.wait.Wait;

public class AddingCartPage extends BaseSetUp {

	public AddingCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='itemc' and text()='Phones']")
	WebElement Phonecategory;
	@FindBy(xpath = "//a[@id='itemc' and text()='Laptops']")
	WebElement Laptopscategory;
	@FindBy(xpath = "//a[@id='itemc' and text()='Monitors']")
	WebElement Monitorscategories;
	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement btnAddToCart;

	public void navigateToHomePage() {
		driver.get(url);
	}

	public void selectCategory(String category)

	{
		System.out.println(category);
		if (category.equalsIgnoreCase(Phonecategory.getText())) {
			Phonecategory.click();
		} else if (category.equalsIgnoreCase(Laptopscategory.getText())) {
			Laptopscategory.click();
		} else if (category.equalsIgnoreCase(Monitorscategories.getText())) {
			Monitorscategories.click();
		}

	}

	public void selectProduct(String productName)

	{

		Wait.explicitWait(driver, By.linkText(productName), lowWaitTime);
		WebElement selectedProduct = driver.findElement(By.linkText(productName));
		selectedProduct.click();
	}

	public void clickAddToCart() {
		Wait.explicitWait(driver, btnAddToCart, lowWaitTime);
		btnAddToCart.click();
	}

	public boolean isConfirmationPopupDisplayed() {
		Alert productAlert = Wait.waitForAlert(driver, lowWaitTime);

		if (productAlert.getText().equalsIgnoreCase("Product added")) {
			return true;
		} else
			return false;

	}

}
