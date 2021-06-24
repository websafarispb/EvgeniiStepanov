package ru.stepev.test.training.at.hw4.element;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
