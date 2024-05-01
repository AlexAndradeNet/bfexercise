/**
 * Alexander Andrade CONFIDENTIAL
 *
 * <p>Copyright (c) 2022 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.questions;

import net.alexanderandrade.ui.ui.ExternalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ExternalQuestions {

  private ExternalQuestions() {
    throw new IllegalStateException("Utility class");
  }

  @Subject("{0} verify that the loaded page has the correct title")
  public static <T extends Actor> void ensureThatTheLoadedPageHasTheTitle ( Actor actor, String pageTitle ) {
    actor.attemptsTo( Ensure.that( Text.of( ExternalPage.PAGE_TITLE_PRINCIPAL).answeredBy( actor )).contains( pageTitle ) );
  }

  @Subject("{0} verify that the loaded page has the correct title")
  public static <T extends Actor> void ensureThatTheLoadedPageHasTheMainTitle ( Actor actor, String pageTitle ) {
    actor.attemptsTo( Ensure.that( Text.of( ExternalPage.PAGE_TITLE).answeredBy( actor )).contains( pageTitle ) );
  }
}
