Feature: Verify Demo Online Shop functionality
  			As a user, 
  				I want to add new Products in the Cart.

  Background: 
    Given The user is on landing page

  @Chrome
  Scenario Outline: Adding to Sony vaio i5 laptop to cart
    When User selects a Product Category "<Product Category>"
    When User select a Product "<Product Name>"
    And click Add to Cart button
    Then User should be presented with Confirmation Popup

    Examples: 
      | Product Category | Product Name |
      | Laptops          | Sony vaio i5 |

  @Chrome
  Scenario Outline: Adding to Dell i7 8gb laptop to cart
    When User selects a Product Category "<Product Category>"
    When User select a Product "<Product Name>"
    And click Add to Cart button
    Then User should be presented with Confirmation Popup

    Examples: 
      | Product Category | Product Name |
      | Laptops          | Dell i7 8gb  |
