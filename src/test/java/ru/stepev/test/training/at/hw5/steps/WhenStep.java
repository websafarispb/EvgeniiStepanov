package ru.stepev.test.training.at.hw5.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import ru.stepev.test.training.at.hw5.model.User;
import ru.stepev.test.training.at.hw5.model.component.CheckboxItem;

public class WhenStep extends AbstractStep {

    @When("I click on {string} button in Header")
    public void clickOnServiceButtonInHeader(String headerMenuItem) {
        if (headerMenuItem.equals("Service")) {
            fluentHomePage.clickHeaderMenuService();
        } else {
            throw new NoSuchElementException(String.format("Menu doesn't have item with name s%", headerMenuItem));
        }
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceMenu(String subHeaderMenuItem) {
        if (subHeaderMenuItem.equals("User Table")) {
            userTablePage = fluentHomePage.clickUserTablePage();
        } else {
            if (subHeaderMenuItem.equals("Different elements")) {
                differentElementsPage = fluentHomePage.clickButtonDifferentElementsPage();
            } else {
                throw new NoSuchElementException(
                    String.format("Menu Servise doesn't have item with name s%", subHeaderMenuItem));
            }
        }
    }

    @ParameterType("'(.+)'")
    public List<String> checkboxNames(String indexes) {
        return Arrays.stream(indexes.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    @When("I select checkboxes {checkboxNames}")
    public void selectCheckbox(List<String> checkboxNames) {
        List<CheckboxItem> selectedCheckbox = checkboxNames.stream()
                                                           .map(CheckboxItem::valueOf)
                                                           .collect(Collectors.toList());
        differentElementsPage.clickCheckBox(selectedCheckbox);
    }

    @When("I select radio {string}")
    public void selectRadioButton(String radioName) {
        differentElementsPage.clickSelenRadioButton();
    }

    @When("I select in dropdown {string}")
    public void selectDropdown(String dropDownItem) {
        differentElementsPage.clickYellowDropDownItem();
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckBox(String userName) {
        Integer userId = userTablePage.getUsers().stream()
                                      .filter(user -> user.getName().equals(userName))
                                      .map(User::getId)
                                      .findFirst()
                                      .orElse(0);
        if (userId != 0) {
            userTablePage.getCheckBox().get(userId).click();
        } else {
            throw new NoSuchElementException(String.format("Page doesn't have user with name s%", userName));
        }
    }
}
