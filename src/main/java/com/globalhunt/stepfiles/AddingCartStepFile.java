package com.globalhunt.stepfiles;

import org.testng.Assert;

import com.globalhunt.base.Browser;
import com.globalhunt.pages.AddingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingCartStepFile {
	AddingCartPage obj;

	public AddingCartStepFile() {
		obj = new AddingCartPage();

	}

	@Given("The user is on landing page")
	public void the_user_is_on_landing_page() {
		obj.navigateToHomePage();

	}

	@When("User selects a Product Category {string}")
	public void user_selects_a_product_category(String string) {
		obj.selectCategory(string);
	}

	@When("User select a Product {string}")
	public void user_select_a_product(String string) {
		// Write code here that turns the phrase above into concrete actions
		obj.selectProduct(string);
	}

	@When("click Add to Cart button")
	public void click_add_to_cart_button() {
		// Write code here that turns the phrase above into concrete actions
		obj.clickAddToCart();
	}

	@Then("User should be presented with Confirmation Popup")
	public void user_should_be_presented_with_confirmation_popup() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(true, obj.isConfirmationPopupDisplayed());

	}

}
