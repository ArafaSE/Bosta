Feature: Business User Registration
  I want to check that the new business user can register into our website.

  Scenario: Business user registration
    Given the user open sign in page
    When user click on registration button
    And user enter his registration data and submit
    Then Bosta header section is displayed