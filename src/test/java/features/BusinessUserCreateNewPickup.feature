Feature: Business user create new pickups
  I want to check that the Business user can create a new pickup request

  Scenario: Business user login to his account
    Given user redirect to login page
    When user enter valid login credentials and submit
    Then user access shipments page

  Scenario: Create a today pickup request
    Given user redirect to create pickups page
    When user enter pickup request data and submit
    Then pickup created successfully message appears

  Scenario: Business user logout from his account
    Given user in the pickups page
    When user click on logout button
    Then user redirected to login page