package ru.stepev.test.training.at.hw4.element.impl;

import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw4.element.Element;

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
