package ru.stepev.test.training.at.hw5.model.component;

import org.openqa.selenium.WebElement;

public class CheckBox extends Element {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }

    public String getText() {
        return webElement.getText();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }
}
