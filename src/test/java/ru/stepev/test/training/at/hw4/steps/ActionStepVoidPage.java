package ru.stepev.test.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.page.HomePage;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class ActionStepVoidPage extends AbstractStep {

    protected HomePage homePage;

    public ActionStepVoidPage(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    @Step("Opening Page with {url} using Void Page Object pattern")
    public void openPage(String url) {
        homePage.open(url);
    }

    @Step("Enter user's login and password {user}")
    public void login(User user) {
        homePage.login(user);
    }

    @Step("Switch to frame {frameId}")
    public void switchToFrame(String frameId) {
        homePage.switchToFrame(frameId);
    }

    @Step("Switch to home page")
    public void switchToDefaultContent() {
        homePage.switchToDefaultContent();
    }

    @Step("Get user full name")
    public String getFullUserName() {
        return homePage.getFullUserName();
    }
}
