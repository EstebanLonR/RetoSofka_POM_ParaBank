package com.co.sofka.page.parabank;

import com.co.sofka.model.RegisterModel;
import com.co.sofka.page.actions.ActionsOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends ActionsOnPages {

    //Localizadores
    @CacheLookup
    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @CacheLookup
    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "customer.ssn")
    private WebElement socialSecurityNumber;

    @CacheLookup
    @FindBy(id = "customer.username")
    private WebElement userName;

    @CacheLookup
    @FindBy(id = "customer.password")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@type='submit'][@value='Register']")
    private WebElement registerSubmmit;

    //Localizadores Assertions
    @CacheLookup
    @FindBy(xpath = "//div[@id='rightPanel']/p")
    private WebElement messageRegistration;

    @CacheLookup
    @FindBy(id = "customer.username.errors")
    private WebElement userNameAlreadyExist;

    //Inicializar modelo
    private RegisterModel registerModel;

    //Constructor
    public RegisterPage(WebDriver webDriver, RegisterModel registerModel) {
        super(webDriver);
        initPageFactoryElements(webDriver, this);
        this.registerModel = registerModel;
    }

    //Metodos-Funciones
    public void fillRegisterForm() {
        typeOf(firstName, registerModel.getFirstName());
        typeOf(lastName, registerModel.getLastName());
        typeOf(address, registerModel.getAddress());
        typeOf(city, registerModel.getCity());
        typeOf(state, registerModel.getState());
        typeOf(zipCode, registerModel.getZipCode());
        typeOf(socialSecurityNumber, registerModel.getSocialSecurityNumber());
        typeOf(userName, registerModel.getUserName());
        typeOf(password, registerModel.getPassword());
        typeOf(confirmPassword, registerModel.getConfirmPassword());
        submit(registerSubmmit);
    }

    public String messageAssertionObtained() {
        String messageObtained = messageRegistration.getText().trim();
        return messageObtained;
    }

    public String messageUsernameExist() {
        String messageObained = userNameAlreadyExist.getText().trim();
        return messageObained;
    }

}
