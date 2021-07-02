package ru.stepev.test.training.at.hw7;

import org.testng.annotations.Test;

public class SimpleTest extends AbstractTest {

    @Test
    public void openPage() {
        //WebPage.openUrl("https://jdi-testing.github.io/jdi-light/index.html");
        //        $("img#user-icon").click();
        //        $("#name").sendKeys("Roman");
        //        $("#password").sendKeys("Jdi1234");
        //        $("#login-button").click();
        //        $("//header//a[@href='metals-colors.html']").click();
        SiteJdi.homePage.open();
        SiteJdi.homePage.userIcon.click();
        SiteJdi.homePage.name.sendKeys("Roman");
        SiteJdi.homePage.password.sendKeys("Jdi1234");
        SiteJdi.homePage.loginButton.click();
        //  SiteJdi.homePage.menuContactForm.click();
    }
}
