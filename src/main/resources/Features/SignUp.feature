Feature: SigUp Functionality
 Scenario: User signs up with valid credentials
   Given user is on Home Page
  When the user clicks the Sign up Page
  And the user enters a valid username and password
  And the user clicks the Sign up button
  Then a success message should be displayed


  Scenario: User signs up with an already registered username
    Given user is on Home Page
    When the user clicks the Sign up Page
    And the user enters an existing username
    And the user enters a password
    And the user clicks the Sign up button
    Then an error message should be displayed


   Scenario: User signs up with empty fields
     Given user is on Home Page
     When the user clicks the Sign up Page
     And the user leaves all fields empty
     And the user clicks the Sign up button
     Then a validation message should be displayed


