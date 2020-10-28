Feature: Verify Demo Online Shop functionality
  			As a user, 
  				I want to delete added Products in the Cart.

  Background: 
    Given The user is on landing page
    When User selects a Product Category "Laptops"
    When User select a Product "Dell i7 8gb"
    And click Add to Cart button
    And User navigate to Cart page.

  @Chrome
  Scenario Outline: 
    When User click Delete button for "<Product Name>"
    Then Product should be removed from Cart "<Product Name>"

    Examples: 
      | Product Name |
      | Dell i7 8gb  |
