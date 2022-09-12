# language: en

#@ignore
Feature: Solve course exercises
  As a User
  I want to test al the exercises
  So that I can practice the new knowledge

    #=============================================================================

  Background: Open the home page
    Given the Verena is in the home page

  @ignore
  Scenario: Select option in radio button
    When select the "Radio2" option in the radio button
    Then the "Radio2" option is selected

  @ignore
  Scenario: Select country from menu
    When select "United States (USA)" from country menu
    Then the "United States (USA)" was wrote into the country text field

  @ignore
  Scenario: Select option for dropdown
    When select "Option3" from dropdown
    Then the "Option3" is the selected value in the dropdown

  @ignore
  Scenario: Check options in the checkbox
    When select "Option1" in the checkbox
    And select "Option3" in the checkbox
    Then the "Option1" is the selected value in the checkbox
    And the "Option3" is the selected value in the checkbox

  #@ignore
  Scenario: Alert the name ALEX
    When alert the name "ALEX"
    Then the alert has the text "Hello ALEX, share this practice page and share your knowledge"

  @ignore
  Scenario: Confirm the name ALEX
    When confirm the name "ALEX"
    Then the confirm has the text "Hello ALEX, Are you sure you want to confirm?"

  @ignore
  Scenario: Third price is 30
    When read the third price
    Then the third price is 30

  @ignore
  Scenario: Hide an object
    Given the text box HideShow Example is displayed
    When ask for Hide it
    Then the text box is hidden

  @ignore
  Scenario: Hide and Show object
    Given the text box HideShow Example is displayed
    When ask for Hide it
    And ask for Show it
    Then the text box is displayed

  @ignore
  Scenario: Mouse hover menu
    When hover on the button Mouse Hover
    Then the contextual menu is displayed

  @ignore
  Scenario: Iframe navigation
    When navigate to the "Job Support" link in the iframe
    Then the page loaded in the iframe has the title "Job Support"
