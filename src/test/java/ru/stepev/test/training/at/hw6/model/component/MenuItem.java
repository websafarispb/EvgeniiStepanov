package ru.stepev.test.training.at.hw6.model.component;

import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
public class MenuItem extends Element {

    private String name;
    private boolean visible;

    public MenuItem(WebElement webElement) {
        super(webElement);
    }

    public MenuItem init(String name, boolean visible) {
        this.name = name;
        this.visible = visible;
        return this;
    }
}
