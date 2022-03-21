package com.co.sofka.runner.parabank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/parabank/register/register.feature",
        glue = "com.co.sofka.stepdefinition.parabank.register",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class Register {
}
