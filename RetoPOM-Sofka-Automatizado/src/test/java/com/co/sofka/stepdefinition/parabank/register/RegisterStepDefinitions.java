package com.co.sofka.stepdefinition.parabank.register;

import com.co.sofka.model.RegisterModel;
import com.co.sofka.page.parabank.MainPage;
import com.co.sofka.page.parabank.RegisterPage;
import com.co.sofka.stepdefinition.setup.SetUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class RegisterStepDefinitions extends SetUp {

    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinitions.class);
    private MainPage mainPage;
    private RegisterPage registerPage;
    private RegisterModel registerModel;

    //Expected Messages
    private final String EXPECTED_WELCOME_MESSAGE = "Your account was created successfully. You are now logged in.";
    private final String EXPECTED_MESSAGER_USERNAME = "This username already exists.";

    @Given("que el usuario se encuentra en la pagina principal")
    public void queElUsuarioSeEncuentraEnLaPaginaPrincipal() {
        try {
            setUpWebDriver();
            generalSetUp();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }
    }

    @When("el usuario se dirige al apartado de registro y diligencia todos los campos del formulario y envia su informacion")
    public void elUsuarioSeDirigeAlApartadoDeRegistroYDiligenciaTodosLosCamposDelFormularioYEnviaSuInformacion(DataTable dataTable) {
        try {
            mainPage = new MainPage(webDriver);
            mainPage.goToRegister();
            List<List<String>> rows = dataTable.asLists(String.class);
            registerModel = new RegisterModel();
            registerModel.setFirstName(rows.get(1).get(0));
            registerModel.setLastName(rows.get(1).get(1));
            registerModel.setAddress(rows.get(1).get(2));
            registerModel.setCity(rows.get(1).get(3));
            registerModel.setState(rows.get(1).get(4));
            registerModel.setZipCode(rows.get(1).get(5));
            registerModel.setSocialSecurityNumber(rows.get(1).get(6));
            registerModel.setUserName(rows.get(1).get(7));
            registerModel.setPassword(rows.get(1).get(8));
            registerModel.setConfirmPassword(rows.get(1).get(9));
            registerPage = new RegisterPage(webDriver, registerModel);
            registerPage.fillRegisterForm();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }

    }

    @Then("el sistema deberia de mostrarle un mensaje de bienvenida")
    public void elSistemaDeberiaDeMostrarleUnMensajeDeBienvenida() {
        Assertions.assertEquals(EXPECTED_WELCOME_MESSAGE, registerPage.messageAssertionObtained());
        System.out.println("Mensaje esperado = " + EXPECTED_WELCOME_MESSAGE + "\n"
                + "Mensaje Obtenido = " + registerPage.messageAssertionObtained());
        closeDriver();
    }

    //@InvalidRegister
    @When("el usuario se dirige al apartado de registro y diligencia todos los campos del formulario con datos ya registrados")
    public void elUsuarioSeDirigeAlApartadoDeRegistroYDiligenciaTodosLosCamposDelFormularioConDatosYaRegistrados(DataTable dataTable) {
        try {
            mainPage = new MainPage(webDriver);
            mainPage.goToRegister();
            List<List<String>> rows = dataTable.asLists(String.class);
            registerModel = new RegisterModel();
            registerModel.setFirstName(rows.get(1).get(0));
            registerModel.setLastName(rows.get(1).get(1));
            registerModel.setAddress(rows.get(1).get(2));
            registerModel.setCity(rows.get(1).get(3));
            registerModel.setState(rows.get(1).get(4));
            registerModel.setZipCode(rows.get(1).get(5));
            registerModel.setSocialSecurityNumber(rows.get(1).get(6));
            registerModel.setUserName(rows.get(1).get(7));
            registerModel.setPassword(rows.get(1).get(8));
            registerModel.setConfirmPassword(rows.get(1).get(9));
            registerPage = new RegisterPage(webDriver, registerModel);
            registerPage.fillRegisterForm();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }
    }

    @Then("el sistema debera mostrarle un mensaje de que el username ya se encuentra previamente registrado")
    public void elSistemaDeberaMostrarleUnMensajeDeQueElUsernameYaSeEncuentraPreviamenteRegistrado() {
        Assertions.assertEquals(EXPECTED_MESSAGER_USERNAME, registerPage.messageUsernameExist());
        System.out.println("Mensaje esperado = " + EXPECTED_MESSAGER_USERNAME + "\n"
                + "Mensaje Obtenido = " + registerPage.messageUsernameExist());
        closeDriver();
    }
}
