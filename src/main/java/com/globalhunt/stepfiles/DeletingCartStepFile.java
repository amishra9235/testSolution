package com.globalhunt.stepfiles;

import org.testng.Assert;

import com.globalhunt.pages.AddingCartPage;
import com.globalhunt.pages.DeletingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeletingCartStepFile {

	AddingCartPage obj;
	DeletingCartPage deleteObj;

	public DeletingCartStepFile() {
		obj = new AddingCartPage();
		deleteObj = new DeletingCartPage();

	}

	@Given("User navigate to Cart page.")
	public void user_navigate_to_cart_page() throws InterruptedException {

		deleteObj.navigateToCart();
		// added wait for page to reload
		Thread.sleep(10000);
	}

	@When("User click Delete button for {string}")
	public void user_click_delete_button_for(String string) throws InterruptedException {
		deleteObj.deleteProduct(string);
		// added wait for page to reload
		Thread.sleep(10000);
	}

	@Then("Product should be removed from Cart {string}")
	public void product_should_be_removed_from_cart(String string) {
		Assert.assertEquals(true, deleteObj.isProductRemoved(string));
	}
}
