Feature: LogInFunctionality
  Scenario: verify that user logs in when entering valid credentials
    Given user is on Home Page
    When the user clicks the Log in Page
    And the user enters valid login credentials
    And  the user clicks the Log in button
    Then the user should be successfully logged in

   Scenario: verify that user logs in with invalid credentials
      Given user is on Home Page
      When the user clicks the Log in Page
      And the user enters invalid credentials
      And the user clicks the Log in button
      Then An error message should be displayed

   Scenario: verify that user logs in with empty fields
      Given user is on Home Page
      When the user clicks the Log in Page
      And the user does not enter any credentials
      And the user clicks the Log in button
      Then a validation error should be displayed



