package ru.stepev.test.training.at.hw3.element;

import org.openqa.selenium.WebElement;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}