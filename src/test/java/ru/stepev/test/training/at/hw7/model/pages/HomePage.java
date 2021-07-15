package ru.stepev.test.training.at.hw7.model.pages;

import static ru.stepev.test.training.at.hw7.model.SiteJdi.metalAndColorPage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.stepev.test.training.at.hw7.model.User;

public class HomePage extends WebPage {
    @Css("img#user-icon")
    public static UIElement userIcon;
    public static TextField name;
    public static TextField password;
    @UI("//header//a[@href='metals-colors.html']")
    public static Link menuMetalsColors;
    @UI("//form[@class='form-horizontal login']")
    public static Form<User> loginForm;

    public void logIn(User user) {
        userIcon.click();
        loginForm.fill(user);
        loginForm.login();
        this.checkOpened();
    }

    public void openMetalsColorsPage() {
        menuMetalsColors.click();
        metalAndColorPage.checkOpened();
    }
}
