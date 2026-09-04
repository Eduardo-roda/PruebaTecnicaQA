package com.automation.qa.screenplay.api.tasks;

import com.automation.qa.config.EnvironmentConfig;
import com.automation.qa.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

/**
 * Caso de Prueba 6: actualiza los datos de un usuario existente a traves
 * de la API de reqres.in y valida la respuesta y su contenido.
 */
public class UpdateAUser implements Task {

    private final int userId;
    private final User user;

    public UpdateAUser(int userId, User user) {
        this.userId = userId;
        this.user = user;
    }

    public static UpdateAUser identifiedBy(int userId) {
        return new UpdateAUser(userId, null);
    }

    public UpdateAUser withDetails(String name, String job) {
        return new UpdateAUser(this.userId, new User(name, job));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/" + userId)
                        .with(request -> request
                                .header("x-api-key", EnvironmentConfig.apiKey())
                                .body(user))
        );
    }
}
