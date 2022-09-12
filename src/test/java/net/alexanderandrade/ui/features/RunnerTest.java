/**
 * Alexander Andrade CONFIDENTIAL
 *
 * <p>Copyright (c) 2022 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.ui.features;

import static org.junit.Assert.assertTrue;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	features = "classpath:features",
  glue = "net.alexanderandrade.ui.features.steps",
  plugin = "pretty",
  tags = "not @ignore"
)

class RunnerTest {
  private RunnerTest () {
    super();
  }

  @Test public void test () {
    assertTrue(true);
  }

  /*@After
  //@AfterClass
  public void afterAll () {
    getDriver().quit();
  }*/
}
