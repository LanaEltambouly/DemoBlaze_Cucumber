Feature: PlaceOrder Functionality

  Scenario: Verify place order with valid credentials
    Given user is on Place Order page
     When user enters valid data format
     And user clicks Purchase
     Then a successful palced order message should be displayed

  Scenario: Verify place order without any credentials
    Given user is on Place Order page
     When user clicks Purchase without entering fields
     Then error message should appear

  Scenario: Verify place order with wrong syntax
    Given user is on Place Order page
    When user enters invalid data format
    And user clicks Purchase
    Then error message should appear

  Scenario: Verify place order with missing fields
    Given user is on Place Order page
    When user leaves some fields empty
    And user clicks Purchase
    Then error message should appear
