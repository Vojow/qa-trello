Feature: Users filtering tests
  As logged user I want to be able to filter users list

  Scenario: Filter users list to find myself by email
    Given I am on users page
    When I filter by email with "i1167774@nwytg.com"
    Then I want to check filtering by email with "i1167774@nwytg.com"
