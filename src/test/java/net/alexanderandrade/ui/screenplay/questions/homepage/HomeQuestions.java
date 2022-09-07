/**
 * Alexander Andrade CONFIDENTIAL
 *
 * <p>Copyright (c) 2022 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.screenplay.questions.homepage;

import net.alexanderandrade.ui.screenplay.ui.homepage.HomePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.questions.page.AlertTextQuestion;
import org.openqa.selenium.Alert;

import java.util.List;

import static net.alexanderandrade.ui.screenplay.ui.homepage.HomePage.*;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.abilities.BrowseTheWeb.as;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HomeQuestions {

  private HomeQuestions () {
    throw new IllegalStateException("Utility class");
  }

  @Subject("{0} verify that the radio button option is selected")
  public static <T extends Actor> void ensureThatRadioButtonIsSelected ( Actor actor, String radioButtonValue ) {
    actor.attemptsTo(
      Ensure.that(
        Attribute.of(
          HomePage.RADIO_BUTTON.of( radioButtonValue.toLowerCase() )
        ).named( "selected" ).viewedBy(theActorInTheSpotlight()).asBoolean()
      ).isTrue()
    );
  }

  @Subject("{0} verify that the menu option is selected")
  public static <T extends Actor> void ensureThatTheMenuOptionIsSelected ( Actor actor, String menuOption ) {
    actor.attemptsTo(
      Ensure.that(
        HomePage.TEXT_COUNTRY
      ).value().asAString().contains( menuOption )
    );
  }

  @Subject("{0} verify that the dropdown option is selected")
  public static <T extends Actor> void ensureThatTheDropdownOptionIsSelected ( Actor actor, String menuOption ) {
    actor.attemptsTo(
      Ensure.that(
        HomePage.SELECT
      ).text().asAString().contains( menuOption )
    );
  }

  @Subject("{0} verify that the checkbox option is selected")
  public static <T extends Actor> void ensureThatTheCheckboxOptionIsSelected ( Actor actor, String menuOption ) {
    actor.attemptsTo(
      Ensure.that(
        Attribute.of( HomePage.CHECKBOX.of( menuOption.toLowerCase() ) ).named( "checked" ).viewedBy( actor ).asBoolean()
      ).isTrue()
    );
  }

  @Subject("{0} verify that the alert has the text")
  public static <T extends Actor> void ensureThatTheAlertHasTheText ( Actor actor, String menuOption ) {
    Alert alert = as( actor ).getAlert();
    String alertText = alert.getText();
    alert.accept();

    actor.attemptsTo(
      Ensure.that(
        alertText
      ).contains( menuOption )
    );
  }

  @Subject("{0} verify that the third course price is {1}")
  public static <T extends Actor> void ensureThatTheThirdPriceValue ( Actor actor, int price ) {
    actor.attemptsTo(
      Ensure.that(
        COURSE_THIRD_PRICE
      ).text().contains( "" + price )
    );
  }

  @Subject("{0} verify that the textbox show/hide is displayed")
  public static <T extends Actor> void ensureThatTheTextboxIsDisplayed ( Actor actor ) {
    actor.attemptsTo(
      Ensure.that(
        TEXTBOX_SHOW_HIDE
      ).isDisplayed()
    );
  }

  @Subject("{0} verify that the textbox show/hide is displayed")
  public static <T extends Actor> void ensureThatTheTextboxIsNotDisplayed ( Actor actor ) {
    actor.attemptsTo(
      Ensure.that(
        TEXTBOX_SHOW_HIDE
      ).isNotDisplayed()
    );
  }

  @Subject("{0} verify that the textbox show/hide is displayed")
  public static <T extends Actor> void ensureThatTheContextualMenuIsDisplayed ( Actor actor ) {
    actor.attemptsTo(
      Ensure.that(
        MENU_MOUSE_OVER
      ).isDisplayed()
    );
  }

  @Subject("{0} verify that the loaded page has the correct title")
  public static <T extends Actor> void ensureThatTheLoadedPageHasTheTitle ( Actor actor, String pageTitle ) {
    actor.attemptsTo(
      Ensure.that(
        IFRAME_PAGE_TITLE
      ).text().contains( pageTitle.toUpperCase() )
    );
  }
}
