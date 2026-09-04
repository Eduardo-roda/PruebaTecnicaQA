package com.automation.qa.stepdefinitions.web;

import com.automation.qa.screenplay.web.questions.ThePageTitle;
import com.automation.qa.screenplay.web.tasks.OpenTheHomePage;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class HomePageSteps {

    @Dado("que Jorge visita la página de inicio de {string}")
    public void jorgeVisitaLaPaginaDeInicio(String url) {
        Actor jorge = OnStage.theActorCalled("Jorge");
        jorge.can(BrowseTheWeb.with(Serenity.getDriver()));
        jorge.attemptsTo(OpenTheHomePage.homePage());
    }

    @Entonces("la página debería mostrar el título {string}")
    public void laPaginaDeberiaMostrarElTitulo(String expectedTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.isDisplayed(), equalTo(expectedTitle))
        );
    }
}
