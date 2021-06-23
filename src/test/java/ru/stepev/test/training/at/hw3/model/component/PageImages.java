package ru.stepev.test.training.at.hw3.model.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageImages extends AbstractElement {

    public PageImages(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public List<WebElement> getImages() {
        waitElements();
        return driver.findElements(Locators.get(locatorName));
    }
}
