package ru.stepev.test.training.at.hw6.model.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stepev.test.training.at.hw6.model.component.Button;
import ru.stepev.test.training.at.hw6.model.component.CheckBox;
import ru.stepev.test.training.at.hw6.model.component.CheckboxItem;
import ru.stepev.test.training.at.hw6.model.component.DropItem;
import ru.stepev.test.training.at.hw6.model.component.Log;
import ru.stepev.test.training.at.hw6.utils.wrapperfactory.CustomFieldDecorator;

public class DifferentElementsPage implements BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li")
    private List<Log> pageLogs;

    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<CheckBox> checkBox;

    @FindBy(xpath = "//select[@class='uui-form-element']//option[4]")
    private DropItem yellowDropDownItem;

    @FindBy(xpath = "//label[@class='label-radio'][4]")
    private Button selenRadioButton;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    @Override
    public void open(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<CheckBox> clickCheckBox(List<CheckboxItem> items) {
        return checkBox.stream()
                       .filter(e -> items.contains(CheckboxItem.valueOf(e.getText())))
                       .peek(CheckBox::click)
                       .collect(Collectors.toList());
    }

    public DropItem getYellowDropDownItem() {
        return yellowDropDownItem;
    }

    public List<String> getLogRows() {
        return pageLogs.stream()
                       .map(e -> e.getText().replaceAll("[0-9]", ""))
                       .collect(Collectors.toList());
    }

    public Button getSelenRadioButton() {
        return selenRadioButton;
    }
}
