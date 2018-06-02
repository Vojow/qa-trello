Feature: Login tests
  As registered and activated user I want to be able to login in to system.

  Scenario: Login in to system using correct credentials
    Given I am on login page
    When I enter correct credentials
    And I submit credentials
    Then I check if I was logged in
