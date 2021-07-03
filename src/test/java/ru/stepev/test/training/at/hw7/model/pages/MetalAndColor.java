package ru.stepev.test.training.at.hw7.model.pages;

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
}
