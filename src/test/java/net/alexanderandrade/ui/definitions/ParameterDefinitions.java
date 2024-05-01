package net.alexanderandrade.ui.definitions;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterDefinitions {

  @ParameterType("Elizabeth|Verena|Alexander")
  public Actor actor(String actor) {
    return OnStage.theActorCalled(actor);
  }
}
