package ru.stepev.test.training.at.hw4.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropItem extends AbstractElement {

    public DropItem(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getDropItem() {
        return getWebElement();
    }
}
