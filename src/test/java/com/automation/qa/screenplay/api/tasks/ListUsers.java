package com.automation.qa.screenplay.api.tasks;

import com.automation.qa.config.EnvironmentConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

/**
 * Caso de Prueba 4: obtiene el listado de usuarios de la API de reqres.in.
 */
public class ListUsers implements Task {

    private final int page;

    public ListUsers(int page) {
        this.page = page;
    }

    public static ListUsers onPage(int page) {
        return new ListUsers(page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users?page=" + page)
                        .with(request -> request.header("x-api-key", EnvironmentConfig.apiKey()))
        );
    }
}
