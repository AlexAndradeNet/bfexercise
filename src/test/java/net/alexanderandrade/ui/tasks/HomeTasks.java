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
package net.alexanderandrade.ui.tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

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
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeTasks {

    @Managed private static final WebDriver driver = getDriver();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;

    private HomeTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} open the main page")
    public static Performable open() {
        return Task.where(
                "{0} open the main page",
                Open.browserOn().the(HomePage.class),
                WaitForPageLoad.complete(),
                WaitUntil.the(HomePage.TEXT_COUNTRY, isClickable()));
    }

    @Step("{0} select menu {1}")
    public static <T extends Actor> void selectMenu(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Enter.theValue(menuOption).into(HomePage.TEXT_COUNTRY),
                        WaitUntil.the(HomePage.MENU_COUNTRY.of(menuOption), isClickable()),
                        ClickOn.target(HomePage.MENU_COUNTRY.of(menuOption)));
    }

    @Step("{0} select dropdown {1}")
    public static <T extends Actor> void selectDropdown(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(new SelectByVisibleTextFromTarget(HomePage.SELECT, menuOption));
    }

    @Step("{0} select radio button {1}")
    public static <T extends Actor> void selectRadioButton(String radioButtonValue) {
        clickForced(HomePage.RADIO_BUTTON.of(radioButtonValue.toLowerCase()));
    }

    @Step("{0} select checkbox {1}")
    public static <T extends Actor> void selectCheckbox(String checkboxValue) {
        clickForced(HomePage.CHECKBOX.of(checkboxValue.toLowerCase()));
    }

    @Step("{0} force click on target")
    private static void clickForced(Target target) {
        WebElement webElement = createWebElementFromTarget(target);
        js.executeScript("arguments[0].click();", webElement);
    }

    private static WebElement createWebElementFromTarget(Target target) {
        return driver.findElement(By.xpath(target.getCssOrXPathSelector()));
    }

    @Step("{0} enter name {1} in alert")
    public static <T extends Actor> void alertName(String name) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Enter.theValue(name).into(HomePage.TEXTBOX_NAME),
                        ClickOn.target(HomePage.BUTTON_ALERT));
    }

    @Step("{0} confirm name {1}")
    public static <T extends Actor> void confirmName(String name) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Enter.theValue(name).into(HomePage.TEXTBOX_NAME),
                        ClickOn.target(HomePage.BUTTON_CONFIRM));
    }

    @Step("{0} hide object")
    public static <T extends Actor> void hideObject() {
        theActorInTheSpotlight().attemptsTo(ClickOn.target(HomePage.BUTTON_HIDE));
    }

    @Step("{0} show object")
    public static <T extends Actor> void showObject() {
        theActorInTheSpotlight().attemptsTo(ClickOn.target(HomePage.BUTTON_SHOW));
    }

    @Step("{0} hover over the button")
    public static <T extends Actor> void hoverOverTheButton() {
        theActorInTheSpotlight().attemptsTo(HoverOn.target(HomePage.BUTTON_MOUSE_OVER));
    }

    @Step("{0} navigate into iframe {1}")
    public static <T extends Actor> void navigateIntoIframe(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Scroll.to(HomePage.IFRAME),
                        Switch.toFrame(HomePage.IFRAME_NAME),
                        ClickOn.target(ExternalPage.MENU.of(menuOption)));
    }

    @Step("{0} open new window")
    public static <T extends Actor> void openNewWindow() {
        theActorInTheSpotlight().attemptsTo(ClickOn.target(HomePage.BUTTON_OPEN_WINDOW));
    }

    @Step("{0} open new tab")
    public static <T extends Actor> void openNewTab() {
        theActorInTheSpotlight().attemptsTo(ClickOn.target(HomePage.BUTTON_OPEN_TAB));
    }

    @Step("{0} go to new window and wait before clicking on link {1}")
    public static <T extends Actor> void goToNewWindowAndWaitBeforeClickOnLink(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        WaitForNewPageOrTabAndSwitch.andSwitch(),
                        ClickOn.target(ExternalPage.MENU.of(menuOption)));
    }

    @Step("{0} go to new tab and wait before clicking on link {1}")
    public static <T extends Actor> void goToNewTabAndWaitBeforeClickOnLink(String menuOption) {
        theActorInTheSpotlight()
                .attemptsTo(
                        WaitForNewPageOrTabAndSwitch.andSwitch(),
                        ClickOn.target(ExternalPage.MENU.of(menuOption)));
    }

    @Step("{0} return to the default context")
    public static <T extends Actor> void returnToTheDefaultContext() {
        theActorInTheSpotlight().attemptsTo(Switch.toDefaultContext());
    }

    @Step("{0} wait for {1} seconds")
    public static <T extends Actor> void waitForSeconds(int seconds) {
        synchronized (theActorInTheSpotlight()) {
            try {
                theActorInTheSpotlight().wait(seconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
