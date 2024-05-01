package net.alexanderandrade.ui.definitions.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.alexanderandrade.ui.questions.HomeQuestions.*;
import static net.alexanderandrade.ui.tasks.HomeTasks.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BasicUIStepsDefinitions {
  Actor actor;

  @When("select the {string} option in the radio button") public void selectTheOptionInTheRadioButton ( String radioButtonValue ) {
    actor = theActorInTheSpotlight();
    selectRadioButton( radioButtonValue );
  }

  @Then("the {string} option is selected") public void theOptionIsSelected ( String radioButtonValue ) {
    ensureThatRadioButtonIsSelected( actor, radioButtonValue );
  }

  @When("select {string} from country menu") public void selectFromCountryMenu ( String country ) {
    actor = theActorInTheSpotlight();
    selectMenu( country );
  }

  @Then("the {string} was wrote into the country text field") public void theWasWroteIntoTheCountryTextField ( String country ) {
    ensureThatTheMenuOptionIsSelected( actor, country );
  }

  @When("select {string} from dropdown") public void selectFromDropdown ( String optionValue ) {
    actor = theActorInTheSpotlight();
    selectDropdown( optionValue );
  }

  @Then("the {string} is the selected value in the dropdown") public void theIsTheSelectedValueInTheDropdown ( String optionValue ) {
    ensureThatTheDropdownOptionIsSelected( actor, optionValue );
  }

  @When("select {string} in the checkbox") public void selectInTheCheckbox ( String option ) {
    actor = theActorInTheSpotlight();
    selectCheckbox( option );
  }

  @Then("the {string} is the selected value in the checkbox") public void theIsTheSelectedValueInTheCheckbox ( String optionValue ) {
    ensureThatTheCheckboxOptionIsSelected( actor, optionValue );
  }

  @When("alert the name {string}") public void alertTheName ( String value ) {
    actor = theActorInTheSpotlight();
    alertName( value );
  }

  @Then("the alert has the text {string}") public void theAlertHasTheText ( String value ) {
    ensureThatTheAlertHasTheText( actor, value );
  }

  @When("confirm the name {string}") public void confirmTheName ( String value ) {
    actor = theActorInTheSpotlight();
    confirmName( value );
  }

  @Then("the confirm has the text {string}") public void theConfirmHasTheText ( String value ) {
    ensureThatTheAlertHasTheText( actor, value );
  }

  @When("read the third price") public void readTheThirdPrice () {
    // Do nothing
  }

  @Then("the third price is {int}") public void theThirdPriceIs ( int price ) {
    actor = theActorInTheSpotlight();
    ensureThatTheThirdPriceValue( actor, price );
  }

  @Given("the text box HideShow Example is displayed") public void theTextBoxHideShowExampleIsDisplayed () {
    actor = theActorInTheSpotlight();
    ensureThatTheTextboxIsDisplayed( actor );
  }

  @When("ask for Hide it") public void askForHideIt () {
    hideObject( actor );
  }

  @Then("the text box is hidden") public void theTextBoxIsHidden () {
    ensureThatTheTextboxIsNotDisplayed( actor );
  }

  @And("ask for Show it") public void askForShowIt () {
    showObject( actor );
  }

  @Then("the text box is displayed") public void theTextBoxIsDisplayed () {
    ensureThatTheTextboxIsDisplayed( actor );
  }

  @When("hover on the button Mouse Hover") public void hoverOnTheButtonMouseHover () {
    actor = theActorInTheSpotlight();
    hoverOverTheButton( actor );
  }

  @Then("the contextual menu is displayed") public void theContextualMenuReloadIsDisplayed () {
    ensureThatTheContextualMenuIsDisplayed( actor );
  }

  @When("navigate to the {string} link in the iframe") public void navigateToTheJobSupportLinkInTheIframe ( String menuOption ) {
    actor = theActorInTheSpotlight();
    navigateIntoIframe( menuOption );
  }

  @Then("the page loaded in the iframe has the title {string}") public void thePageLoadedInTheIframeHasTheTitle ( String pageTitle ) {
    ensureThatTheLoadedPageHasTheTitle( actor, pageTitle );
  }
}
