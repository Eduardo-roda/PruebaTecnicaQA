package com.automation.qa.stepdefinitions.web;

import com.automation.qa.screenplay.web.questions.TheCurrentUrl;
import com.automation.qa.screenplay.web.tasks.NavigateToDocumentation;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.automation.qa.screenplay.web.userinterface.DocumentationPage.DOC_PAGE_HEADING;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.containsString;

public class NavigationSteps {

    @Cuando("Jorge hace clic en el enlace {string} del menú de navegación")
    public void jorgeHaceClicEnElEnlaceDelMenu(String linkName) {
        OnStage.theActorInTheSpotlight().attemptsTo(NavigateToDocumentation.fromTheNavBar());
    }

    @Entonces("Jorge debería ser dirigido a una página cuya URL contiene {string}")
    public void jorgeDeberiaSerDirigidoAUnaPaginaCuyaUrlContiene(String urlFragment) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCurrentUrl.value(), containsString(urlFragment))
        );
    }

    @Y("la página de documentación debería mostrar contenido visible")
    public void laPaginaDeDocumentacionDeberiaMostrarContenidoVisible() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(DOC_PAGE_HEADING).isDisplayed()
        );
    }
}
