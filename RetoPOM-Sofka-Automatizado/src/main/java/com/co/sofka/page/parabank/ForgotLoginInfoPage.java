package com.co.sofka.page.parabank;

import com.co.sofka.model.ForgotLoginInfoModel;
import com.co.sofka.page.actions.ActionsOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ForgotLoginInfoPage extends ActionsOnPages {

    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//a[contains(string(), 'Forgot login info?')]")
    private WebElement forgotLogin;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "address.street")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "address.city")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "address.state")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "address.zipCode")
    private WebElement zipCode;

    @CacheLookup
    @FindBy(id = "ssn")
    private WebElement socialSecurityNumber;

    @CacheLookup
    @FindBy(xpath = "//td[@colspan='2']//child::input[@type='submit' and @value='Find My Login Info']")
    private WebElement findLoginInfo;

    //Localizadores Assertions
    @CacheLookup
    @FindBy(xpath = "//div[@id='rightPanel']/p[1]")
    private WebElement messageInfoLoginSuccesfully;

    private ForgotLoginInfoModel forgotLoginInfoModel;
    private String messageAssertForgotLoginObtained;


    public ForgotLoginInfoPage(WebDriver webDriver, ForgotLoginInfoModel forgotLoginInfoModel) {
        super(webDriver);
        initPageFactoryElements(webDriver, this);
        this.forgotLoginInfoModel = forgotLoginInfoModel;
    }

    public void fillForgotLoginForm() {
        clickOn(forgotLogin);
        typeOf(firstName, forgotLoginInfoModel.getFirstName());
        typeOf(lastName, forgotLoginInfoModel.getLastName());
        typeOf(address, forgotLoginInfoModel.getAddress());
        typeOf(city, forgotLoginInfoModel.getCity());
        typeOf(state, forgotLoginInfoModel.getState());
        typeOf(zipCode, forgotLoginInfoModel.getZipCode());
        typeOf(socialSecurityNumber, forgotLoginInfoModel.getSocialSecurityNumber());
        submit(findLoginInfo);
    }

    public String messageForgotLoginAssertion() {
        messageAssertForgotLoginObtained = messageInfoLoginSuccesfully.getText().trim();
        return messageAssertForgotLoginObtained;
    }
}
