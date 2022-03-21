package com.co.sofka.stepdefinition.parabank.login;

import com.co.sofka.model.ForgotLoginInfoModel;
import com.co.sofka.model.LoginModel;
import com.co.sofka.page.parabank.ForgotLoginInfoPage;
import com.co.sofka.page.parabank.LoginPage;
import com.co.sofka.stepdefinition.setup.SetUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class LoginStepDefinitions extends SetUp {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinitions.class);
    private LoginPage loginPage;
    private LoginModel loginModel;
    private ForgotLoginInfoPage forgotLoginInfoPage;
    private ForgotLoginInfoModel forgotLoginInfoModel;
    //Resultados Esperados
    private final Boolean EXPECTED_STATE_ACCOUNT_VIEW = true;
    private final String EXPECTED_MESSAGE_FORGOT_LOGIN = "Your login information was located successfully. You are now logged in. ";

    //Scenario:@SuccesfullyLogin
    @Given("que el usuario se encuentra en la pagina principal del portal")
    public void queElUsuarioSeEncuentraEnLaPaginaPrincipalDelPortal() {
        try {
            setUpWebDriver();
            generalSetUp();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }
    }

    @When("se dirige al apartado de login e ingresa sus credenciales")
    public void seDirigeAlApartadoDeLoginEIngresaSusCredenciales(DataTable dataTable) {
        try {
            //Convertir Datatable a lista
            List<List<String>> rows = dataTable.asLists(String.class);
            loginModel = new LoginModel();
            loginModel.setUsername(rows.get(1).get(0));
            loginModel.setPassword(rows.get(1).get(1));
            loginPage = new LoginPage(webDriver, loginModel);
            loginPage.fillLoginCredentials();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }
    }


    @Then("el sistema deberia llevarlo al apartado de su resumen de cuentas")
    public void elSistemaDeberiaLlevarloAlApartadoDeSuResumenDeCuentas() {
        Assertions.assertEquals(EXPECTED_STATE_ACCOUNT_VIEW, loginPage.assertionAccountOvervies());
        System.out.println("Valor esperado del elemento = " + EXPECTED_STATE_ACCOUNT_VIEW + "\n"
                + "Valor Obtenido = " + loginPage.assertionAccountOvervies());
        closeDriver();
    }

    //Scenario:@ForgotInfoLogin
    @When("se dirige al apartado de forgot login info y diligencia el formulario")
    public void seDirigeAlApartadoDeForgotLoginInfoYDiligenciaElFormulario(DataTable dataTable) {
        try {
            //Convertir Datatable a lista
            List<List<String>> rows = dataTable.asLists(String.class);
            forgotLoginInfoModel = new ForgotLoginInfoModel();
            forgotLoginInfoModel.setFirstName(rows.get(1).get(0));
            forgotLoginInfoModel.setLastName(rows.get(1).get(1));
            forgotLoginInfoModel.setAddress(rows.get(1).get(2));
            forgotLoginInfoModel.setCity(rows.get(1).get(3));
            forgotLoginInfoModel.setState(rows.get(1).get(4));
            forgotLoginInfoModel.setZipCode(rows.get(1).get(5));
            forgotLoginInfoModel.setSocialSecurityNumber(rows.get(1).get(6));
            forgotLoginInfoPage = new ForgotLoginInfoPage(webDriver, forgotLoginInfoModel);
            forgotLoginInfoPage.fillForgotLoginForm();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }
    }

    @Then("el sistema deberia mostrar el mensaje de que sus credenciales fueron encontradas")
    public void elSistemaDeberiaMostrarElMensajeDeQueSusCredencialesFueronEncontradas() {
        Assertions.assertEquals(EXPECTED_MESSAGE_FORGOT_LOGIN.trim(), forgotLoginInfoPage.messageForgotLoginAssertion());
        System.out.println("Mensaje esperado = " + EXPECTED_MESSAGE_FORGOT_LOGIN + "\n"
                + "Mensaje Obtenido = " + forgotLoginInfoPage.messageForgotLoginAssertion());
        closeDriver();
    }
}
