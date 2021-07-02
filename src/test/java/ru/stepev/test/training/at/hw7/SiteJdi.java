package ru.stepev.test.training.at.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    @Url("/") public static HomePage homePage;
}
