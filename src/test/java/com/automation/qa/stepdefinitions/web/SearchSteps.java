package com.automation.qa.stepdefinitions.web;

import com.automation.qa.screenplay.web.questions.TheSearchResults;
import com.automation.qa.screenplay.web.tasks.SearchFor;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import org.assertj.core.api.Assertions;

import java.util.Collection;

public class SearchSteps {

    private String ultimoTerminoBuscado;

    @Cuando("Jorge busca el término {string}")
    public void jorgeBuscaElTermino(String searchTerm) {
        this.ultimoTerminoBuscado = searchTerm;
        OnStage.theActorInTheSpotlight().attemptsTo(SearchFor.theTerm(searchTerm));
    }

    @Entonces("debería ver al menos un resultado")
    public void deberiaVerAlMenosUnResultado() {
        Collection<String> resultados = TheSearchResults.titles().answeredBy(OnStage.theActorInTheSpotlight());
        Assertions.assertThat(resultados).isNotEmpty();
    }

    @Y("cada resultado mostrado debería estar relacionado con {string}")
    public void cadaResultadoMostradoDeberiaEstarRelacionadoCon(String searchTerm) {
        Collection<String> resultados = TheSearchResults.titles().answeredBy(OnStage.theActorInTheSpotlight());

        Assertions.assertThat(resultados)
                .as("Los resultados de busqueda para '%s' no deberian estar vacios", searchTerm)
                .isNotEmpty();

        // Al menos uno de los resultados visibles debe contener el termino
        // buscado (o una de sus palabras) en su titulo. DocSearch es un motor
        // de busqueda semantico/indexado, por lo que exigir coincidencia
        // exacta en el 100% de los resultados generaria falsos negativos.
        boolean algunoRelacionado = resultados.stream()
                .anyMatch(titulo -> titulo.toLowerCase().contains(searchTerm.toLowerCase()));

        Assertions.assertThat(algunoRelacionado)
                .as("Se esperaba que al menos un resultado contuviera el termino '%s'. Resultados obtenidos: %s",
                        searchTerm, resultados)
                .isTrue();
    }
}
