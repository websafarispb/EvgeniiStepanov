package ru.stepev.test.training.at.hw4.model.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.component.Button;
import ru.stepev.test.training.at.hw4.model.component.Image;
import ru.stepev.test.training.at.hw4.model.component.ImagesText;
import ru.stepev.test.training.at.hw4.model.component.Item;
import ru.stepev.test.training.at.hw4.model.component.Link;
import ru.stepev.test.training.at.hw4.model.component.MenuItem;
import ru.stepev.test.training.at.hw4.model.component.TextField;
import ru.stepev.test.training.at.hw4.model.component.TextLabel;
import ru.stepev.test.training.at.hw4.utils.wrapperfactory.CustomFieldDecorator;

public class HomePage implements BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//following-sibling::a")
    private List<MenuItem> headerMenu;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']//following-sibling::a")
    private List<MenuItem> leftSideMenu;

    @FindBy(xpath = "//span[contains(@class,  'icons-benefit icon-')]")
    private List<Image> images;

    @FindBy(xpath = "//span[contains(@class,  'benefit-txt')]")
    public List<ImagesText> imagesText;

    @FindBy(xpath = "//a[@href='#']")
    private Link loginLink;

    @FindBy(id = "name")
    private TextField userName;

    @FindBy(id = "password")
    private TextField userPassword;

    @FindBy(id = "login-button")
    public Button loginButton;

    @FindBy(xpath = "//input[@value='Frame Button']")
    public Button buttonOfFrame;

    @FindBy(id = "user-name")
    public TextLabel fullUserName;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    @Override
    public void open(String url) {
        driver.navigate().to(url);
    }

    public void login(User user) {
        loginLink.click();
        userName.sendKeys(user.getName());
        userPassword.sendKeys(user.getPassword());
        loginButton.click();
    }

    public WebDriver switchToFrame(String frameName) {
        return driver.switchTo().frame(frameName);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<Item> getHeaderMenu() {
        return headerMenu.stream()
                         .map(menuItem -> new Item(menuItem))
                         .collect(Collectors.toList());
    }

    public String getFullUserName() {
        return fullUserName.getText();
    }

    public List<Item> getLeftSideMenu() {
        return leftSideMenu.stream()
                           .map(menuItem -> new Item(menuItem))
                           .collect(Collectors.toList());
    }

    public List<Image> getImages() {
        return images;
    }

    public Button getButtonOfFrame() {
        return buttonOfFrame;
    }

    public List<String> getImagesText() {
        return imagesText.stream()
                         .map(ImagesText::getText)
                         .collect(Collectors.toList());
    }
}
