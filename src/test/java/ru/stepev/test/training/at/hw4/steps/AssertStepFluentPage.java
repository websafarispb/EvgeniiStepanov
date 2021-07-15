package ru.stepev.test.training.at.hw4.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw4.model.page.DifferentElementsPage;
import ru.stepev.test.training.at.hw4.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class AssertStepFluentPage extends AbstractStep {

    protected FluentHomePage fluentHomePage;

    public AssertStepFluentPage(WebDriver driver) {
        super(driver);
        fluentHomePage = new FluentHomePage(driver);
    }

    @Step("Check Page Title {expectedTitle}")
    public void assertPageTitle(String expectedTitle) {
        assertEquals(fluentHomePage.getTitle(), expectedTitle);
    }

    @Step("Check page URL with end {endOfCurrentUrlPage}")
    public void assertEndOfPage(String endOfCurrentUrlPage) {
        assertTrue(fluentHomePage.getCurrentUrl().endsWith(endOfCurrentUrlPage));
    }

    @Step("Check success of login operation be user full name {expectedUserName}")
    public void checkSuccessOfLoginOperation(String expectedUserName) {
        String actualUserName = fluentHomePage.getFullUserName();
        assertEquals(actualUserName, Page.expectedUserName);
    }

    @Step("Check success of opening operation DifferentElementsPage")
    public void checkSuccessOfOpenDifferentElementsPage(DifferentElementsPage differentElementsPage,
                                                        String endOfDifferentElementUrlPage) {
        assertTrue(differentElementsPage.getCurrentUrl().endsWith(endOfDifferentElementUrlPage));
    }

    @Step("Assertion log rows on DifferentElementsPage")
    public void assertionLogRowsOnDifferentElementsPage(DifferentElementsPage differentElementsPage) {
        List<String> actualLogRows = differentElementsPage.getLogRows();
        assertEquals(actualLogRows, Page.expectedLogRows);
    }
}
