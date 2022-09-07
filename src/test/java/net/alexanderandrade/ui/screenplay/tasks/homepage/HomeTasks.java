/**
 * Alexander Andrade CONFIDENTIAL
 *
 * <p>Copyright (c) 2022 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.screenplay.tasks.homepage;

import net.alexanderandrade.ui.screenplay.ui.homepage.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.alexanderandrade.ui.screenplay.ui.homepage.HomePage.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomeTasks {

  private HomeTasks() {
    throw new IllegalStateException("Utility class");
  }

  private static final WebDriver driver = getDriver();

  public static Performable open() {
    return Task.where(
      "{0} open the main page",
      Open.browserOn().the( HomePage.class ),
      new WaitUntilAngularIsReady(),
      WaitUntil.the( TEXT_COUNTRY, WebElementStateMatchers.isClickable() )
    );
  }

  public static <T extends Actor> void selectMenu( Actor actor, String menuOption) {
    actor.attemptsTo(
      Enter.theValue( menuOption ).into( TEXT_COUNTRY ),
      WaitUntil.the( MENU_COUNTRY.of( menuOption ), WebElementStateMatchers.isClickable() ),
      Click.on( MENU_COUNTRY.of( menuOption ) )
    );
  }

  public static <T extends Actor> void selectDropdown( Actor actor, String menuOption) {
    actor.attemptsTo(
      new SelectByVisibleTextFromTarget(
        SELECT,
        menuOption
      )
    );
  }

  public static <T extends Actor> void selectRadioButton ( String radioButtonValue) {
    clickForced( RADIO_BUTTON.of( radioButtonValue.toLowerCase() ) );
  }

  public static <T extends Actor> void selectCheckbox ( String radioButtonValue) {
    clickForced( CHECKBOX.of( radioButtonValue.toLowerCase() ) );
  }

  public static void clickForced ( Target target ) {
    WebElement webElement = createWebElementFromTarget( target );

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", webElement);
  }

  private static WebElement createWebElementFromTarget( Target target ) {
    return driver.findElement( By.xpath( target.getCssOrXPathSelector() ) );
  }

  public static <T extends Actor> void alertName ( Actor actor, String name ) {
    actor.attemptsTo(
      Enter.theValue( name ).into( TEXTBOX_NAME ),
      Click.on( BUTTON_ALERT )
    );
  }

  public static <T extends Actor> void confirmName ( Actor actor, String name ) {
    actor.attemptsTo(
      Enter.theValue( name ).into( TEXTBOX_NAME ),
      Click.on( BUTTON_CONFIRM )
    );
  }

  public static <T extends Actor> void hideObject ( Actor actor ) {
    actor.attemptsTo(
      Click.on( BUTTON_HIDE )
    );
  }

  public static <T extends Actor> void showObject ( Actor actor ) {
    actor.attemptsTo(
      Click.on( BUTTON_SHOW )
    );
  }

  public static <T extends Actor> void hoverOverTheButton ( Actor actor ) {
    actor.attemptsTo(
      HoverOverTarget.over( BUTTON_MOUSE_OVER )
    );
  }

  public static <T extends Actor> void navigateIntoIframe ( Actor actor, String menuOption ) {
    actor.attemptsTo(
      Switch.toFrame( IFRAME_NAME ),
      Click.on( IFRAME_MENU.of( menuOption ) )
    );
  }

}
