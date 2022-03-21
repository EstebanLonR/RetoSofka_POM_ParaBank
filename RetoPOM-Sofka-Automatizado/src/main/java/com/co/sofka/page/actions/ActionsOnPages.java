package com.co.sofka.page.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsOnPages {
    private WebDriver webDriver;
    private WebDriverWait webDriverExplicitWait;
    //Logger
    private static final Logger LOGGER = Logger.getLogger(ActionsOnPages.class);
    private static final String MESSAGE_DRIVER_NULL = "\t ATENTION\n" +
            "WebDriver Null";

    //Configurar Tiempo Explicito
    private void configureExplicitTime(WebDriver webDriver, int timeSeconds) {
        try {
            webDriverExplicitWait = new WebDriverWait(webDriver, timeSeconds);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }

    }

    //Constructor
    public ActionsOnPages(WebDriver webDriver) {
        try {
            if (webDriver == null) {
                LOGGER.warn(MESSAGE_DRIVER_NULL);
            }
            this.webDriver = webDriver;
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }

    }

    //Constructor Tiempo Explicito
    public ActionsOnPages(WebDriver webDriver, int timeSeconds) {
        try {
            if (webDriver == null) {
                LOGGER.warn(MESSAGE_DRIVER_NULL);
            }
            this.webDriver = webDriver;
            configureExplicitTime(webDriver, timeSeconds);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }

    }

    //Inicializar WebElements
    protected void initPageFactoryElements(WebDriver webDriver, Object page) {
        PageFactory.initElements(webDriver, page);
    }

    //Acciones
    protected void clickOn(WebElement webElement) {
        webElement.click();
    }

    protected void typeOf(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void submit(WebElement webElement) {
        webElement.submit();
    }
}
