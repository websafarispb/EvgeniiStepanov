package ru.stepev.test.training.at.hw3.model.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stepev.test.training.at.hw3.utils.Locators;

public abstract class AbstractElement {

    protected String locatorName;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractElement(String locatorName, WebDriver driver) {
        this.driver = driver;
        this.locatorName = locatorName;
        wait = new WebDriverWait(driver, 10L);
    }

    public WebElement getWebElement() {
        return wait.until(visibilityOf(driver.findElement(Locators.get(locatorName))));
    }

    public void waitElements() {
        wait.until(d -> d.findElements(Locators.get(locatorName)).size() > 1);
    }
}
