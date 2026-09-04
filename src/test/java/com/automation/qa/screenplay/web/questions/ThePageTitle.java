package com.automation.qa.screenplay.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Pregunta por el titulo actual de la pagina cargada en el navegador.
 * Se usa en el Caso de Prueba 1 para validar que la home de selenium.dev
 * muestra el titulo esperado.
 */
public class ThePageTitle implements Question<String> {

    public static ThePageTitle isDisplayed() {
        return new ThePageTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getTitle();
    }
}
