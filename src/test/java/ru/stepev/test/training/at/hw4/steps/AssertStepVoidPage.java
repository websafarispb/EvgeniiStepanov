package ru.stepev.test.training.at.hw4.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw4.model.component.Image;
import ru.stepev.test.training.at.hw4.model.component.ImagesText;
import ru.stepev.test.training.at.hw4.model.component.Item;
import ru.stepev.test.training.at.hw4.model.page.HomePage;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class AssertStepVoidPage extends AbstractStep {

    private HomePage homePage;

    protected SoftAssert softAssertion;

    public AssertStepVoidPage(WebDriver driver) {
        super(driver);
        softAssertion = new SoftAssert();
        homePage = new HomePage(driver);
    }

    @Step("Check Page Title {expectedTitle}")
    public void assertPageTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("Check success of login operation be user full name {expectedUserName}")
    public void checkSuccessOfLoginOperation(String expectedUserName) {
        String actualUserName = homePage.getFullUserName();
        assertEquals(actualUserName, Page.expectedUserName);
    }

    @Step("Check header menu items")
    public void checkHeaderMenu() {
        List<Item> actualHeaderMenu = homePage.getHeaderMenu();
        assertEquals(actualHeaderMenu, Page.expectedHeaderMenu);
    }

    @Step("Check visibility of images on home page")
    public void checkAreImagesDisplayed() {
        List<Image> actualImagesOfIndexPage = homePage.getImages();
        actualImagesOfIndexPage.stream().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        softAssertion.assertAll();
    }

    @Step("Check text of images on home page")
    public void checkTextOfImages() {
        List<String> actualImagesText = homePage.getImagesText();
        assertEquals(actualImagesText, Page.expectedImagesText);
    }

    @Step("Check frame is exist")
    public void checkFrameIsExist() {
        assertEquals(homePage.getTitle(), Page.expectedTitle);
    }

    @Step("Check frame have button")
    public void checkFrameHasButton() {
        assertTrue(homePage.getButtonOfFrame().isDisplayed());
    }

    @Step("Check left side menu items")
    public void checkLeftSideMenu() {
        List<Item> actualLeftSideMenu = homePage.getLeftSideMenu();
        assertEquals(actualLeftSideMenu, Page.expectedLeftSideMenu);
    }

    @Step("Check page URL with end {endOfCurrentUrlPage}")
    public void assertEndOfPage(String endOfCurrentUrlPage) {
        assertTrue(homePage.getCurrentUrl().endsWith(endOfCurrentUrlPage));
    }
}
