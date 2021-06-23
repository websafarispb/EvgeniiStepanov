package ru.stepev.test.training.at.hw3.model.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageCheckbox extends AbstractElement {

    public PageCheckbox(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public List<WebElement> getAndClickCheckboxItems(List<CheckboxItem> items) {
        return driver.findElements(Locators.get(locatorName))
                     .stream()
                     .filter(e -> items.contains(CheckboxItem.valueOf(e.getText())))
                     .peek(WebElement::click)
                     .collect(Collectors.toList());
    }

    public List<WebElement> getWithWaitAndClickCheckboxItems(List<CheckboxItem> items) {
        waitElements();
        return driver.findElements(Locators.get(locatorName))
                     .stream()
                     .filter(e -> items.contains(CheckboxItem.valueOf(e.getText())))
                     .peek(WebElement::click)
                     .collect(Collectors.toList());
    }
}
