package ru.stepev.test.training.at.hw4.element;

import org.openqa.selenium.WebElement;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
