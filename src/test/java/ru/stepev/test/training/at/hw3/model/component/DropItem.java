package ru.stepev.test.training.at.hw3.model.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class DropItem extends AbstractElement {

    public DropItem(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public WebElement getDropItem() {
        return getWebElement();
    }
}
