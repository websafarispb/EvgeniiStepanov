package ru.stepev.test.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод логина и пароля пользователя")
    public void login(User user) {
        homePage.login(user);
    }

    @Step("Переключаемся на фрейм")
    public void switchToFrame() {
        actualFrameWithButton = homePage.switchToFrame(Page.frameId);
    }

    @Step("Переход на домашнюю страницу")
    public void switchToDefaultContent() {
        homePage.switchToDefaultContent();
    }
}
