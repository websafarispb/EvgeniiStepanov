package ru.stepev.test.training.at.hw3.model.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw3.utils.Locators;

public class PageLog extends AbstractElement {

    public PageLog(String locatorName, WebDriver driver) {
        super(locatorName, driver);
    }

    public List<String> getPageLog() {
        waitElements();
        return driver.findElements(Locators.get(locatorName))
                     .stream()
                     .map(e -> e.getText().replaceAll("[0-9]", ""))
                     .collect(Collectors.toList());
    }
}
