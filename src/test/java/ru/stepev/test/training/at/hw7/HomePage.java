package ru.stepev.test.training.at.hw7;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
//import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HomePage extends WebPage {

    //    @Css("img#user-icon")
    //    public static UIElement userIcon;
    // @UI("img#user-icon")
    public static Link userIcon;
    //  @UI("#name")
    public static TextField name;
    //  @UI("#password")
    public static TextField password;
    //  @UI("#login-button")
    public static Button loginButton;
    // @UI("//*[@class='sidebar-menu']//*[text()='Contact form']")
    public static Link menuContactForm;
}
