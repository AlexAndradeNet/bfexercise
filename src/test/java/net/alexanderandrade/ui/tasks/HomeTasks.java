/**
 * Alexander Andrade CONFIDENTIAL
 *
 * <p>Copyright (c) 2022 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.tasks;

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
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import org.openqa.selenium.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomeTasks {

  private static                String             mainWindowHandle;
  @Managed private static final WebDriver          driver = getDriver();
  private static final          JavascriptExecutor js     = (JavascriptExecutor) driver;

  private HomeTasks() {
    throw new IllegalStateException("Utility class");
  }

  @Step("{0} open the main page")
  public static Performable open() {
    return Task.where(
      "{0} open the main page",
      Open.browserOn().the( HomePage.class ),
      new WaitUntilAngularIsReady(),
      WaitUntil.the( HomePage.TEXT_COUNTRY, isClickable() )
    );
  }

  public static <T extends Actor> void selectMenu( Actor actor, String menuOption) {
    actor.attemptsTo(
      Enter.theValue( menuOption ).into( HomePage.TEXT_COUNTRY ),
      WaitUntil.the( HomePage.MENU_COUNTRY.of( menuOption ), isClickable() ),
      Click.on( HomePage.MENU_COUNTRY.of( menuOption ) )
    );
  }

  public static <T extends Actor> void selectDropdown( Actor actor, String menuOption) {
    actor.attemptsTo(
      new SelectByVisibleTextFromTarget(
        HomePage.SELECT,
        menuOption
      )
    );
  }

  public static <T extends Actor> void selectRadioButton ( String radioButtonValue) {
    clickForced( HomePage.RADIO_BUTTON.of( radioButtonValue.toLowerCase() ) );
  }

  public static <T extends Actor> void selectCheckbox ( String radioButtonValue) {
    clickForced( HomePage.CHECKBOX.of( radioButtonValue.toLowerCase() ) );
  }

  public static void clickForced ( Target target ) {
    WebElement webElement = createWebElementFromTarget( target );

    js.executeScript("arguments[0].click();", webElement);
  }

  private static WebElement createWebElementFromTarget( Target target ) {
    return driver.findElement( By.xpath( target.getCssOrXPathSelector() ) );
  }

  public static <T extends Actor> void alertName ( Actor actor, String name ) {
    actor.attemptsTo(
      Enter.theValue( name ).into( HomePage.TEXTBOX_NAME ),
      Click.on( HomePage.BUTTON_ALERT )
    );
  }

  public static <T extends Actor> void confirmName ( Actor actor, String name ) {
    actor.attemptsTo(
      Enter.theValue( name ).into( HomePage.TEXTBOX_NAME ),
      Click.on( HomePage.BUTTON_CONFIRM )
    );
  }

  public static <T extends Actor> void hideObject ( Actor actor ) {
    actor.attemptsTo(
      Click.on( HomePage.BUTTON_HIDE )
    );
  }

  public static <T extends Actor> void showObject ( Actor actor ) {
    actor.attemptsTo(
      Click.on( HomePage.BUTTON_SHOW )
    );
  }

  public static <T extends Actor> void hoverOverTheButton ( Actor actor ) {
    actor.attemptsTo(
      Scroll.to( HomePage.BUTTON_MOUSE_OVER ),
      HoverOverTarget.over( HomePage.BUTTON_MOUSE_OVER )
    );
  }

  public static <T extends Actor> void navigateIntoIframe ( Actor actor, String menuOption ) {
    actor.attemptsTo(
      Scroll.to( HomePage.IFRAME ),
      Switch.toFrame( HomePage.IFRAME_NAME ),
      Click.on( ExternalPage.MENU.of( menuOption ) )
    );
  }

  public static <T extends Actor> void openNewWindow ( Actor actor ) {
    mainWindowHandle = driver.getWindowHandle();

    actor.attemptsTo(
      Click.on( HomePage.BUTTON_OPEN_WINDOW )
    );
  }

  public static <T extends Actor> void openNewTab ( Actor actor ) {
    mainWindowHandle = driver.getWindowHandle();

    actor.attemptsTo(
      Click.on( HomePage.BUTTON_OPEN_TAB )
    );
  }

  public static <T extends Actor> void goToNewWindowAndWaitBeforeClickOnLink ( Actor actor, int seconds, String menuOption ) {
    waitForSeconds( actor, seconds );
    actor.attemptsTo(
      Switch.toTheOtherWindow(),
      Click.on( ExternalPage.MENU.of( menuOption ) )
    );
  }

  public static <T extends Actor> void goToNewTabAndWaitBeforeClickOnLink ( Actor actor, int seconds, String menuOption ) {
    waitForSeconds( actor, seconds );
    actor.attemptsTo(
      SwitchToTab.withIndex( 1 ),
      Click.on( ExternalPage.MENU.of( menuOption ) )
    );
  }

  public static <T extends Actor> void returnToTheDefaultContext ( Actor actor ) {
    driver.close();
    actor.attemptsTo(
      Switch.toWindow( mainWindowHandle )
    );
  }

  public static <T extends Actor> void waitForSeconds ( Actor actor, int seconds) {
    synchronized ( actor ) {
      try {
        actor.wait( seconds );
      } catch ( InterruptedException e ) {
        throw new RuntimeException( e );
      }
    }
  }

}
