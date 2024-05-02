# language: en

#@ignore
Feature: Practicing Basic User Interactions
  As a User
  I want to test various basic exercises
  So that I can enhance my practical skills with foundational interactions

  Background: Accessing the Home Page
    Given Verena is on the home page

    #=============================================================================

  #@ignore
  Scenario: Selecting an Option in a Radio Button
    When she select the "Radio2" option in the radio button
    Then the "Radio2" option should be selected

  #@ignore
  Scenario: Choosing a Country from a Dropdown Menu
    When she select "United States (USA)" from the country menu
    Then "United States (USA)" should appear in the country text field

  #@ignore
  Scenario: Selecting an Option from a Dropdown Menu
    When she select "Option3" from the dropdown
    Then "Option3" should be displayed as the selected value in the dropdown

  #@ignore
  Scenario: Verifying Multiple Checkbox Selections
    When she selects "Option1" in the checkbox
    And she selects "Option3" in the checkbox
    Then "Option1" should be a selected value in the checkbox
    And "Option3" should be a selected value in the checkbox

  #@ignore
  Scenario: Displaying a Custom Alert with the Name
    When she triggers an alert with the name "ALEX"
    Then the alert should display the text "Hello ALEX, share this practice page and share your knowledge"

  #@ignore
  Scenario: Displaying a Custom Confirm Dialog with a Custom Name
    When she triggers a confirmation dialog for the name "ALEX"
    Then the Confirmation Dialog should display the text "Hello ALEX, Are you sure you want to confirm?"

  #@ignore
  Scenario: Checking the Value of the Third item in the Price Table
    When she reads the third price listed
    Then the price should be 30

  #@ignore
  Scenario: Hiding a Visible Text Box
    Given the text box "HideShow Example" is visible
    When she requests to hide it
    Then the text box should be hidden

  #@ignore
  Scenario: Toggling Visibility of a Text Box
    Given the text box "HideShow Example" is visible
    When she requests to hide it
    And she requests to show it again
    Then the text box should be visible
