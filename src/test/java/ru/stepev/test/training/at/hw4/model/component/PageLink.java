package ru.stepev.test.training.at.hw4.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLink extends AbstractElement {

    public PageLink(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getLink() {
        return getWebElement();
    }
}
