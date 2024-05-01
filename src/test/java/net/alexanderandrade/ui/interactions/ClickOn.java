package net.alexanderandrade.ui.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOn implements Interaction {
  private final Target target;

  public ClickOn ( Target target ) {
    this.target = target;
  }

  @Override public <T extends Actor> void performAs ( T actor ) {
    actor.attemptsTo( Click.on( target ) );
  }

  public static ClickOn target ( Target target ) {
    return new ClickOn( target );
  }
}
