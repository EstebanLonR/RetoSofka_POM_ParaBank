package com.co.sofka.stepdefinition.parabank.customcare;

import com.co.sofka.model.CustomCareModel;
import com.co.sofka.page.parabank.CustomCarePage;
import com.co.sofka.stepdefinition.setup.SetUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class CustomCareStepDefinition extends SetUp {
    private Logger LOGGER = Logger.getLogger(CustomCareStepDefinition.class);
    private CustomCarePage customCarePage;
    private CustomCareModel customCareModel;
    private final String EXPECTED_MESSAGE = "A Customer Care Representative will be contacting you.";
    private final String EXPECTED_EMAIL_ERROR_MESSAGE = "Email is required.";


    @Given("que el usuario se encuentra en la home page del aplicativo")
    public void queElUsuarioSeEncuentraEnLaHomePageDelAplicativo() {
        try {
            setUpWebDriver();
            generalSetUp();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();
        }
    }

    @When("Se dirige al apartado de atencion y diligencia el formulario con su consulta")
    public void seDirigeAlApartadoDeAtencionYDiligenciaElFormularioConSuConsulta(DataTable dataTable) {
        try {
            List<List<String>> row = dataTable.asLists(String.class);
            customCareModel = new CustomCareModel();
            customCareModel.setName(row.get(1).get(0));
            customCareModel.setEmail(row.get(1).get(1));
            customCareModel.setPhone(row.get(1).get(2));
            customCareModel.setMessage(row.get(1).get(3));
            customCarePage = new CustomCarePage(webDriver, customCareModel);
            customCarePage.consultCustomCare();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();

        }

    }

    @Then("el sistema deberia de mostrarle un mensaje A Customer Care Representative will be contacting you.")
    public void elSistemaDeberiaDeMostrarleUnMensajeACustomerCareRepresentativeWillBeContactingYou() {
        Assertions.assertEquals(EXPECTED_MESSAGE, customCarePage.messageAssertion());
        System.out.println("Mensaje esperado = " + EXPECTED_MESSAGE + "\n"
                + "Mensaje Obtenido = " + customCarePage.messageAssertion());
        closeDriver();

    }

    //@IncorrectConsult
    @When("Se dirige al apartado de atencion y diligencia el formulario sin un correo electronico")
    public void seDirigeAlApartadoDeAtencionYDiligenciaElFormularioSinUnCorreoElectronico(DataTable dataTable) {

        try {
            List<List<String>> row = dataTable.asLists(String.class);
            customCareModel = new CustomCareModel();
            customCareModel.setName(row.get(1).get(0));
            customCareModel.setPhone(row.get(1).get(1));
            customCareModel.setMessage(row.get(1).get(2));
            customCarePage = new CustomCarePage(webDriver, customCareModel);
            customCarePage.consultWhitoutEmail();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            closeDriver();

        }
    }

    @Then("el sistema deberia de mostrarle un mensaje de error Email is required")
    public void elSistemaDeberiaDeMostrarleUnMensajeDeErrorEmailIsRequired() {
        Assertions.assertEquals(EXPECTED_EMAIL_ERROR_MESSAGE, customCarePage.assertionErrorEmailMessage());
        System.out.println("Mensaje esperado = " + EXPECTED_EMAIL_ERROR_MESSAGE + "\n"
                + "Mensaje Obtenido = " + customCarePage.assertionErrorEmailMessage());
        closeDriver();
    }
}
