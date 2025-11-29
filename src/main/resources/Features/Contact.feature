Feature: Contact Form Functionality

  Scenario: verifyContactFormSubmission
    Given user is on Home Page
    When user clicks Contact
    And user enters valid contact details
    Then user should see success contact alert

  Scenario: verifyContactFormSubmissionWithErrorName
    Given user is on Home Page
    When user clicks Contact
    And user enters invalid name contact details
    Then user should see name error alert

  Scenario: verifyContactFormSubmissionWithErrorEmail
    Given user is on Home Page
    When user clicks Contact
    And user enters invalid email contact details
    Then user should see email error alert

  Scenario: verifyContactFormSubmissionWithEmptyNameAndEmail
    Given user is on Home Page
    When user clicks Contact
    And user enters only message in contact form
    Then user should see empty name and email error alert