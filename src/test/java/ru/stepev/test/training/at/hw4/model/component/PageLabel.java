package ru.stepev.test.training.at.hw4.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLabel extends AbstractElement {

    public PageLabel(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getPageLabel() {
        return getWebElement();
    }

    public String getText() {
        return getPageLabel().getText();
    }
}
