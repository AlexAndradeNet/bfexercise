/**
 * Alexander Andrade CONFIDENTIAL
 * <p>Copyright (c) 2022 . All Rights Reserved.
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import net.alexanderandrade.ui.tasks.HomeTasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;

import static net.serenitybdd.core.Serenity.getDriver;

public class SharedStepsDefinitions {

  @Before(order = 0) public void setTheStage ( Scenario scenario ) {
    OnStage.setTheStage( new OnlineCast() );
  }

  @AfterAll public static void afterAll () {
    getDriver().quit();
  }

  @Given("the {actor} is in the home page") public void theActorIsInTheHomePage ( @NotNull Actor actor ) {
    actor.wasAbleTo( HomeTasks.open() );
  }
}
