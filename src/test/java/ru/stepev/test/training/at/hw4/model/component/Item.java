package ru.stepev.test.training.at.hw4.model.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Item {

    private String name;
    private boolean visible;

    public Item(MenuItem menuItem) {
        name = menuItem.getText();
        visible = menuItem.isDisplayed();
    }
}
