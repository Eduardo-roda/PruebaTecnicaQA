package com.automation.qa.screenplay.api.tasks;

import com.automation.qa.config.EnvironmentConfig;
import com.automation.qa.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

/**
 * Caso de Prueba 5: crea un nuevo usuario a traves de la API de reqres.in.
 */
public class CreateAUser implements Task {

    private final User user;

    public CreateAUser(User user) {
        this.user = user;
    }

    public static CreateAUser withDetails(String name, String job) {
        return new CreateAUser(new User(name, job));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(request -> request
                                .header("x-api-key", EnvironmentConfig.apiKey())
                                .body(user))
        );
    }
}
