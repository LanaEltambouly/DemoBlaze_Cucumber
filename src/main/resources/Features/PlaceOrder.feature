Feature:

  Scenario: Verify place order with valid credentials
    Given user filled place order form correctly
    When user clicks Purchase
    Then order should be completed

  Scenario: Verify place order without any credentials
    Given user is on Place Order Page
    When user clicks Purchase without entering fields
    Then error should appear

  Scenario: Verify place order with wrong syntax
    Given user is on Place Order Page
    When user enters invalid data format
    And clicks Purchase
    Then error should appear

  Scenario: Verify place order with missing fields
    Given user is on Place Order Page
    When user leaves some fields empty
    And clicks Purchase
    Then error should appear
