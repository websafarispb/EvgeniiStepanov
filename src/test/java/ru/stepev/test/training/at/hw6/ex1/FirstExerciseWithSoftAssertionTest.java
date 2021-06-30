package ru.stepev.test.training.at.hw6.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw6.AbstractBaseTest;
import ru.stepev.test.training.at.hw6.dataprovider.PageDataProvider;
import ru.stepev.test.training.at.hw6.listener.AllureListener;
import ru.stepev.test.training.at.hw6.model.User;
import ru.stepev.test.training.at.hw6.model.page.Page;

@Listeners({AllureListener.class})
@Feature("Exercise one")
public class FirstExerciseWithSoftAssertionTest extends AbstractBaseTest {

    @Test(dataProvider = "Page Data Provider",
          dataProviderClass = PageDataProvider.class,
          description = "This is test with frame")
    @Story("Exercise one good test")
    public void exerciseFirst(User user) {

        //1. Open test site by URL
        actionStepVoidPage.openPage(Page.pageURL);

        //2. Assert Browser title
        assertStepVoidPage.assertPageTitle(Page.expectedTitle);

        // 3. Perform login
        actionStepVoidPage.login(user);

        //4. Assert Username is logged
        assertStepVoidPage.assertEndOfPage(Page.endOfCurrentUrlPage);
        assertStepVoidPage.checkSuccessOfLoginOperation(Page.expectedUserName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertStepVoidPage.checkHeaderMenu();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertStepVoidPage.checkAreImagesDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertStepVoidPage.checkTextOfImages();

        //8. Assert that there is the iframe with “Frame Button” exist
        actionStepVoidPage.switchToFrame(Page.frameId);

        assertStepVoidPage.checkFrameIsExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertStepVoidPage.checkFrameHasButton();

        //10. Switch to original window back
        actionStepVoidPage.switchToDefaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertStepVoidPage.checkLeftSideMenu();
    }
}
