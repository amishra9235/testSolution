Feature: Verify Demo Online Shop functionality
  			As a user, 
  				I want to Place Order for added Products in the Cart.

  Background: 
    Given The user is on landing page
    When User selects a Product Category "Laptops"
    When User select a Product "Sony vaio i5"
    And click Add to Cart button
    And User navigate to Cart page.

  @Chrome
  Scenario Outline: 
    When User click on Place Order button
    And User fill the form  "<Name>" and "<Country>" and "<City>" and "<Credit Card>" and "<Month>" and "<Year>"
    And Click Purchase button for Expected Amount
    Then user should be presented with Purchase Id and Amount equal to Expected Amount

    Examples: 
      | Name  | Country | City  | Credit Card | Month | Year |
      | Anand | India   | Noida |   123456789 | June  | 2020 |
