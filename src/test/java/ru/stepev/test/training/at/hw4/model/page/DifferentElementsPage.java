package ru.stepev.test.training.at.hw4.model.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw4.model.component.Button;
import ru.stepev.test.training.at.hw4.model.component.CheckboxItem;
import ru.stepev.test.training.at.hw4.model.component.DropItem;
import ru.stepev.test.training.at.hw4.model.component.PageCheckbox;
import ru.stepev.test.training.at.hw4.model.component.PageLog;

public class DifferentElementsPage implements BasePage {

    private WebDriver driver;
    private PageLog pageLog;
    private PageCheckbox checkbox;
    private DropItem yellowDropDownItem;
    private Button selenRadioButton;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        pageLog = new PageLog("HomePage.PageLogRows", driver);
        checkbox = new PageCheckbox("HomePage.CheckBox", driver);
        yellowDropDownItem = new DropItem("YellowDropItem", driver);
        selenRadioButton = new Button("SelenRadioButton", driver);
    }

    @Override
    public void open() {
        driver.navigate().to(Page.pageURL);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getAndClickCheckbox(List<CheckboxItem> items) {
        return checkbox.getAndClickCheckboxItems(items);
    }

    public WebElement getYellowDropDownItem() {
        return yellowDropDownItem.getDropItem();
    }

    public List<String> getLogRows() {
        return pageLog.getPageLog();
    }

    public WebElement getSelenRadioButton() {
        return selenRadioButton.getButton();
    }
}
