Feature:
  Scenario: User views About Us information
    Given the user is on the Demoblaze home page
    When the user clicks the About us link
    Then the About Us popup should be displayed

  Scenario: User closes About Us popup
    Given the About Us popup is displayed
    When the user clicks the Close button
    Then the About Us popup should be closed
