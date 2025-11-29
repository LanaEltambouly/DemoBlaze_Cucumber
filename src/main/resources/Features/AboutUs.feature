 @AboutUs
  Feature: About Us modal on Demoblaze

  Scenario: User views About Us information
    Given user is on Home Page
    When the user clicks the About us link
    Then the About Us popup should be displayed

  Scenario: User popup About Us popup
    Given the About Us popup is displayed
    When the user clicks the Close button
    Then the About Us popup should be closed