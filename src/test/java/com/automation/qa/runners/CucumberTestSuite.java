package com.automation.qa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Punto de entrada unico de la suite de pruebas.
 * Serenity BDD se encarga de instrumentar Cucumber para generar
 * los reportes vivos (living documentation) al finalizar la ejecucion.
 *
 * Ejecucion completa:      mvn clean verify
 * Solo pruebas web:        mvn clean verify -Dtags="@web"
 * Solo pruebas de API:     mvn clean verify -Dtags="@api"
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.qa.stepdefinitions", "com.automation.qa.hooks"},
        plugin = {"pretty"},
        tags = "not @wip"
)
public class CucumberTestSuite {
}
