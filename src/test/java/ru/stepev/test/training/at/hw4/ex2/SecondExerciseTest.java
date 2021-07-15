package ru.stepev.test.training.at.hw4.ex2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw4.AbstractBaseTest;
import ru.stepev.test.training.at.hw4.dataprovider.PageDataProvider;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.page.DifferentElementsPage;
import ru.stepev.test.training.at.hw4.model.page.Page;

@Feature("Exercise two")
public class SecondExerciseTest extends AbstractBaseTest {

    @Test(dataProvider = "Page Data Provider",
          dataProviderClass = PageDataProvider.class,
          description = "This is test with fluent page")
    @Story("Exercise two good test")
    public void exerciseSecondFluentPage(User user) {

        //1. Open test site by URL
        actionStepFluentPage.openPage(Page.pageURL);
        //2. Assert Browser title
        assertStepFluentPage.assertPageTitle(Page.expectedTitle);
        // 3. Perform login
        actionStepFluentPage.login(user);
        assertStepFluentPage.assertEndOfPage(Page.endOfCurrentUrlPage);
        //4. Assert Username is logged
        assertStepFluentPage.assertEndOfPage(Page.endOfCurrentUrlPage);
        assertStepFluentPage.checkSuccessOfLoginOperation(Page.expectedUserName);
        //5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = actionStepFluentPage.openDifferentElementsPage();
        assertStepFluentPage
            .checkSuccessOfOpenDifferentElementsPage(differentElementsPage, Page.endOfDifferentElementUrlPage);
        //6. Select checkboxes
        actionStepFluentPage.clickOnCheckboxesOnDifferentElementsPage(differentElementsPage, Page.clickedCheckboxItems);
        //7. Select radio
        actionStepFluentPage.clickSelenRadioButtonOnDifferentElementsPage(differentElementsPage);
        //8. Select in dropdown
        actionStepFluentPage.clickYellowDropDownItemOnDifferentElementsPage(differentElementsPage);
        //9. Assert Log rows
        assertStepFluentPage.assertionLogRowsOnDifferentElementsPage(differentElementsPage);
    }
}
