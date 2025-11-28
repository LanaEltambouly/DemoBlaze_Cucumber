Feature:
  Scenario: User sends a contact message
    Given the user is on the Demoblaze home page
    When the user clicks the Contact link
    And the user enters name, email, and message
    And the user clicks the Send message button
    Then a confirmation message should be displayed

  Scenario: Verify Contact form error when name is missing
    Given user is on Contact Page
    When user enters email and message only
    And clicks Send message
    Then error alert should appear

  Scenario: Verify Contact form error when email is missing
    Given user is on Contact Page
    When user enters name and message only
    And clicks Send message
    Then error alert should appear

  Scenario: Verify Contact form error when name and email are both empty
    Given user is on Contact Page
    When user leaves all fields empty
    And clicks Send message
    Then error alert should appear
