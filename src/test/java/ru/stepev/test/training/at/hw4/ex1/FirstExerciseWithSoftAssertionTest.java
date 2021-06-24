package ru.stepev.test.training.at.hw4.ex1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw4.AbstractBaseTest;
import ru.stepev.test.training.at.hw4.dataprovider.PageDataProvider;
import ru.stepev.test.training.at.hw4.listener.AllureListener;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.page.Page;

@Listeners({AllureListener.class})
public class FirstExerciseWithSoftAssertionTest extends AbstractBaseTest {

    @Test(dataProvider = "Page Data Provider",
          dataProviderClass = PageDataProvider.class,
          description = "This is test with frame")
    public void exerciseFirst(User user) {

        //1. Open test site by URL
        // homePage.open();
        actionStep.homePageOpen();

        //2. Assert Browser title
        //assertEquals(homePage.getTitle(), Page.expectedTitle);
        assertStep.assertBrowserTitle();

        // 3. Perform login
        //homePage.login(user);
        actionStep.login(user);

        //4. Assert Username is logged
        //        assertTrue(homePage.getCurrentUrl().endsWith(Page.endOfCurrentUrlPage));
        //        actualUserName = homePage.getFullUserName();
        //softAssertion.assertEquals(actualUserName, Page.expectedUserName);
        assertStep.checkSuccessOfLoginOperation();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        //        actualHeaderMenu = homePage.getHeaderMenu().getMenuItems();
        //        assertEquals(actualHeaderMenu, Page.expectedHeaderMenu);
        assertStep.checkHeaderMenu();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        //        actualImagesOfIndexPage = homePage.getImagesOfPage();
        //        actualImagesOfIndexPage.stream().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        // softAssertion.assertAll();
        assertStep.checkAreImagesDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //        actualImagesText = homePage.getTextOfImagesOnIndexPage();
        //        assertEquals(actualImagesText, Page.expectedImagesText);
        assertStep.checkTextOfImages();

        //8. Assert that there is the iframe with “Frame Button” exist
        //        actualFrameWithButton = homePage.switchToFrame(Page.frameId);
        //        assertEquals(actualFrameWithButton.getTitle(), Page.expectedTitle);
        actionStep.switchToFrame();

        assertStep.checkFrameIsExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        // assertTrue(homePage.getButtonOfFrame().isDisplayed());
        assertStep.checkFrameHasButton();

        //10. Switch to original window back
        //homePage.switchToDefaultContent();
        actionStep.switchToDefaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //        actualLeftSideMenu = homePage.getLeftSideMenu().getMenuItems();
        //        assertEquals(actualLeftSideMenu, Page.expectedLeftSideMenu);

        assertStep.checkLeftSideMenu();
    }
}
