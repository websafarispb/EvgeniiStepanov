package ru.stepev.test.training.at.hw4.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class AssertStep extends AbstractStep {

    protected SoftAssert softAssertion;

    public AssertStep(WebDriver driver) {
        super(driver);
        softAssertion = new SoftAssert();
    }

    @Step("Проверка заглавия открытой страницы")
    public void assertBrowserTitle() {
        assertEquals(homePage.getTitle(), Page.expectedTitle);
    }

    @Step("Проверка успешного входа пользователя")
    public void checkSuccessOfLoginOperation() {
        assertTrue(homePage.getCurrentUrl().endsWith(Page.endOfCurrentUrlPage));
        actualUserName = homePage.getFullUserName();
        assertEquals(actualUserName, Page.expectedUserName);
    }

    @Step("Проверка верхнего именю, должно иметь 4 пункта")
    public void checkHeaderMenu() {
        actualHeaderMenu = homePage.getHeaderMenu().getMenuItems();
        assertEquals(actualHeaderMenu, Page.expectedHeaderMenu);
    }

    @Step("Проверка 4 ых изображений на видимость")
    public void checkAreImagesDisplayed() {
        actualImagesOfIndexPage = homePage.getImagesOfPage();
        actualImagesOfIndexPage.stream().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        softAssertion.assertAll();
    }

    @Step("Проверка текста котрорый содержат изображения на домашней странице")
    public void checkTextOfImages() {
        actualImagesText = homePage.getTextOfImagesOnIndexPage();
        assertEquals(actualImagesText, Page.expectedImagesText);
    }

    @Step("Проверка существования фрейма")
    public void checkFrameIsExist() {
        assertEquals(homePage.getTitle(), Page.expectedTitle);
    }

    @Step("Проверка существования кнопки на фрейме")
    public void checkFrameHasButton() {
        assertTrue(homePage.getButtonOfFrame().isDisplayed());
    }

    @Step("Проверка существования левого меню и корректность его пунктов")
    public void checkLeftSideMenu() {
        actualLeftSideMenu = homePage.getLeftSideMenu().getMenuItems();
        assertEquals(actualLeftSideMenu, Page.expectedLeftSideMenu);
    }
}
