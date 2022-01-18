Feature: This feature will verify search scenarios
  Scenario Outline: Verify user is able to search for the product
  Given User is on Amazon home page
  When User enters "<Product>" in the search field
  And Click on Search Button
  Then Search Result should be displayed

  Examples:
    |Product|
    |Shampoo|


