package ru.stepev.test.training.at.hw3.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class Button extends AbstractElement {

    public Button(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public boolean isDisplayed() {
        return getWebElement().isDisplayed();
    }

    public WebElement getButton() {
        return getWebElement();
    }
}
