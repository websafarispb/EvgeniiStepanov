package ru.stepev.test.training.at.hw5.model.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stepev.test.training.at.hw5.model.User;
import ru.stepev.test.training.at.hw5.model.component.Button;
import ru.stepev.test.training.at.hw5.model.component.CheckBox;
import ru.stepev.test.training.at.hw5.model.component.CheckboxItem;
import ru.stepev.test.training.at.hw5.model.component.DropItem;
import ru.stepev.test.training.at.hw5.model.component.ImagesText;
import ru.stepev.test.training.at.hw5.model.component.Link;
import ru.stepev.test.training.at.hw5.model.component.Log;
import ru.stepev.test.training.at.hw5.model.component.Role;
import ru.stepev.test.training.at.hw5.utils.wrapperfactory.CustomFieldDecorator;

public class UserTablePage implements BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li")
    private List<Log> pageLogs;

    @FindBy(xpath = "//table[@id='user-table']//td[1]")
    private List<Log> numbers;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<CheckBox> checkBox;

    @FindBy(xpath = "//select")
    private List<DropItem> numberTypeDropdown;

    //   @FindBy(xpath = "//select//option[1]")
    @FindBy(xpath = "//option")
    private List<DropItem> roles;

    @FindBy(xpath = "//table[@id='user-table']//a")
    private List<Link> userLinks;

    @FindBy(xpath = "//table[@id='user-table']//span")
    private List<ImagesText> textAvatars;

    private List<User> users;

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
        users = Arrays.asList(
            User.builder().id(0).name("Roman").password("Jdi1234").role(Role.Admin).build(),
            User.builder().id(1).name("Sergey Ivan").password("").role(Role.User).build(),
            User.builder().id(2).name("Vladzimir").password("").role(Role.Manager).build(),
            User.builder().id(3).name("Helen Bennett").password("").role(Role.User).build(),
            User.builder().id(4).name("Yoshi Tannamuri").password("").role(Role.User).build(),
            User.builder().id(5).name("Giovanni Rovelli").password("").role(Role.User).build());
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

    public List<String> getLogRows() {
        return pageLogs.stream()
                       .map(e -> e.getText().substring(9))
                       .collect(Collectors.toList());
    }

    public List<CheckBox> getCheckBox() {
        return checkBox;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<DropItem> getNumberTypeDropdown() {
        return numberTypeDropdown;
    }

    public List<Link> getUserLinks() {
        return userLinks;
    }

    public List<ImagesText> getTextAvatars() {
        return textAvatars;
    }

    public List<Log> getNumbers() {
        return numbers;
    }

    public List<DropItem> getRoles() {
        return roles;
    }
}
