/**
 * Alexander Andrade CONFIDENTIAL
 *
 * <p>Copyright (c) 2022 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.screenplay.ui.homepage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

	private HomePage() {
		super();
	}

	public static final Target RADIO_BUTTON =
		Target.the("radio button {0}")
			.locatedBy( "//input[@type='radio' and @value='{0}']");

  public static final Target TEXT_COUNTRY =
    Target.the("textbox country {0}")
      .locatedBy( "//input[@type='text' and @id='autocomplete']");

  public static final Target MENU_COUNTRY =
    Target.the("menu country option {0}")
      .locatedBy( "//div[@class='ui-menu-item-wrapper' and text()='{0}']");

  public static final Target SELECT =
    Target.the("select option {0}")
      .locatedBy( "//select[@id='dropdown-class-example']");

  public static final Target CHECKBOX =
    Target.the("check option {0}")
      .locatedBy( "//input[@type='checkbox' and @value='{0}']");

  public static final Target TEXTBOX_NAME =
    Target.the("textbox name")
      .locatedBy( "//input[@type='text' and @id='name']");

  public static final Target BUTTON_ALERT =
    Target.the("button alert")
      .locatedBy( "//input[@type='submit' and @id='alertbtn']");

  public static final Target BUTTON_CONFIRM =
    Target.the("button confirm")
      .locatedBy( "//input[@type='submit' and @id='confirmbtn']");

  public static final Target COURSE_THIRD_PRICE =
    Target.the("third course price")
      .locatedBy( "//table[@name='courses']/tbody/tr[4]/td[3]");

  public static final Target TEXTBOX_SHOW_HIDE =
    Target.the("textbox show/hide for toggle")
      .locatedBy( "//input[@type='text' and @id='displayed-text']");

  public static final Target BUTTON_HIDE =
    Target.the("button hide textbox")
      .locatedBy( "//input[@type='submit' and @id='hide-textbox']");

  public static final Target BUTTON_SHOW =
    Target.the("button show textbox")
      .locatedBy( "//input[@type='submit' and @id='show-textbox']");

  public static final Target BUTTON_MOUSE_OVER =
    Target.the("button mouse over")
      .locatedBy( "//button[@id='mousehover']");

  public static final Target MENU_MOUSE_OVER =
    Target.the("menu mouse over")
      .locatedBy( "//div[@class='mouse-hover-content']");

  public static final String IFRAME_NAME = "iframe-name";

  public static final Target IFRAME_MENU =
    Target.the("menu {0} into Iframe")
      .locatedBy( "(//a[text()='{0}'])[1]");

  public static final Target IFRAME_PAGE_TITLE =
    Target.the("Iframe page title")
      .locatedBy( "//h1");

}
