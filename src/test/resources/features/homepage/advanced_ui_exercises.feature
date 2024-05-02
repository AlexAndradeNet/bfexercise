# language: en

#@ignore
Feature: Advanced User Exercises
  As a User
  I want to test all the advanced exercises
  So that I can enhance my skills with practical applications

  Background: Open the home page
    Given Verena is on the home page

    #=============================================================================

  #@ignore
  Scenario: Displaying the Contextual Menu via Mouse Hover
    When she hover over the "Mouse Hover" button
    Then the contextual menu should be displayed

  #@ignore
  Scenario: Navigating to a Support Link Within an Iframe
    When she navigates to the "Job Support" link inside the iframe
    Then the page titled "Job Support" should load within the iframe

  #@ignore
  Scenario: Opening and Verifying a Blog Page in a New Window
    When she clicks on the "New Window" button
    And she clicks the "Blog" link in the new window
    Then the page titled "Mindblown: a blog about philosophy." should be displayed
    And she should return to the main page after closing the new window

  #@ignore
  Scenario: Opening and Verifying a Blog Page in a New Tab
    When she clicks on the "New Tab" button
    And she clicks the "Blog" link in the new tab
    Then the page titled "INVENTED TITLE" should be displayed
    And she should returns to the main page after closing the new tab
