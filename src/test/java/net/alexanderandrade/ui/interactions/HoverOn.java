package net.alexanderandrade.ui.interactions;

import net.alexanderandrade.ui.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HoverOn implements Interaction {
  private final Target target;

  public HoverOn(Target target ) {
    this.target = target;
  }

  @Override public <T extends Actor> void performAs ( T actor ) {
    actor.attemptsTo(
      Scroll.to( target ),
      HoverOverTarget.over( target )
    );
  }

  public static HoverOn target (Target target ) {
    return new HoverOn( target );
  }
}
