package ru.stepev.test.training.at.hw7.test;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

import com.epam.jdi.light.driver.WebDriverUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stepev.test.training.at.hw7.model.SiteJdi;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        logger.setLogLevel(STEP);
        initSite(SiteJdi.class);
    }

    @AfterSuite
    static void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
