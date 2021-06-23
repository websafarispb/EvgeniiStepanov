package ru.stepev.test.training.at.hw3.utils;

import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    private enum BrowserType {

        CHROME, FIREFOX, OPERA;
    }

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver;
        switch (BrowserType.valueOf(browserName)) {
            case FIREFOX:
                driver = createFirefox();
                break;
            case CHROME:
                driver = createChrome();
                break;
            case OPERA:
                driver = createOpera();
                break;
            default:
                driver = createChrome();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createFirefox() {
        return new FirefoxDriver();
    }

    private static WebDriver createChrome() {
        return new ChromeDriver();
    }

    private static WebDriver createOpera() {
        return new OperaDriver();
    }
}
