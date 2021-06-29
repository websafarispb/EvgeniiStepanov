package ru.stepev.test.training.at.hw5.steps;

import java.util.concurrent.TimeUnit;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw5.model.page.DifferentElementsPage;
import ru.stepev.test.training.at.hw5.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw5.model.page.UserTablePage;
import ru.stepev.test.training.at.hw5.utils.WebDriverSingleton;

public abstract class AbstractStep {

    FluentHomePage fluentHomePage;
    DifferentElementsPage differentElementsPage;
    UserTablePage userTablePage;
    SoftAssert softAssertion;

    protected AbstractStep() {
        softAssertion = new SoftAssert();
        fluentHomePage = new FluentHomePage(WebDriverSingleton.getDriver());
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.getDriver());
        userTablePage = new UserTablePage(WebDriverSingleton.getDriver());
        WebDriverSingleton.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
