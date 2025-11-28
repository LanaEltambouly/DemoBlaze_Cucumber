/*Feature:
  Scenario: Verify that multiple products are added to cart successfully
    Given user is on Home Page
    When user select a product
    And add them to cart
    Then products should appear in cart successfully

  Scenario: Verify that total price is calculated correctly
    Given user has products in cart
    When user views total price
    Then total price should be correct

  Scenario: Verify that user can place order from cart
    Given user has products in cart
    When user clicks on Place Order
    And fills payment info
    Then order should be placed successfully

  Scenario: Verify that product is deleted from cart successfully
    Given user has a product in cart
    When user deletes the product
    Then cart should show updated items

  Scenario: Verify that empty cart displays nothing
    Given user opens the cart
    When cart is empty
    Then no products should be displayed

  Scenario: Verify that empty cart disables place order button
    Given user opens the cart
    When cart is empty
    Then place order button should be disabled

  Scenario: Verify that deleting all products empties cart
    Given user has multiple products in cart
    When user deletes all products
    Then cart should be empty*/