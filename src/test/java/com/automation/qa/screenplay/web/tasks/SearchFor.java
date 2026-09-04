package com.automation.qa.screenplay.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.automation.qa.screenplay.web.userinterface.SearchComponent.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Caso de Prueba 3: abre el buscador del sitio, escribe un termino y
 * confirma la busqueda. Los resultados se validan posteriormente con la
 * Question TheSearchResults.
 */
public class SearchFor implements Task {

    private final String searchTerm;

    public SearchFor(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public static SearchFor theTerm(String searchTerm) {
        return new SearchFor(searchTerm);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SEARCH_TRIGGER_BUTTON),
                WaitUntil.the(SEARCH_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(searchTerm).into(SEARCH_INPUT).thenHit(Keys.ENTER),
                WaitUntil.the(SEARCH_RESULTS_LIST, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
