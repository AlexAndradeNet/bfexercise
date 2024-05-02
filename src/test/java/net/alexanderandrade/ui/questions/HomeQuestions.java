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
package net.alexanderandrade.ui.questions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.alexanderandrade.ui.ui.ExternalPage;
import net.alexanderandrade.ui.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.AlertText;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;

public class HomeQuestions {

    private HomeQuestions() {
        throw new IllegalStateException("Utility class");
    }

    @Subject("{0} verify that the radio button option is selected")
    public static <T extends Actor> void ensureThatRadioButtonIsSelected(String radioButtonValue) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(
                                        Attribute.of(
                                                        HomePage.RADIO_BUTTON.of(
                                                                radioButtonValue.toLowerCase()))
                                                .named("selected")
                                                .asBoolean())
                                .isTrue());
    }

    @Subject("{0} verify that the menu option is selected")
    public static <T extends Actor> void ensureThatTheMenuOptionIsSelected(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(HomePage.TEXT_COUNTRY)
                                .value()
                                .asAString()
                                .contains(menuOption));
    }

    @Subject("{0} verify that the dropdown option is selected")
    public static <T extends Actor> void ensureThatTheDropdownOptionIsSelected(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(Ensure.that(HomePage.SELECT).text().asAString().contains(menuOption));
    }

    @Subject("{0} verify that the checkbox option is selected")
    public static <T extends Actor> void ensureThatTheCheckboxOptionIsSelected(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(
                                        Attribute.of(HomePage.CHECKBOX.of(menuOption.toLowerCase()))
                                                .named("checked")
                                                .asBoolean())
                                .isTrue());
    }

    @Subject("{0} verify that the alert has the text")
    public static <T extends Actor> void ensureThatTheAlertHasTheText(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(
                                        AlertText.currentlyVisible()
                                                .thenAccept()
                                                .answeredBy(theActorInTheSpotlight()))
                                .contains(menuOption));
    }

    @Subject("{0} verify that the third course price is {1}")
    public static <T extends Actor> void ensureThatTheThirdPriceValue(int price) {
        theActorInTheSpotlight()
                .attemptsTo(Ensure.that(HomePage.COURSE_THIRD_PRICE).text().contains("" + price));
    }

    @Subject("{0} verify that the textbox show/hide is displayed")
    public static <T extends Actor> void ensureThatTheTextboxIsDisplayed() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(HomePage.TEXTBOX_SHOW_HIDE).isDisplayed());
    }

    @Subject("{0} verify that the textbox show/hide is displayed")
    public static <T extends Actor> void ensureThatTheTextboxIsNotDisplayed() {
        theActorInTheSpotlight()
                .attemptsTo(Ensure.that(HomePage.TEXTBOX_SHOW_HIDE).isNotDisplayed());
    }

    @Subject("{0} verify that the textbox show/hide is displayed")
    public static <T extends Actor> void ensureThatTheContextualMenuIsDisplayed() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(HomePage.MENU_MOUSE_OVER).isDisplayed());
    }

    @Subject("{0} verify that the loaded page has the correct title")
    public static <T extends Actor> void ensureThatTheLoadedPageHasTheTitle(String pageTitle) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Ensure.that(ExternalPage.PAGE_TITLE)
                                .text()
                                .contains(pageTitle.toUpperCase()));
    }
}
