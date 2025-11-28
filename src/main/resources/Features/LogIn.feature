Feature: LogIn Functionality
  Scenario : verify that user logs in when entering valid credentials
    Given the user is on the Demoblaze home page
    When the user clicks the Log in button
    And the user enters valid login credentials and the user clicks the Log in button
    Then the user should be successfully logged in

   Scenario : verify that user logs in with invalid credentials
      Given the user is on the Demoblaze home page
      When the user clicks the Log in button
      And the user enters invalid credentials and the user clicks the Log in button
      Then an error message should be displayed

   Scenario : verify that user logs in with empty fields
      Given the user is on the Demoblaze home page
      When the user clicks the Log in button
      And the user does not enter any credentials and the user clicks the Log in button
      Then a validation error should be displayed



