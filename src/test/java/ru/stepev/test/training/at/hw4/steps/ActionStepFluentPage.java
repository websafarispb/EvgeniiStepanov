package ru.stepev.test.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.component.CheckboxItem;
import ru.stepev.test.training.at.hw4.model.page.DifferentElementsPage;
import ru.stepev.test.training.at.hw4.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw4.model.page.Page;

public class ActionStepFluentPage extends AbstractStep {

    protected FluentHomePage fluentHomePage;

    public ActionStepFluentPage(WebDriver driver) {
        super(driver);
        fluentHomePage = new FluentHomePage(driver);
    }

    @Step("Opening Page with {url} using Void Page Object pattern")
    public void openPage(String url) {
        fluentHomePage.open(url);
    }

    @Step("Enter user's login and password {user}")
    public void login(User user) {
        fluentHomePage.login(user);
    }

    @Step("Open different element page")
    public DifferentElementsPage openDifferentElementsPage() {
        return fluentHomePage.clickDifferentElementsPage();
    }

    @Step("Click on checkbox on DifferentElementsPage {clickedCheckboxItems}")
    public void clickOnCheckboxesOnDifferentElementsPage(DifferentElementsPage differentElementsPage,
                                                         List<CheckboxItem> clickedCheckboxItems) {
        differentElementsPage.clickCheckBox(clickedCheckboxItems);
    }

    @Step("Click on SelenRadioButton on DifferentElementsPage")
    public void clickSelenRadioButtonOnDifferentElementsPage(DifferentElementsPage differentElementsPage) {
        differentElementsPage.getSelenRadioButton().click();
    }

    @Step("Click on YellowDropDownItem on DifferentElementsPage")
    public void clickYellowDropDownItemOnDifferentElementsPage(DifferentElementsPage differentElementsPage) {
        differentElementsPage.getYellowDropDownItem().click();
    }
}
