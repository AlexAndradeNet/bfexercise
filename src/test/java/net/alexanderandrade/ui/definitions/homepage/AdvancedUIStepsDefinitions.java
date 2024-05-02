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

import static net.alexanderandrade.ui.tasks.HomeTasks.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.alexanderandrade.ui.questions.GetExternalPageTitle;
import net.serenitybdd.screenplay.ensure.Ensure;

public class AdvancedUIStepsDefinitions {

    @When("she/he clicks on the \"New Window\" button")
    public void clicksOnTheNewWindowButton() {
        openNewWindow();
    }

    @And("she/he clicks the {string} link in the new window")
    public void waitSecondsBeforeClicksToTheLinkInTheNewWindow(String menuOption) {
        goToNewWindowAndWaitBeforeClickOnLink(menuOption);
    }

    @And("she/he clicks the {string} link in the new tab")
    public void waitSecondsBeforeClicksToTheLinkInTheNewTab(String menuOption) {
        goToNewTabAndWaitBeforeClickOnLink(menuOption);
    }

    @Then("the page titled {string} should be displayed")
    public void thePageTitleIs(String expectedTitle) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that("The page title is correct", GetExternalPageTitle.mainTitle())
                                .isEqualTo(expectedTitle));
    }

    @And("she/he should return to the main page after closing the new window")
    public void returnToTheMainPageAfterCloseTheNewWindow() {
        returnToTheDefaultContext();
    }

    @When("she/he clicks on the \"New Tab\" button")
    public void clicksOnTheNewTabButton() {
        openNewTab();
    }

    @And("she/he should returns to the main page after closing the new tab")
    public void returnToTheMainPageAfterCloseTheNewTab() {
        returnToTheDefaultContext();
    }
}
