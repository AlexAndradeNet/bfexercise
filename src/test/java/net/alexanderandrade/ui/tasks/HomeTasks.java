/**
 * Alexander Andrade CONFIDENTIAL
 * <p>Copyright (c) 2022 . All Rights Reserved.
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.tasks;

import net.alexanderandrade.ui.interactions.ClickOn;
import net.alexanderandrade.ui.interactions.HoverOn;
import net.alexanderandrade.ui.interactions.WaitForNewPageOrTabAndSwitch;
import net.alexanderandrade.ui.interactions.WaitForPageLoad;
import net.alexanderandrade.ui.ui.ExternalPage;
import net.alexanderandrade.ui.ui.HomePage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomeTasks {

  @Managed private static final WebDriver          driver = getDriver();
  private static final          JavascriptExecutor js     = (JavascriptExecutor) driver;

  private HomeTasks () {
    throw new IllegalStateException( "Utility class" );
  }

  @Step("{0} open the main page") public static Performable open () {
    return Task.where( "{0} open the main page", Open.browserOn().the( HomePage.class ), WaitForPageLoad.complete(), WaitUntil.the( HomePage.TEXT_COUNTRY, isClickable() ) );
  }

  public static <T extends Actor> void selectMenu ( String menuOption ) {
    theActorInTheSpotlight().attemptsTo( Enter.theValue( menuOption ).into( HomePage.TEXT_COUNTRY ), WaitUntil.the( HomePage.MENU_COUNTRY.of( menuOption ), isClickable() ), ClickOn.target( HomePage.MENU_COUNTRY.of( menuOption ) ) );
  }

  public static <T extends Actor> void selectDropdown ( String menuOption ) {
    theActorInTheSpotlight().attemptsTo( new SelectByVisibleTextFromTarget( HomePage.SELECT, menuOption ) );
  }

  public static <T extends Actor> void selectRadioButton ( String radioButtonValue ) {
    clickForced( HomePage.RADIO_BUTTON.of( radioButtonValue.toLowerCase() ) );
  }

  public static <T extends Actor> void selectCheckbox ( String radioButtonValue ) {
    clickForced( HomePage.CHECKBOX.of( radioButtonValue.toLowerCase() ) );
  }

  public static void clickForced ( Target target ) {
    WebElement webElement = createWebElementFromTarget( target );

    js.executeScript( "arguments[0].click();", webElement );
  }

  private static WebElement createWebElementFromTarget ( Target target ) {
    return driver.findElement( By.xpath( target.getCssOrXPathSelector() ) );
  }

  public static <T extends Actor> void alertName ( String name ) {
    theActorInTheSpotlight().attemptsTo( Enter.theValue( name ).into( HomePage.TEXTBOX_NAME ), ClickOn.target( HomePage.BUTTON_ALERT ) );
  }

  public static <T extends Actor> void confirmName ( String name ) {
    theActorInTheSpotlight().attemptsTo( Enter.theValue( name ).into( HomePage.TEXTBOX_NAME ), ClickOn.target( HomePage.BUTTON_CONFIRM ) );
  }

  public static <T extends Actor> void hideObject ( Actor actor ) {
    theActorInTheSpotlight().attemptsTo( ClickOn.target( HomePage.BUTTON_HIDE ) );
  }

  public static <T extends Actor> void showObject ( Actor actor ) {
    theActorInTheSpotlight().attemptsTo( ClickOn.target( HomePage.BUTTON_SHOW ) );
  }

  public static <T extends Actor> void hoverOverTheButton ( Actor actor ) {
    theActorInTheSpotlight().attemptsTo( HoverOn.target( HomePage.BUTTON_MOUSE_OVER ) );
  }

  public static <T extends Actor> void navigateIntoIframe ( String menuOption ) {
    theActorInTheSpotlight().attemptsTo( Scroll.to( HomePage.IFRAME ), Switch.toFrame( HomePage.IFRAME_NAME ), ClickOn.target( ExternalPage.MENU.of( menuOption ) ) );
  }

  public static <T extends Actor> void openNewWindow () {
    theActorInTheSpotlight().attemptsTo( ClickOn.target( HomePage.BUTTON_OPEN_WINDOW ) );
  }

  public static <T extends Actor> void openNewTab () {
    theActorInTheSpotlight().attemptsTo( ClickOn.target( HomePage.BUTTON_OPEN_TAB ) );
  }

  public static <T extends Actor> void goToNewWindowAndWaitBeforeClickOnLink ( String menuOption ) {
    theActorInTheSpotlight().attemptsTo( WaitForNewPageOrTabAndSwitch.andSwitch(), ClickOn.target( ExternalPage.MENU.of( menuOption ) ) );
  }

  public static <T extends Actor> void goToNewTabAndWaitBeforeClickOnLink ( String menuOption ) {
    theActorInTheSpotlight().attemptsTo( WaitForNewPageOrTabAndSwitch.andSwitch(), ClickOn.target( ExternalPage.MENU.of( menuOption ) ) );
  }

  public static <T extends Actor> void returnToTheDefaultContext () {
    theActorInTheSpotlight().attemptsTo( Switch.toDefaultContext() );
  }

  public static <T extends Actor> void waitForSeconds ( int seconds ) {
    synchronized ( theActorInTheSpotlight() ) {
      try {
        theActorInTheSpotlight().wait( seconds );
      } catch ( InterruptedException e ) {
        throw new RuntimeException( e );
      }
    }
  }

}
