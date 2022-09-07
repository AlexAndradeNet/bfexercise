package net.alexanderandrade.ui.features.steps;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterDefinitions {

  @ParameterType("Elizabeth|Verena|Alexander")
  public Actor actor(String actor) {
    return OnStage.theActorCalled(actor);
  }
}
