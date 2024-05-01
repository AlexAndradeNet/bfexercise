package net.alexanderandrade.ui.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;

public class WaitForPageLoad implements Interaction {

  @Override public <T extends Actor> void performAs ( T actor ) {
    WebDriver driver = getDriver();
    var js = (JavascriptExecutor) driver;
    new WebDriverWait( driver, Duration.ofSeconds( 10 ) ).until( webDriver -> js.executeScript( "return document.readyState" ).equals( "complete" ) );
  }

  public static Interaction complete () {
    return new WaitForPageLoad();
  }
}
