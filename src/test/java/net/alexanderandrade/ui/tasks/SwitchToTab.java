package net.alexanderandrade.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static net.serenitybdd.core.Serenity.getDriver;

public class SwitchToTab implements Task {
  private final int tabIndex;

  public SwitchToTab(int tabIndex) {
    this.tabIndex = tabIndex;
  }

  public static SwitchToTab withIndex(int tabIndex) {
    return Tasks.instrumented(SwitchToTab.class, tabIndex);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    WebDriver driver = getDriver();
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(tabIndex));
  }
}
