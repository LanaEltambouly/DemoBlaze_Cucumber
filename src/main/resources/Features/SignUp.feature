Feature:
 Scenario: User signs up with valid credentials
  Given the user is on the Demoblaze home page
  When the user clicks the "Sign up" button
  And the user enters a valid username and password
  And the user clicks the "Sign up" button
  Then a success message should be displayed


  Scenario: User signs up with an already registered username
    Given the user is on the Demoblaze home page
    When the user clicks the "Sign up" button
    And the user enters an existing username
    And the user enters a password
    And the user clicks the "Sign up" button
    Then an error message should be displayed


   Scenario 3: User signs up with empty fields
     Given the user is on the Demoblaze home page
     When the user clicks the "Sign up" button
     And the user leaves all fields empty
     And the user clicks the "Sign up" button
     Then a validation message should be displayed


