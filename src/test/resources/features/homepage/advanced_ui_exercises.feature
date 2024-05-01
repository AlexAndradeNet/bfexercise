# language: en

#@ignore
Feature: Solve course advanced exercises
  As a User
  I want to test all the exercises
  So that I can practice the new knowledge

    #=============================================================================

  Background: Open the home page
    Given the Verena is in the home page

  #@ignore
  Scenario: Open new window
    When clicks on the New Window button
    And clicks to the "Blog" link in the new window button
    Then the page title is "Mindblown: a blog about philosophy."
    And return to the main page after close the new window

  #@ignore
  Scenario: Open new Tab
    When clicks on the New Tab button
    And clicks to the "Blog" link in the new tab button
    Then the page title is "Mindblown: a blog about philosophy."
    And return to the main page after close the new tab
