package com.automation.qa.screenplay.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

/**
 * El sitio selenium.dev utiliza Algolia DocSearch para su buscador (icono de
 * lupa en el header que abre un modal con un campo de texto y resultados).
 *
 * IMPORTANTE: si el proveedor de busqueda o su markup cambian, este es el
 * unico lugar del proyecto que debe actualizarse (principio Page Object /
 * Screenplay: separar "donde estan los elementos" de "que hace la prueba").
 */
public class SearchComponent {

    public static final Target SEARCH_TRIGGER_BUTTON =
            Target.the("boton/icono que abre el buscador")
                    .locatedBy(".DocSearch-Button, button[aria-label='Search'], [aria-label='Search']");

    public static final Target SEARCH_INPUT =
            Target.the("campo de texto de busqueda")
                    .locatedBy(".DocSearch-Input, input[type='search']");

    public static final Target SEARCH_RESULTS_LIST =
            Target.the("lista de resultados de busqueda")
                    .locatedBy(".DocSearch-Hits, #docsearch-list, ul[role='listbox']");

    public static final Target SEARCH_RESULT_TITLES =
            Target.the("titulos de cada resultado de busqueda")
                    .locatedBy(".DocSearch-Hit-title, .DocSearch-Hit a");

    public static final Target NO_RESULTS_MESSAGE =
            Target.the("mensaje de 'sin resultados'")
                    .locatedBy(".DocSearch-NoResults, .DocSearch-NoResults-Prefill");
}
