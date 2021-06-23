package ru.stepev.test.training.at.hw3.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageTextField extends AbstractElement {

    public PageTextField(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getPageTextField() {
        return getWebElement();
    }
}
