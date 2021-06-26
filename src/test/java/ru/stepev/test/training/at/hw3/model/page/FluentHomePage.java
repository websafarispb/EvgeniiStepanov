package ru.stepev.test.training.at.hw3.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stepev.test.training.at.hw3.model.User;
import ru.stepev.test.training.at.hw3.model.component.Button;
import ru.stepev.test.training.at.hw3.utils.wrapperfactory.CustomFieldDecorator;
import ru.stepev.test.training.at.hw3.model.component.Link;
import ru.stepev.test.training.at.hw3.model.component.MenuItem;
import ru.stepev.test.training.at.hw3.model.component.TextField;
import ru.stepev.test.training.at.hw3.model.component.TextLabel;

public class FluentHomePage implements BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='#']")
    private Link loginLink;

    @FindBy(xpath = "//header//a[@class='dropdown-toggle']")
    private MenuItem headerMenuService;

    @FindBy(xpath = "//header//a[@href='different-elements.html']")
    private Link linkDifferentElementsPage;

    @FindBy(id = "name")
    private TextField userName;

    @FindBy(id = "password")
    private TextField userPassword;

    @FindBy(id = "login-button")
    private Button loginButton;

    @FindBy(id = "user-name")
    public TextLabel fullUserName;

    public FluentHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    @Override
    public void open() {
        driver.navigate().to(Page.pageURL);
    }

    public FluentHomePage login(User user) {
        loginLink.click();
        userName.sendKeys(user.getName());
        userPassword.sendKeys(user.getPassword());
        loginButton.click();
        return this;
    }

    public DifferentElementsPage clickDifferentElementsPage() {
        headerMenuService.click();
        linkDifferentElementsPage.click();
        return new DifferentElementsPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getFullUserName() {
        return fullUserName.getText();
    }
}
