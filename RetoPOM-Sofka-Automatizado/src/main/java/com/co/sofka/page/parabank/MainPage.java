package com.co.sofka.page.parabank;

import com.co.sofka.page.actions.ActionsOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ActionsOnPages {
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//a[contains(string(),'Register')]")
    private WebElement register;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        initPageFactoryElements(webDriver, this);
    }

    public void goToRegister() {
        clickOn(register);
    }


}
