package com.automation.qa.screenplay.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

import static com.automation.qa.screenplay.web.userinterface.SearchComponent.SEARCH_RESULT_TITLES;

/**
 * Pregunta por los titulos de los resultados devueltos por el buscador.
 * Se usa en el Caso de Prueba 3 para validar que los resultados
 * corresponden al termino buscado.
 */
public class TheSearchResults implements Question<Collection<String>> {

    public static TheSearchResults titles() {
        return new TheSearchResults();
    }

    @Override
    public Collection<String> answeredBy(Actor actor) {
        return Text.ofEach(SEARCH_RESULT_TITLES).answeredBy(actor);
    }
}
