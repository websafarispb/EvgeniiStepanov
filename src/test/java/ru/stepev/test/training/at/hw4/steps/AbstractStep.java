package ru.stepev.test.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw4.model.component.Image;
import ru.stepev.test.training.at.hw4.model.component.Item;
import ru.stepev.test.training.at.hw4.model.component.MenuItem;
import ru.stepev.test.training.at.hw4.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw4.model.page.HomePage;

public abstract class AbstractStep {

    protected AbstractStep(WebDriver driver) {
    }
}
