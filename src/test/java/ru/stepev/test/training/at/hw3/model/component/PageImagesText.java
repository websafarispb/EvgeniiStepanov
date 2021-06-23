package ru.stepev.test.training.at.hw3.model.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageImagesText extends AbstractElement {

    public PageImagesText(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public List<String> getImagesText() {
        waitElements();
        return driver.findElements(Locators.get(locatorName))
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }
}
