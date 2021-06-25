package ru.stepev.test.training.at.hw3.ex1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw3.AbstractBaseTest;
import ru.stepev.test.training.at.hw3.dataprovider.PageDataProvider;
import ru.stepev.test.training.at.hw3.model.User;
import ru.stepev.test.training.at.hw3.model.page.Page;

public class FirstExerciseWithSoftAssertionTest extends AbstractBaseTest {

    @Test(dataProvider = "Page Data Provider", dataProviderClass = PageDataProvider.class)
    public void exerciseFirst(User user) {

        //1. Open test site by URL
        homePage.open();

        //2. Assert Browser title
        assertEquals(homePage.getTitle(), Page.expectedTitle);

        // 3. Perform login
        homePage.login(user);

        assertTrue(homePage.getCurrentUrl().endsWith(Page.endOfCurrentUrlPage));

        //4. Assert Username is logged
        actualUserName = homePage.getFullUserName();

        softAssertion.assertEquals(actualUserName, Page.expectedUserName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        actualHeaderMenu = homePage.getHeaderMenu();
        assertEquals(actualHeaderMenu, Page.expectedHeaderMenu);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        actualImagesOfIndexPage = homePage.getImages();

        actualImagesOfIndexPage.stream().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));

        softAssertion.assertAll();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        actualImagesText = homePage.getImagesText();
        assertEquals(actualImagesText, Page.expectedImagesText);

        //8. Assert that there is the iframe with “Frame Button” exist
        actualFrameWithButton = homePage.switchToFrame(Page.frameId);
        assertEquals(actualFrameWithButton.getTitle(), Page.expectedTitle);

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertTrue(homePage.getButtonOfFrame().isDisplayed());

        //10. Switch to original window back
        homePage.switchToDefaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        actualLeftSideMenu = homePage.getLeftSideMenu();

        assertEquals(actualLeftSideMenu, Page.expectedLeftSideMenu);
    }
}
