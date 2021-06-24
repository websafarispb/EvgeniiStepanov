package ru.stepev.test.training.at.hw4.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTextField extends AbstractElement {

    public PageTextField(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getPageTextField() {
        return getWebElement();
    }
}
