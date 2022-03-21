package com.co.sofka.page.parabank;

import com.co.sofka.model.LoginModel;
import com.co.sofka.page.actions.ActionsOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ActionsOnPages {

    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//div[@class='login']//child::input[@name='username']")
    private WebElement username;

    @CacheLookup
    @FindBy(xpath = "//div[@class='login']//child::input[@name='password']")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@type='submit'][@value='Log In']")
    private WebElement logInSubmit;

    //Localizador Assertion
    @CacheLookup
    @FindBy(xpath = "//h1[@class='title'][contains(string(), 'Accounts Overview')]")
    private WebElement accountOverview;

    //Inicializar modelo
    private LoginModel loginModel;

    public LoginPage(WebDriver webDriver, LoginModel loginModel) {
        super(webDriver);
        initPageFactoryElements(webDriver, this);
        this.loginModel = loginModel;
    }

    public void fillLoginCredentials() {
        typeOf(username, loginModel.getUsername());
        typeOf(password, loginModel.getPassword());
        submit(logInSubmit);
    }

    public Boolean assertionAccountOvervies() {
        Boolean valueObtained=accountOverview.isDisplayed();
        return valueObtained;
    }
}
