package com.automation.qa.stepdefinitions.api;

import com.automation.qa.config.EnvironmentConfig;
import com.automation.qa.screenplay.api.questions.TheResponse;
import com.automation.qa.screenplay.api.tasks.CreateAUser;
import com.automation.qa.screenplay.api.tasks.ListUsers;
import com.automation.qa.screenplay.api.tasks.UpdateAUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class UsersApiSteps {

    @Dado("que el Cliente API está listo para interactuar con {string}")
    public void queElClienteApiEstaListoParaInteractuarCon(String baseUrl) {
        Actor clienteApi = OnStage.theActorCalled("Cliente API");
        clienteApi.can(CallAnApi.at(EnvironmentConfig.apiBaseUrl()));
    }

    // ---------------------------------------------------------------
    // Caso de Prueba 4: listar usuarios
    // ---------------------------------------------------------------

    @Cuando("el Cliente API solicita el listado de usuarios de la página {int}")
    public void elClienteApiSolicitaElListadoDeUsuariosDeLaPagina(int page) {
        OnStage.theActorInTheSpotlight().attemptsTo(ListUsers.onPage(page));
    }

    @Entonces("la respuesta debería tener el código de estado {int}")
    public void laRespuestaDeberiaTenerElCodigoDeEstado(int expectedStatusCode) {
        Assertions.assertThat(TheResponse.received().getStatusCode()).isEqualTo(expectedStatusCode);
    }

    @Y("la respuesta debería contener un listado de usuarios no vacío")
    public void laRespuestaDeberiaContenerUnListadoDeUsuariosNoVacio() {
        List<Map<String, Object>> data = TheResponse.received().jsonPath().getList("data");
        Assertions.assertThat(data).isNotEmpty();
    }

    @Y("cada usuario del listado debería tener los campos {string}, {string}, {string} y {string}")
    public void cadaUsuarioDelListadoDeberiaTenerLosCampos(String campo1, String campo2, String campo3, String campo4) {
        List<Map<String, Object>> data = TheResponse.received().jsonPath().getList("data");
        List<String> camposEsperados = List.of(campo1, campo2, campo3, campo4);

        Assertions.assertThat(data).isNotEmpty();
        data.forEach(usuario ->
                camposEsperados.forEach(campo ->
                        Assertions.assertThat(usuario)
                                .as("El usuario %s deberia contener el campo '%s'", usuario, campo)
                                .containsKey(campo)));
    }

    @Y("el campo {string} de la respuesta debería ser {int}")
    public void elCampoDeLaRespuestaDeberiaSer(String campo, int valorEsperado) {
        JsonPath json = TheResponse.received().jsonPath();
        Assertions.assertThat(json.getInt(campo)).isEqualTo(valorEsperado);
    }

    // ---------------------------------------------------------------
    // Caso de Prueba 5: crear usuario
    // ---------------------------------------------------------------

    @Cuando("el Cliente API crea un nuevo usuario llamado {string} con el puesto {string}")
    public void elClienteApiCreaUnNuevoUsuarioLlamadoConElPuesto(String nombre, String puesto) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateAUser.withDetails(nombre, puesto));
    }

    @Y("la respuesta debería contener el nombre {string} y el puesto {string}")
    public void laRespuestaDeberiaContenerElNombreYElPuesto(String nombreEsperado, String puestoEsperado) {
        JsonPath json = TheResponse.received().jsonPath();
        Assertions.assertThat(json.getString("name")).isEqualTo(nombreEsperado);
        Assertions.assertThat(json.getString("job")).isEqualTo(puestoEsperado);
    }

    @Y("la respuesta debería contener un {string} y una fecha de creación {string}")
    public void laRespuestaDeberiaContenerUnIdYUnaFechaDeCreacion(String campoId, String campoFecha) {
        JsonPath json = TheResponse.received().jsonPath();
        Assertions.assertThat(json.getString(campoId)).isNotBlank();
        Assertions.assertThat(json.getString(campoFecha)).isNotBlank();
    }

    // ---------------------------------------------------------------
    // Caso de Prueba 6: actualizar usuario
    // ---------------------------------------------------------------

    @Cuando("el Cliente API actualiza al usuario con id {int} con el nombre {string} y el puesto {string}")
    public void elClienteApiActualizaAlUsuarioConIdConElNombreYElPuesto(int userId, String nombre, String puesto) {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateAUser.identifiedBy(userId).withDetails(nombre, puesto));
    }

    @Y("la respuesta debería contener una fecha de actualización {string}")
    public void laRespuestaDeberiaContenerUnaFechaDeActualizacion(String campoFecha) {
        JsonPath json = TheResponse.received().jsonPath();
        Assertions.assertThat(json.getString(campoFecha)).isNotBlank();
    }
}
