package ru.stepev.test.training.at.hw7.model.pages;

import static ru.stepev.test.training.at.hw7.model.pages.HomePage.userIcon;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.List;
import java.util.stream.Collectors;

public class MetalAndColor extends WebPage {

    @XPath("//p[@class='checkbox']//label")
    public static Checklist elements;
    @XPath("//ul[@class='panel-body-list results']")
    public static JList<Text> log;
    @UI("[name=custom_radio_odd]")
    public static RadioButtons oddButtons;
    @UI("[name=custom_radio_even]")
    public static RadioButtons evenButtons;
    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;
    @JDropdown(root = "div[ui=combobox]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown metals;
    @XPath("//a[@class='checkbox']//input")
    public static Checklist vegetables;
    @XPath("//a[@class='checkbox']//label")
    public static Checklist vegetablesLabels;
    @XPath("(//button[@class='btn btn-default dropdown-toggle'])")
    public static Button vegetablesButton;
    @XPath(".//button[@type='submit' and contains(.,'Calculate')]")
    public static Button calculate;
    @XPath(".//button[@type='submit' and contains(.,'Submit')]")
    public static Button submit;
    @XPath(".//div[@class='logout']")
    public static Button logOut;

    public void logOut() {
        userIcon.click();
        logOut.click();
    }

    public List<String> getLog() {
        return log.stream().map(Text::getValue).collect(Collectors.toList());
    }

    public void setFieldsAndSubmit(MetalAndColorPageDate expectedMetalAndColorPageDate) {
        String add = expectedMetalAndColorPageDate.getSummary().get(0).toString();
        String even = expectedMetalAndColorPageDate.getSummary().get(1).toString();
        oddButtons.select(add);
        evenButtons.select(even);
        expectedMetalAndColorPageDate.getElements().stream().forEach(e -> elements.get(e).click());
        colors.select(expectedMetalAndColorPageDate.getColor());
        metals.select(expectedMetalAndColorPageDate.getMetals());
        vegetablesButton.click();
        List<UIElement> myList = vegetables.list().stream()
                                           .filter(v -> v.isSelected()).collect(Collectors.toList());

        List<String> selectedLabels = myList.stream()
                                            .map(UIElement::label)
                                            .map(Label::getText)
                                            .collect(Collectors.toList());
        selectedLabels.forEach(l -> vegetablesLabels.get(l).click());
        expectedMetalAndColorPageDate.getVegetables().stream().forEach(e -> vegetablesLabels.get(e).click());

        submit.click();
    }
}
