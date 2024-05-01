package net.alexanderandrade.ui.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;

public class WaitForNewPageOrTabAndSwitch implements Interaction {

  @Override public <T extends Actor> void performAs ( T actor ) {
    WebDriver driver = getDriver();
    String originalHandle = driver.getWindowHandle();
    WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );
    wait.until( windowsOrTabs -> driver.getWindowHandles().size() > 1 );

    for ( String handle : driver.getWindowHandles() ) {
      if ( !handle.equals( originalHandle ) ) {
        driver.switchTo().window( handle );
        WaitForPageLoad.complete().performAs( actor );
        break;
      }
    }
  }

  public static Interaction andSwitch () {
    return new WaitForNewPageOrTabAndSwitch();
  }
}

