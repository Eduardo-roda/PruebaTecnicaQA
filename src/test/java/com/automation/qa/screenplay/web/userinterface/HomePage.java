package com.automation.qa.screenplay.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Elementos de la pagina de inicio (https://www.selenium.dev) y de la barra de
 * navegacion superior, compartida por todas las paginas del sitio.
 *
 * NOTA: los selectores fueron definidos a partir de la estructura publica del
 * sitio (Hugo/Docsy). Si el sitio cambia su markup, solo es necesario ajustar
 * los selectores en esta clase, sin tocar tareas ni step definitions.
 */
public class HomePage {

    public static final String URL = "https://www.selenium.dev";

    public static final Target PAGE_MAIN_HEADING =
            Target.the("titular principal de la pagina de inicio")
                    .locatedBy("h1");

    public static final Target NAVBAR = Target.the("barra de navegacion superior").locatedBy("header");

    public static final Target DOCUMENTATION_NAV_LINK =
            Target.the("enlace 'Documentation' de la barra de navegacion")
                    .locatedBy("header a[href*='/documentation']");

    public static final Target ABOUT_NAV_LINK =
            Target.the("enlace 'About' de la barra de navegacion")
                    .locatedBy("header a[href*='/about']");
}
