package com.co.sofka.stepdefinition.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.co.sofka.util.Log4jValues.LOG4J_PROPERTIES_PATH;

public class SetUp {

    //Constantes para inicializar el driver
    private final String WEBDRIVER = "webdriver.chrome.driver";
    private final String WEBDRIVER_PATH = "src/test/resources/drivers/windows/chrome/chromedriver.exe";

    //URL del sitio web
    private final String URL_SITE = "https://parabank.parasoft.com/parabank/index.htm";

    protected WebDriver webDriver;

    //Configurar capabilities del driver
    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER, WEBDRIVER_PATH);
    }

    private void setUpLog4j() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG4J_PROPERTIES_PATH.getValue());
    }

    protected void generalSetUp() {
        setUpLog4j();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito", "--disable-notifications", "--start-maximized");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get(URL_SITE);

    }

    protected void closeDriver() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}
