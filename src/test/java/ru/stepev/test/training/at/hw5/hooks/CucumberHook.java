package ru.stepev.test.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw5.utils.WebDriverFactory;
import ru.stepev.test.training.at.hw5.utils.WebDriverSingleton;

public class CucumberHook {

    @Before
    public void initDriver() {
        WebDriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
    }
}
