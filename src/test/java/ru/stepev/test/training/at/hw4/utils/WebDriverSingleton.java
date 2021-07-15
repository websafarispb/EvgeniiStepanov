package ru.stepev.test.training.at.hw4.utils;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private static final Properties pageProperty;

    static {
        pageProperty = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/pages.properties");
        try {
            pageProperty.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        String browserName =
            pageProperty.getProperty("browser") == null ? "CHROME" : pageProperty.getProperty("browser");

        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.createWebDriver(browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
