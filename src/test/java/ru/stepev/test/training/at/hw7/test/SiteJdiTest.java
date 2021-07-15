package ru.stepev.test.training.at.hw7.test;

import static org.testng.Assert.assertEquals;
import static ru.stepev.test.training.at.hw7.model.SiteJdi.homePage;
import static ru.stepev.test.training.at.hw7.model.SiteJdi.metalAndColorPage;
import static ru.stepev.test.training.at.hw7.model.pages.HomePage.loginForm;
import static ru.stepev.test.training.at.hw7.model.pages.HomePage.menuMetalsColors;
import static ru.stepev.test.training.at.hw7.model.pages.HomePage.userIcon;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.colors;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.elements;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.evenButtons;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.log;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.logOut;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.metals;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.oddButtons;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.submit;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.vegetables;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.vegetablesButton;
import static ru.stepev.test.training.at.hw7.model.pages.MetalAndColor.vegetablesLabels;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Text;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw7.dataprovider.PageDataProvider;
import ru.stepev.test.training.at.hw7.model.User;
import ru.stepev.test.training.at.hw7.model.pages.MetalAndColorPageDate;

public class SiteJdiTest implements TestsInit {

    @Test(dataProvider = "Page Data Provider",
          dataProviderClass = PageDataProvider.class)
    public void givenSiteJdiWithMetalAndColorPage_whenFillAllFieldsOnMetalAndColorPage_thenLogContainsAllDate(
        User user, MetalAndColorPageDate expectedMetalAndColorPageDate) {
        homePage.open();
        homePage.logIn(user);
        homePage.openMetalsColorsPage();

        metalAndColorPage.setFieldsAndSubmit(expectedMetalAndColorPageDate);
        List<String> actualLog = metalAndColorPage.getLog();
        metalAndColorPage.logOut();

        MetalAndColorPageDate actualMetalAndColorPageDate = new MetalAndColorPageDate(actualLog);
        expectedMetalAndColorPageDate.makeSummary();

        assertEquals(actualMetalAndColorPageDate, expectedMetalAndColorPageDate);
    }
}
