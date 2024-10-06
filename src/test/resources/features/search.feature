Feature: Search on Google

  Scenario: User searches for something on Google
    Given the user is on the Google search page
    When the user searches for "Cucumber BDD"
    Then the result page should show relevant results