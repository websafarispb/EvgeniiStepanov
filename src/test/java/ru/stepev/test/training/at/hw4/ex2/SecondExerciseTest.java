package ru.stepev.test.training.at.hw4.ex2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw4.AbstractBaseTest;
import ru.stepev.test.training.at.hw4.dataprovider.PageDataProvider;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.page.DifferentElementsPage;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class SecondExerciseTest extends AbstractBaseTest {

    @Test(dataProvider = "Page Data Provider",
          dataProviderClass = PageDataProvider.class,
          description = "This is test with fluent page")
    public void exerciseSecondFluentPage(User user) {
        //
        //        //1. Open test site by URL
        //        fluentHomePage.open();
        //
        //        //2. Assert Browser title
        //        assertEquals(fluentHomePage.getTitle(), Page.expectedTitle);
        //
        //        // 3. Perform login
        //        //   fluentHomePage.login(user);
        //
        //        assertTrue(fluentHomePage.getCurrentUrl().endsWith(Page.endOfCurrentUrlPage));
        //
        //        //4. Assert Username is logged
        //        actualUserName = fluentHomePage.getFullUserName();
        //
        //        softAssertion.assertEquals(actualUserName, Page.expectedUserName);
        //
        //        //5. Open through the header menu Service -> Different Elements Page
        //        DifferentElementsPage differentElementsPage = fluentHomePage.clickDifferentElementsPage();
        //
        //        assertTrue(differentElementsPage.getCurrentUrl().endsWith(Page.endOfDifferentElementUrlPage));
        //
        //        //6. Select checkboxes
        //        checkboxSelected = differentElementsPage.getAndClickCheckbox(Page.clickedCheckboxItems);
        //        //7. Select radio
        //        differentElementsPage.getSelenRadioButton().click();
        //
        //        //8. Select in dropdown
        //        differentElementsPage.getYellowDropDownItem().click();
        //
        //        //9. Assert Log rows
        //
        //        actualLogRows = differentElementsPage.getLogRows();
        //
        //        assertEquals(actualLogRows, Page.expectedLogRows);
    }
}
