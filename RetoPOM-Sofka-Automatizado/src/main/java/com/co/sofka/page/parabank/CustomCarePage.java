package com.co.sofka.page.parabank;

import com.co.sofka.model.CustomCareModel;
import com.co.sofka.page.actions.ActionsOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomCarePage extends ActionsOnPages {

    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//li[@class='contact']//child::a[contains(string(), 'contact')]")
    private WebElement customCareButton;

    @CacheLookup
    @FindBy(id = "name")
    private WebElement name;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "phone")
    private WebElement phone;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement message;

    @CacheLookup
    @FindBy(xpath = "//td[@colspan='2']//child::input[@type='submit']")
    private WebElement sendCustomerCare;

    //Localizadores Assertions
    @CacheLookup
    @FindBy(xpath = "//div[@id='rightPanel']/p[2]")
    private WebElement messageValidation;

    @CacheLookup
    @FindBy(id = "email.errors")
    private WebElement errorMessageEmail;

    private CustomCareModel customCareModel;
    private String messageObtained;


    public CustomCarePage(WebDriver webDriver, CustomCareModel customCareModel) {
        super(webDriver);
        initPageFactoryElements(webDriver, this);
        this.customCareModel = customCareModel;
    }

    public void consultCustomCare() {
        clickOn(customCareButton);
        typeOf(name, customCareModel.getName());
        typeOf(email, customCareModel.getEmail());
        typeOf(phone, customCareModel.getPhone());
        typeOf(message, customCareModel.getMessage());
        submit(sendCustomerCare);

    }

    public String messageAssertion() {
        messageObtained = messageValidation.getText().trim();
        return messageObtained;
    }

    public void consultWhitoutEmail() {
        clickOn(customCareButton);
        typeOf(name, customCareModel.getName());
        typeOf(phone, customCareModel.getPhone());
        typeOf(message, customCareModel.getMessage());
        submit(sendCustomerCare);
    }

    public String assertionErrorEmailMessage(){
        String messageErrorEmailObtained=errorMessageEmail.getText().trim();
        return messageErrorEmailObtained;
    }
}
