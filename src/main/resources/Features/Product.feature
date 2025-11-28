Feature:
  Scenario:
    Given the user is on the Demoblaze home page
    When the user clicks on a product
    Then the product details page should be displayed

  Scenario: User adds product to cart from product page
    Given the user is on a product details page
    When the user clicks the "Add to cart" button
    Then the product should be successfully added to the cart
