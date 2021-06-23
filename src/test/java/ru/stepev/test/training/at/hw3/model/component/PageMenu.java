package ru.stepev.test.training.at.hw3.model.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageMenu extends AbstractElement {

    public PageMenu(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public List<MenuItem> getMenuItems() {
        waitElements();
        return driver.findElements(Locators.get(locatorName)).stream()
                     .map(e -> new MenuItem(e.getText(), e.isDisplayed()))
                     .collect(Collectors.toList());
    }
}
