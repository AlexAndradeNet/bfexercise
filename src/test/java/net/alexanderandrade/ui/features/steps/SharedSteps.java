/**
 * Alexander Andrade CONFIDENTIAL
 * <p>Copyright (c) 2022 . All Rights Reserved.
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.features.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import net.alexanderandrade.ui.screenplay.tasks.homepage.HomeTasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.jetbrains.annotations.NotNull;

public class SharedSteps {
  @Before(order = 0) public void setTheStage ( Scenario scenario ) {
    OnStage.setTheStage( new OnlineCast() );
  }

  @Given("the {actor} is in the home page") public void theActorIsInTheHomePage ( @NotNull Actor actor ) {
    actor.wasAbleTo( HomeTasks.open() );
  }
}
