package ru.stepev.test.training.at.hw3.model.component;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@NoArgsConstructor
public class Element implements IElement {

    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public String getText() {
        return webElement.getText();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public void sendKeys(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }
}
