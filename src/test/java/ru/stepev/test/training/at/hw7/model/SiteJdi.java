package ru.stepev.test.training.at.hw7.model;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.stepev.test.training.at.hw7.model.pages.HomePage;
import ru.stepev.test.training.at.hw7.model.pages.MetalAndColor;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    @Url("/") public static HomePage homePage;
    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static MetalAndColor metalAndColorPage;
}
