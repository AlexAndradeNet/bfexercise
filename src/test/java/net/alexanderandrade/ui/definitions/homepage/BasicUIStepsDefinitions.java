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

  @When("select the {string} option in the radio button") public void selectTheOptionInTheRadioButton ( String radioButtonValue ) {
    
    selectRadioButton( radioButtonValue );
  }

  @Then("the {string} option is selected") public void theOptionIsSelected ( String radioButtonValue ) {
    ensureThatRadioButtonIsSelected( radioButtonValue );
  }

  @When("select {string} from country menu") public void selectFromCountryMenu ( String country ) {
    
    selectMenu( country );
  }

  @Then("the {string} was wrote into the country text field") public void theWasWroteIntoTheCountryTextField ( String country ) {
    ensureThatTheMenuOptionIsSelected( country );
  }

  @When("select {string} from dropdown") public void selectFromDropdown ( String optionValue ) {
    
    selectDropdown( optionValue );
  }

  @Then("the {string} is the selected value in the dropdown") public void theIsTheSelectedValueInTheDropdown ( String optionValue ) {
    ensureThatTheDropdownOptionIsSelected( optionValue );
  }

  @When("select {string} in the checkbox") public void selectInTheCheckbox ( String option ) {
    
    selectCheckbox( option );
  }

  @Then("the {string} is the selected value in the checkbox") public void theIsTheSelectedValueInTheCheckbox ( String optionValue ) {
    ensureThatTheCheckboxOptionIsSelected( optionValue );
  }

  @When("alert the name {string}") public void alertTheName ( String value ) {
    
    alertName( value );
  }

  @Then("the alert has the text {string}") public void theAlertHasTheText ( String value ) {
    ensureThatTheAlertHasTheText( value );
  }

  @When("confirm the name {string}") public void confirmTheName ( String value ) {
    
    confirmName( value );
  }

  @Then("the confirm has the text {string}") public void theConfirmHasTheText ( String value ) {
    ensureThatTheAlertHasTheText( value );
  }

  @When("read the third price") public void readTheThirdPrice () {
    // Do nothing
  }

  @Then("the third price is {int}") public void theThirdPriceIs ( int price ) {
    
    ensureThatTheThirdPriceValue( price );
  }

  @Given("the text box HideShow Example is displayed") public void theTextBoxHideShowExampleIsDisplayed () {
    
    ensureThatTheTextboxIsDisplayed();
  }

  @When("ask for Hide it") public void askForHideIt () {
    hideObject();
  }

  @Then("the text box is hidden") public void theTextBoxIsHidden () {
    ensureThatTheTextboxIsNotDisplayed();
  }

  @And("ask for Show it") public void askForShowIt () {
    showObject();
  }

  @Then("the text box is displayed") public void theTextBoxIsDisplayed () {
    ensureThatTheTextboxIsDisplayed();
  }

  @When("hover on the button Mouse Hover") public void hoverOnTheButtonMouseHover () {
    hoverOverTheButton();
  }

  @Then("the contextual menu is displayed") public void theContextualMenuReloadIsDisplayed () {
    ensureThatTheContextualMenuIsDisplayed();
  }

  @When("navigate to the {string} link in the iframe") public void navigateToTheJobSupportLinkInTheIframe ( String menuOption ) {
    
    navigateIntoIframe( menuOption );
  }

  @Then("the page loaded has the title {string}") public void thePageLoadedHasTheTitle ( String pageTitle ) {
    ensureThatTheLoadedPageHasTheTitle( pageTitle );
  }

  @Then("the page loaded in the iframe has the title {string}") public void thePageLoadedInTheIframeHasTheTitle ( String pageTitle ) {
    thePageLoadedHasTheTitle( pageTitle );
  }
}
