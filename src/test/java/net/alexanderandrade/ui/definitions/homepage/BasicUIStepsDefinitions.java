/*
AlexanderAndrade.Net CONFIDENTIAL

Copyright (c) 2024. All Rights Reserved.

NOTICE: The source code contained or described herein and all documents
related to the source code ("Material") are owned by Alexander Andrade
or its companies, suppliers or licensors.

Dissemination of this information or reproduction of this material
is strictly forbidden unless prior written permission is obtained
from Alexander Andrade.
*/
package net.alexanderandrade.ui.definitions.homepage;

import static net.alexanderandrade.ui.questions.HomeQuestions.*;
import static net.alexanderandrade.ui.tasks.HomeTasks.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicUIStepsDefinitions {

    @When("she/he select the {string} option in the radio button")
    public void selectTheOptionInTheRadioButton(String radioButtonValue) {
        selectRadioButton(radioButtonValue);
    }

    @Then("the {string} option should be selected")
    public void theOptionIsSelected(String radioButtonValue) {
        ensureThatRadioButtonIsSelected(radioButtonValue);
    }

    @When("she/he select {string} from the country menu")
    public void selectFromCountryMenu(String country) {
        selectMenu(country);
    }

    @Then("{string} should appear in the country text field")
    public void theWasWroteIntoTheCountryTextField(String country) {
        ensureThatTheMenuOptionIsSelected(country);
    }

    @When("she/he select {string} from the dropdown")
    public void selectFromDropdown(String optionValue) {
        selectDropdown(optionValue);
    }

    @Then("{string} should be displayed as the selected value in the dropdown")
    public void theIsTheSelectedValueInTheDropdown(String optionValue) {
        ensureThatTheDropdownOptionIsSelected(optionValue);
    }

    @When("she/he selects {string} in the checkbox")
    public void selectInTheCheckbox(String option) {
        selectCheckbox(option);
    }

    @Then("{string} should be a selected value in the checkbox")
    public void theIsTheSelectedValueInTheCheckbox(String optionValue) {
        ensureThatTheCheckboxOptionIsSelected(optionValue);
    }

    @When("she/he triggers an alert with the name {string}")
    public void alertTheName(String value) {
        alertName(value);
    }

    @Then("the alert should display the text {string}")
    public void theAlertHasTheText(String value) {
        ensureThatTheAlertHasTheText(value);
    }

    @When("she/he triggers a confirmation dialog for the name {string}")
    public void confirmTheName(String value) {
        confirmName(value);
    }

    @Then("the Confirmation Dialog should display the text {string}")
    public void theConfirmHasTheText(String value) {
        ensureThatTheAlertHasTheText(value);
    }

    @When("she/he reads the third price listed")
    public void readTheThirdPrice() {
        // Do nothing
    }

    @Then("the price should be {int}")
    public void theThirdPriceIs(int price) {
        ensureThatTheThirdPriceValue(price);
    }

    @Given("the text box \"HideShow Example\" is visible")
    public void theTextBoxHideShowExampleIsDisplayed() {
        ensureThatTheTextboxIsDisplayed();
    }

    @When("she/he requests to hide it")
    public void askForHideIt() {
        hideObject();
    }

    @Then("the text box should be hidden")
    public void theTextBoxIsHidden() {
        ensureThatTheTextboxIsNotDisplayed();
    }

    @And("she/he requests to show it again")
    public void askForShowIt() {
        showObject();
    }

    @Then("the text box should be visible")
    public void theTextBoxIsDisplayed() {
        ensureThatTheTextboxIsDisplayed();
    }

    @When("she/he hover over the \"Mouse Hover\" button")
    public void hoverOnTheButtonMouseHover() {
        hoverOverTheButton();
    }

    @Then("the contextual menu should be displayed")
    public void theContextualMenuReloadIsDisplayed() {
        ensureThatTheContextualMenuIsDisplayed();
    }

    @When("she/he navigates to the {string} link inside the iframe")
    public void navigateToTheJobSupportLinkInTheIframe(String menuOption) {

        navigateIntoIframe(menuOption);
    }

    @Then("the page loaded has the title {string}")
    public void thePageLoadedHasTheTitle(String pageTitle) {
        ensureThatTheLoadedPageHasTheTitle(pageTitle);
    }

    @Then("the page titled {string} should load within the iframe")
    public void thePageLoadedInTheIframeHasTheTitle(String pageTitle) {
        thePageLoadedHasTheTitle(pageTitle);
    }
}
