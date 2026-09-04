package com.automation.qa.screenplay.api.questions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

/**
 * Punto de acceso a la ultima respuesta HTTP recibida por el actor que
 * tiene la habilidad CallAnApi. Se apoya en SerenityRest, que Screenplay
 * REST utiliza internamente para registrar cada llamada (y que Serenity
 * BDD adjunta automaticamente al reporte).
 */
public final class TheResponse {

    private TheResponse() {
    }

    public static Response received() {
        return SerenityRest.lastResponse();
    }

    public static int statusCode() {
        return received().getStatusCode();
    }

    public static long responseTimeInMillis() {
        return received().getTime();
    }
}
