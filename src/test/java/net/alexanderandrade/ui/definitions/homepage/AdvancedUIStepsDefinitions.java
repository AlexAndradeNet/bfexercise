package net.alexanderandrade.ui.definitions.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.alexanderandrade.ui.questions.ExternalQuestions.ensureThatTheLoadedPageHasTheMainTitle;
import static net.alexanderandrade.ui.questions.ExternalQuestions.ensureThatTheLoadedPageHasTheTitle;
import static net.alexanderandrade.ui.tasks.HomeTasks.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AdvancedUIStepsDefinitions {

  Actor actor;
  @When("clicks on the New Window button")
  public void clicksOnTheNewWindowButton () {
    actor = theActorInTheSpotlight();
    openNewWindow(actor);
  }

  @And("wait {int} seconds before clicks to the {string} link in the new window")
  public void waitSecondsBeforeClicksToTheLinkInTheNewWindow ( int seconds, String menuOption ) {
    goToNewWindowAndWaitBeforeClickOnLink(actor, seconds, menuOption);
  }

  @And("wait {int} seconds before clicks to the {string} link in the new tab")
  public void waitSecondsBeforeClicksToTheLinkInTheNewTab ( int seconds, String menuOption ) {
    goToNewTabAndWaitBeforeClickOnLink(actor, seconds, menuOption);
  }

  @Then("the page title is {string}")
  public void thePageTitleIs ( String title ) {
    ensureThatTheLoadedPageHasTheTitle(actor, title);
  }

  @And("return to the main page after close the new window")
  public void returnToTheMainPageAfterCloseTheNewWindow () {
    returnToTheDefaultContext(actor);
  }

  @When("clicks on the New Tab button")
  public void clicksOnTheNewTabButton () {
    actor = theActorInTheSpotlight();
    openNewTab(actor);
  }

  @And("return to the main page after close the new tab")
  public void returnToTheMainPageAfterCloseTheNewTab () {
    returnToTheDefaultContext(actor);
  }

  @Then("the page main title is {string}")
  public void thePageMainTitleIs ( String title ) {
    ensureThatTheLoadedPageHasTheMainTitle(actor, title);
  }
}
