Feature: Cart Functionality

  Scenario: Verify multiple products are added to the cart successfully
    Given  user is on Home Page
    When the user adds multiple products to the cart
    And the user navigates to the cart page
    Then all items should be displayed in the cart
    And each item should have a visible image
    And each item should have a correct title
    And each item should have a correct price

  Scenario: Verify the correct total price
    Given  user is on Home Page
    When the user adds multiple products to the cart
    And the user navigates to the cart page
    Then the total price should equal the sum of all product prices

  Scenario: Verify deleting a product decreases the number of cart items
    Given  user is on Home Page
    When the user adds multiple products to the cart
    And the user navigates to the cart page
    When the user deletes a product from the cart
    Then the number of products in the cart should decrease by one


  Scenario: Verify place order statement appears correctly
    Given  user is on Home Page
    When the user adds multiple products to the cart
    And the user navigates to the cart page
    When the user clicks the Place Order button
    Then the place order popup should appear



  Scenario: Verify deleting all products results in an empty cart
    Given  user is on Home Page
    When the user adds multiple products to the cart
    And the user navigates to the cart page
    When the user deletes all products from the cart
    Then the cart should display no products
    And the Place Order button should be disabled

  Scenario: Verify empty cart displays nothing
    Given  user is on Home Page
    When the user navigates to the cart with no products added
    Then the cart should display no products
    And the Place Order button should be disabled




