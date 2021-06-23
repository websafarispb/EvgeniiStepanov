package ru.stepev.test.training.at.hw3.model.page;

import java.util.Arrays;
import java.util.List;
import lombok.Data;
import ru.stepev.test.training.at.hw3.model.component.CheckboxItem;
import ru.stepev.test.training.at.hw3.model.component.MenuItem;

@Data
public final class Page {

    //test data
    public static final String userName = "Roman";
    public static final String password = "Jdi1234";
    public static final String pageURL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String nameCheckboxWater = "Water";
    public static final String nameCheckboxWind = "Wind";

    //DOM locators
    public static final String nameId = "name";
    public static final String passwordId = "password";
    public static final String loginButtonId = "login-button";
    public static final String userNameId = "user-name";
    public static final String frameId = "frame";

    //Xpath selector
    public static final String loginLinkXpath = "//a[@href='#']";
    public static final String headerMenuItemsXpath =
        "//ul[@class='uui-navigation nav navbar-nav m-l8']//following-sibling::a";
    public static final String leftSideMenuItemsXpath =
        "//ul[@class='sidebar-menu left']//following-sibling::a";
    public static final String imagesOfIndexPageXpath = "//span[contains(@class,  'icons-benefit icon-')]";
    public static final String imagesTextOfIndexPageXpath = "//span[contains(@class,  'benefit-txt')]";
    public static final String actualButtonOfFrameXpath = "//input[@value='Frame Button']";
    public static final String headerMenuServiceXpath = "//header//a[@class='dropdown-toggle']";
    public static final String menuItemDifferentElementsPageXpath = "//header//a[@href='different-elements.html']";
    public static final String checkboxXpath = "//label[@class='label-checkbox']";
    public static final String selenRadioButtonXpath = "//label[@class='label-radio'][4]";
    public static final String yellowDropDownItemXpath = "//select[@class='uui-form-element']//option[4]";
    public static final String logRowsXpath = "//ul[@class='panel-body-list logs']//li";

    //expected data
    public static final String expectedUserName = "ROMAN IOVLEV";
    public static final String expectedTitle = "Home Page";
    public static final String endOfCurrentUrlPage = "index.html";
    public static final String endOfDifferentElementUrlPage = "different-elements.html";

    public static final List<MenuItem> expectedHeaderMenu = Arrays.asList(
        MenuItem.builder().name("HOME").visible(true).build(),
        MenuItem.builder().name("CONTACT FORM").visible(true).build(),
        MenuItem.builder().name("SERVICE").visible(true).build(),
        MenuItem.builder().name("METALS & COLORS").visible(true).build());

    public static final List<MenuItem> expectedLeftSideMenu = Arrays.asList(
        MenuItem.builder().name("Home").visible(true).build(),
        MenuItem.builder().name("Contact form").visible(true).build(),
        MenuItem.builder().name("Service").visible(true).build(),
        MenuItem.builder().name("Metals & Colors").visible(true).build(),
        MenuItem.builder().name("Elements packs").visible(true).build());

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
