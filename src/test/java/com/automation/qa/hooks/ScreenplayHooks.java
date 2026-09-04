package com.automation.qa.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;

/**
 * Prepara el "escenario" (Stage) de Screenplay antes de cada escenario de Cucumber,
 * de forma que los step definitions puedan invocar theActorCalled(...) /
 * theActorInTheSpotlight() sin preocuparse por el ciclo de vida del reparto (Cast).
 */
public class ScreenplayHooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new net.serenitybdd.screenplay.actors.OnlineCast());
    }
}
