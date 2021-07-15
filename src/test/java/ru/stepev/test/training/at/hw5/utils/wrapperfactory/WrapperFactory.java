package ru.stepev.test.training.at.hw5.utils.wrapperfactory;

import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw5.model.component.IElement;

public class WrapperFactory {

    public static IElement createInstance(Class<IElement> clazz,
                                          WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                "WebElement can't be represented as " + clazz
            );
        }
    }
}
