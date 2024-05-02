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

    @When("clicks on the New Window button")
    public void clicksOnTheNewWindowButton() {
        openNewWindow();
    }

    @And("clicks to the {string} link in the new window button")
    public void waitSecondsBeforeClicksToTheLinkInTheNewWindow(String menuOption) {
        goToNewWindowAndWaitBeforeClickOnLink(menuOption);
    }

    @And("clicks to the {string} link in the new tab button")
    public void waitSecondsBeforeClicksToTheLinkInTheNewTab(String menuOption) {
        goToNewTabAndWaitBeforeClickOnLink(menuOption);
    }

    @Then("the page title is {string}")
    public void thePageTitleIs(String expectedTitle) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that("The page title is correct", GetExternalPageTitle.mainTitle())
                                .isEqualTo(expectedTitle));
    }

    @And("return to the main page after close the new window")
    public void returnToTheMainPageAfterCloseTheNewWindow() {
        returnToTheDefaultContext();
    }

    @When("clicks on the New Tab button")
    public void clicksOnTheNewTabButton() {
        openNewTab();
    }

    @And("return to the main page after close the new tab")
    public void returnToTheMainPageAfterCloseTheNewTab() {
        returnToTheDefaultContext();
    }
}
