package com.automation.qa.screenplay.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Pregunta por la URL actual del navegador. Se usa en el Caso de Prueba 2
 * para confirmar que la navegacion a "Documentation" cargo la pagina
 * esperada.
 */
public class TheCurrentUrl implements Question<String> {

    public static TheCurrentUrl value() {
        return new TheCurrentUrl();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }
}
