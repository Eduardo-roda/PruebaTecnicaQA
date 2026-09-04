package com.automation.qa.screenplay.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Elementos propios de la seccion de documentacion
 * (https://www.selenium.dev/documentation).
 */
public class DocumentationPage {

    public static final String URL_FRAGMENT = "/documentation";

    public static final Target DOC_PAGE_HEADING =
            Target.the("titular de la pagina de documentacion")
                    .locatedBy("h1, .td-content h1");

    public static final Target DOC_SIDEBAR_MENU =
            Target.the("menu lateral de documentacion")
                    .locatedBy("nav#TableOfContents, aside, nav.td-sidebar-nav");
}
