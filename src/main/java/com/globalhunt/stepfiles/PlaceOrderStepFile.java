package com.globalhunt.stepfiles;

import java.util.List;
import java.util.Map;

import com.globalhunt.pages.AddingCartPage;
import com.globalhunt.pages.PlaceOrderPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderStepFile {
	PlaceOrderPage obj;

	public PlaceOrderStepFile() {
		obj = new PlaceOrderPage();

	}

	@When("User click on Place Order button")
	public void user_click_on_place_order_button() {
		obj.clickPlaceOrder();
	}

	@When("User fill the form  {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_fill_the_form_and_and_and_and_and(String string, String string2, String string3, String string4,
			String string5, String string6) {
		obj.fillPurchaseForm(string, string2, string3, string4, string5, string6);
	}

	@When("Click Purchase button for Expected Amount")
	public void click_purchase_button_for_expected_amount() {
		obj.clickPurchaseButton();
	}

	@Then("user should be presented with Purchase Id and Amount equal to Expected Amount")
	public void user_should_be_presented_with_purchase_id_and_amount_equal_to_expected_amount() {
		obj.getPurchaseIdAndAmount();
	}

}
