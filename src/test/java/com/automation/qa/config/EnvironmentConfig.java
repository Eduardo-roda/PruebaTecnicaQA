package com.automation.qa.config;

/**
 * Punto centralizado para leer configuracion (URLs base, flags) definida en
 * serenity.conf o sobreescrita por linea de comandos, p.ej.:
 * mvn clean verify -Dweb.base.url=https://www.selenium.dev -Dapi.base.url=https://reqres.in
 */
public final class EnvironmentConfig {

    private EnvironmentConfig() {
    }

    public static String webBaseUrl() {
        String fromSystemProperty = System.getProperty("web.base.url");
        return fromSystemProperty != null ? fromSystemProperty : "https://www.selenium.dev";
    }

    public static String apiBaseUrl() {
        String fromSystemProperty = System.getProperty("api.base.url");
        return fromSystemProperty != null ? fromSystemProperty : "https://reqres.in";
    }

    /**
     * reqres.in exige actualmente una cabecera "x-api-key" en cada peticion
     * (ver https://reqres.in/docs). La clave NUNCA se codifica en el
     * repositorio: se obtiene de la variable de entorno REQRES_API_KEY o de
     * la propiedad de sistema -Dapi.key=... (ver README para como
     * conseguirla gratis en https://app.reqres.in).
     */
    public static String apiKey() {
        String fromSystemProperty = System.getProperty("api.key");
        if (fromSystemProperty != null && !fromSystemProperty.isBlank()) {
            return fromSystemProperty;
        }
        String fromEnv = System.getenv("REQRES_API_KEY");
        return fromEnv != null ? fromEnv : "";
    }
}
