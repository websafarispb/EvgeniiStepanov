package ru.stepev.test.training.at.hw5.model.page;

import java.util.Arrays;
import java.util.List;
import lombok.Data;
import ru.stepev.test.training.at.hw5.model.component.CheckboxItem;
import ru.stepev.test.training.at.hw5.model.component.Item;

@Data
public final class Page {

    public static final String pageURL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String frameId = "frame";
    public static final String expectedUserName = "ROMAN IOVLEV";
    public static final String expectedTitle = "Home Page";
    public static final String endOfCurrentUrlPage = "index.html";
    public static final String endOfDifferentElementUrlPage = "different-elements.html";

    public static final List<Item> expectedHeaderMenu = Arrays.asList(
        Item.builder().name("HOME").visible(true).build(),
        Item.builder().name("CONTACT FORM").visible(true).build(),
        Item.builder().name("SERVICE").visible(true).build(),
        Item.builder().name("METALS & COLORS").visible(true).build());

    public static final List<Item> expectedLeftSideMenu = Arrays.asList(
        Item.builder().name("Home").visible(true).build(),
        Item.builder().name("Contact form").visible(true).build(),
        Item.builder().name("Service").visible(true).build(),
        Item.builder().name("Metals & Colors").visible(true).build(),
        Item.builder().name("Elements packs").visible(true).build());

    public static final List<String> expectedImagesText = Arrays.asList(
        "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project",
        "To be flexible and\n"
            + "customizable",
        "To be multiplatform",
        "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…"
    );

    public static final List<CheckboxItem> clickedCheckboxItems = Arrays.asList(CheckboxItem.Water, CheckboxItem.Wind);

    public static final List<String> expectedLogRows = Arrays.asList(
        ":: Colors: value changed to Yellow",
        ":: metal: value changed to Selen",
        ":: Wind: condition changed to true",
        ":: Water: condition changed to true");

    private Page() {
    }
}
