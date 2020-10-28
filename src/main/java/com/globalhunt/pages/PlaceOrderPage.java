package com.globalhunt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.globalhunt.base.BaseSetUp;
import com.globalhunt.wait.Wait;

public class PlaceOrderPage extends BaseSetUp {
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement btnPlaceOrder;

	@FindBy(xpath = "//input[@class='form-control']")
	List<WebElement> formFields;

	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement btnPurchase;

	@FindBy(id = "totalm")
	WebElement totalAmount;

	@FindBy(xpath = "//p[@class='lead text-muted ']/text()[1]")
	WebElement purchaseId;

	@FindBy(xpath = "//p[@class='lead text-muted ']/text()[2]")
	WebElement purchaseAmount;

	public void clickPlaceOrder() {
		Wait.explicitWait(driver, btnPlaceOrder, lowWaitTime);
		btnPlaceOrder.click();

	}

	public void fillPurchaseForm(String name, String Country, String City, String creditCard, String Month,
			String Year) {
		for (int i = 0; i < formFields.size(); i++) {
			if (formFields.get(i).getAttribute("id").equalsIgnoreCase("name")) {
				formFields.get(i).sendKeys(name);
			} else if (formFields.get(i).getAttribute("id").equalsIgnoreCase("country")) {
				formFields.get(i).sendKeys(Country);
			} else if (formFields.get(i).getAttribute("id").equalsIgnoreCase("city")) {
				formFields.get(i).sendKeys(City);
			} else if (formFields.get(i).getAttribute("id").equalsIgnoreCase("card")) {
				formFields.get(i).sendKeys(creditCard);
			} else if (formFields.get(i).getAttribute("id").equalsIgnoreCase("month")) {
				formFields.get(i).sendKeys(Month);
			} else if (formFields.get(i).getAttribute("id").equalsIgnoreCase("year")) {
				formFields.get(i).sendKeys(Year);
			}
		}

	}

	public void clickPurchaseButton() {
		Wait.explicitWait(driver, btnPurchase, lowWaitTime);
		btnPurchase.click();
	}

	public void getPurchaseIdAndAmount() {
		System.out.println(purchaseId.getText() + "\n");
		System.out.println(purchaseAmount.getText());

	}
}
