Feature: Business user create new shipments
  I want to check that the Business user can create all different types of shipments

  Scenario: Business user login to his account
    Given user redirect to login page
    When user enter valid login credentials and submit
    Then user access shipments page

  Scenario: Create Forward shipment
    Given user access shipments page
    When user click on create new shipment button
    And user enter Forward shipment data and submit
    Then user redirect to shipments page with success message

  Scenario: Create Exchange Shipment
    Given user access shipments page
    When user click on create new shipment button
    And user enter Exchange shipment data and submit
    Then user redirect to shipments page with success message

  Scenario: Create CRP Shipment
    Given user access shipments page
    When user click on create new shipment button
    And user enter CRP shipment data and submit
    Then user redirect to shipments page with success message

  Scenario: Create Cash Collection Shipment
    Given user access shipments page
    When user click on create new shipment button
    And user enter Cash Collection shipment data and submit
    Then user redirect to shipments page with success message

  Scenario: Business user logout from his account
    Given user access shipments page
    When user click on logout button
    Then user redirected to login page