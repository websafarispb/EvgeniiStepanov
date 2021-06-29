package ru.stepev.test.training.at.hw5.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;
import ru.stepev.test.training.at.hw5.utils.Converter;

public class ThenStep extends AbstractStep {

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String wordForEndUrlPage) {
        if (wordForEndUrlPage.equals("Different elements")) {
            assertTrue(
                differentElementsPage.getCurrentUrl().endsWith(Converter.convertStringToEndUrlHtml(wordForEndUrlPage)));
        } else {
            assertTrue(
                userTablePage.getCurrentUrl().endsWith(Converter.convertStringToEndUrlHtml(wordForEndUrlPage)));
        }
    }

    @Then("^Log rows should contain following values:$")
    public void logRowsShouldContainValues(List<String> expectedLogRows) {
        assertEquals(differentElementsPage.getLogRows(), expectedLogRows);
    }

    @Then("1 log row has {string} text in log section")
    public void logRowsShouldContainValue(String expectedLogRow) {
        assertTrue(userTablePage.getLogRows().contains(expectedLogRow));
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropDown() {
        assertEquals(userTablePage.getNumberTypeDropdown().size(), 6);
        userTablePage.getNumberTypeDropdown().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        softAssertion.assertAll();
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkUsersLinksWithNamesAreDisplayed() {
        assertEquals(userTablePage.getUserLinks().size(), 6);
        userTablePage.getUserLinks().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        softAssertion.assertAll();
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionTextUserAvatarsAreDisplayed() {
        assertEquals(userTablePage.getTextAvatars().size(), 6);
        userTablePage.getTextAvatars().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        softAssertion.assertAll();
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkBoxesAreDisplayed() {
        assertEquals(userTablePage.getCheckBox().size(), 6);
        userTablePage.getCheckBox().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));
        softAssertion.assertAll();
    }

    @Then("^User table should contain following values:$")
    public void checkValuesOfUserTable(DataTable expectedValues) {

        List<String> expectedNumbers = expectedValues.column(0).subList(1, expectedValues.column(2).size());
        List<String> actualNumbers = userTablePage.getNumbers().stream()
                                                  .map(n -> n.getText().replaceAll("\\n", " "))
                                                  .collect(Collectors.toList());

        List<String> expectedNames = expectedValues.column(1).subList(1, expectedValues.column(2).size());
        List<String> actualNames = userTablePage.getUserLinks().stream()
                                                .map(n -> n.getText().replaceAll("\\n", " "))
                                                .collect(Collectors.toList());

        List<String> expectedDescriptions = expectedValues.column(2).subList(1, expectedValues.column(2).size());
        List<String> actualDescriptions = userTablePage.getTextAvatars().stream()
                                                       .map(n -> n.getText().replaceAll("\\n", " "))
                                                       .collect(Collectors.toList());

        softAssertion.assertEquals(actualNumbers, expectedNumbers);
        softAssertion.assertEquals(actualNames, expectedNames);
        softAssertion.assertEquals(actualDescriptions, expectedDescriptions);
        softAssertion.assertAll();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkValuesFromUsersDroplist(List<String> expectedDropListValues) {
        List<String> actualDropListValues =
            userTablePage.getRoles().subList(0, 3).stream().map(d -> d.getText()).collect(
                Collectors.toList());
        assertEquals(actualDropListValues, expectedDropListValues.subList(1, expectedDropListValues.size()));
    }
}
