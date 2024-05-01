package net.alexanderandrade.ui.definitions.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.alexanderandrade.ui.questions.GetExternalPageTitle;

import static net.alexanderandrade.ui.tasks.HomeTasks.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class AdvancedUIStepsDefinitions {

  @When("clicks on the New Window button") public void clicksOnTheNewWindowButton () {
    openNewWindow();
  }

  @And("clicks to the {string} link in the new window button") public void waitSecondsBeforeClicksToTheLinkInTheNewWindow ( String menuOption ) {
    goToNewWindowAndWaitBeforeClickOnLink( menuOption );
  }

  @And("clicks to the {string} link in the new tab button") public void waitSecondsBeforeClicksToTheLinkInTheNewTab ( String menuOption ) {
    goToNewTabAndWaitBeforeClickOnLink( menuOption );
  }

  @Then("the page title is {string}") public void thePageTitleIs ( String title ) {
    // ensureThatTheLoadedPageHasTheTitle(title);
    theActorInTheSpotlight().should( seeThat( "The page title is correct", GetExternalPageTitle.mainTitle(), equalTo( title ) ) );
  }

  @And("return to the main page after close the new window") public void returnToTheMainPageAfterCloseTheNewWindow () {
    returnToTheDefaultContext();
  }

  @When("clicks on the New Tab button") public void clicksOnTheNewTabButton () {
    openNewTab();
  }

  @And("return to the main page after close the new tab") public void returnToTheMainPageAfterCloseTheNewTab () {
    returnToTheDefaultContext();
  }
}
