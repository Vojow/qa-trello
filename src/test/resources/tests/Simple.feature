Feature: Simple tests
I want to register to system and login as created user.

  Scenario: Register to system
    Given I am on register page
    When I fill register form with random email and password
    And I submit register form
    Then I want to check if I was registered


  Scenario: Login to system
    Given I am on login page
    When I fill login form with incorrect user
    And I submit login form
    Then I want to check if I was logged in
