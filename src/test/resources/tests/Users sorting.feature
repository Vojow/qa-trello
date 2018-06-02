Feature: Users sorting tests
  As logged user I want to check sorting of users page

  Scenario Outline: Sort by <header> ascending
    Given I am on users page
    When I sort by "<header>" ascending
    Then I want to check sorting by "<header>" ascending was correct
    Examples:
      | header      |
      | email       |
      | name        |
      | last name   |
      | verified at |

  Scenario Outline: Sort by <header> descending
    Given I am on users page
    When I sort by "<header>" descending
    Then I want to check sorting by "<header>" descending was correct
    Examples:
      | header      |
      | email       |
      | name        |
      | last name   |
      | verified at |



