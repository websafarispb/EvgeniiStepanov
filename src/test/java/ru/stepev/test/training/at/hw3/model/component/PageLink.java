package ru.stepev.test.training.at.hw3.model.component;

import java.nio.file.WatchEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageLink extends AbstractElement {

    public PageLink(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getLink() {
        return getWebElement();
    }
}
