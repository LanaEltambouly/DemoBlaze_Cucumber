Feature: Home Functionality
  Scenario: Verify only phones are displayed when clicking Phones
    Given user is on Home Page
    When user clicks Phones category
    Then only phones should be displayed

  Scenario: Verify only laptops are displayed when clicking Laptops
    Given user is on Home Page
    When user clicks Laptops category
    Then only laptops should be displayed

  Scenario: Verify only monitors are displayed when clicking Monitors
    Given user is on Home Page
    When user clicks Monitors category
    Then only monitors should be displayed

  Scenario: Verify all products are displayed when clicking Categories
    Given user is on Home Page
    When user clicks Categories
    Then all products should be displayed