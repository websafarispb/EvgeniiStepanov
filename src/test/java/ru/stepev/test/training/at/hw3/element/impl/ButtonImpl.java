package ru.stepev.test.training.at.hw3.element.impl;

import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw3.element.Button;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}