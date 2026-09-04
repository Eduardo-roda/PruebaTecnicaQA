package com.automation.qa.screenplay.web.tasks;

import com.automation.qa.config.EnvironmentConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automation.qa.screenplay.web.userinterface.HomePage.NAVBAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class OpenTheHomePage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(EnvironmentConfig.webBaseUrl()),
                WaitUntil.the(NAVBAR, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static OpenTheHomePage homePage() {
        return new OpenTheHomePage();
    }
}
