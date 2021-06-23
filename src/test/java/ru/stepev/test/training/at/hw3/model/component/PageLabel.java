package ru.stepev.test.training.at.hw3.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

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
