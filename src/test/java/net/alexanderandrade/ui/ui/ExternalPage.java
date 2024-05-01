package net.alexanderandrade.ui.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ExternalPage {
  public static final Target MENU = Target.the( "menu {0} into Iframe" ).locatedBy( "(//a[contains(text(), '{0}')])[1]" );

  public static final Target PAGE_TITLE = Target.the( "New page title" ).locatedBy( "//h1" );
}
