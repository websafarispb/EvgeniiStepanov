package ru.stepev.test.training.at.hw3.element.impl;

import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.element.Element;

abstract class AbstractElement implements Element {
    protected final WebElement wrappedElement;

    protected AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
