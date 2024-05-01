package net.alexanderandrade.ui.questions;

import net.alexanderandrade.ui.ui.ExternalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class GetExternalPageTitle implements Question<String> {

  @Override public String answeredBy ( Actor actor ) {
    return Text.of( ExternalPage.PAGE_TITLE ).answeredBy( actor );
  }

  public static GetExternalPageTitle mainTitle () {
    return new GetExternalPageTitle();
  }
}
