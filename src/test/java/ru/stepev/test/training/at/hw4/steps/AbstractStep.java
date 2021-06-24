package ru.stepev.test.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw4.model.component.MenuItem;
import ru.stepev.test.training.at.hw4.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw4.model.page.HomePage;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected FluentHomePage fluentHomePage;

    protected WebDriver actualFrameWithButton;
    protected List<WebElement> actualImagesOfIndexPage;
    protected List<WebElement> checkboxSelected;
    protected String actualUserName;
    protected List<MenuItem> actualHeaderMenu;
    protected List<MenuItem> actualLeftSideMenu;
    protected List<String> actualImagesText;
    protected List<String> actualLogRows;

    protected AbstractStep(WebDriver driver) {
        homePage = new HomePage(driver);
        fluentHomePage = new FluentHomePage(driver);
    }

    @Step("Открыть Home page EPAM")
    public void homePageOpen() {
        homePage.open();
    }
}
