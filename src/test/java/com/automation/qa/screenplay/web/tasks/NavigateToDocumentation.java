package com.automation.qa.screenplay.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automation.qa.screenplay.web.userinterface.DocumentationPage.DOC_PAGE_HEADING;
import static com.automation.qa.screenplay.web.userinterface.HomePage.DOCUMENTATION_NAV_LINK;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Caso de Prueba 2: hace clic en el enlace "Documentation" de la barra de
 * navegacion y valida (junto a la Question correspondiente) que la pagina
 * de destino cargo correctamente.
 */
public class NavigateToDocumentation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DOCUMENTATION_NAV_LINK),
                WaitUntil.the(DOC_PAGE_HEADING, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static NavigateToDocumentation fromTheNavBar() {
        return new NavigateToDocumentation();
    }
}
