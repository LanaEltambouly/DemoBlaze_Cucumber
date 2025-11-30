Feature: Cart Functionality
  Scenario: Verify empty cart displays nothing
    Given user is on Home Page with no any products added  to the cart
    When the user navigates to the cart page
    Then the cart should display no products
    And the number of items should be 0

  Scenario: Verify multiple products are added to the cart successfully
    Given  user is on Home Page
    When the user adds multiple products to the cart
    And the user navigates to the cart page
    Then all items should be displayed in the cart
    And each item should have a visible image
    And each item should have a correct title
    And each item should have a correct price

  Scenario: Verify the correct total price
    Given the user has products added to the cart
    When the user opens the cart page
    Then the total price should equal the sum of all product prices

  Scenario: Verify deleting a product decreases the number of cart items
    Given the user has multiple products in the cart
    When the user deletes a product from the cart
    Then the number of products in the cart should decrease by 1


  Scenario: Verify place order statement appears correctly
    Given the user is on the cart page with products added
    When the user clicks the Place Order button
    Then the place order popup should appear
    And the popup title text should match the expected statement


  Scenario: Verify deleting all products results in an empty cart
    Given the user has multiple products in the cart
    When the user deletes all products from the cart
    Then the cart should be empty
    And the Place Order button should be disabled



