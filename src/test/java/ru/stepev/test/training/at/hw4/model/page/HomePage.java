package ru.stepev.test.training.at.hw4.model.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.component.Button;
import ru.stepev.test.training.at.hw4.model.component.PageImages;
import ru.stepev.test.training.at.hw4.model.component.PageImagesText;
import ru.stepev.test.training.at.hw4.model.component.PageLabel;
import ru.stepev.test.training.at.hw4.model.component.PageLink;
import ru.stepev.test.training.at.hw4.model.component.PageMenu;
import ru.stepev.test.training.at.hw4.model.component.PageTextField;

public class HomePage implements BasePage {

    private WebDriver driver;
    private PageMenu headerMenu;
    private PageMenu leftSideMenu;
    private PageImages pageImages;
    private PageImagesText pageImagesText;
    private PageLink loginLink;
    private PageTextField userName;
    private PageTextField userPassword;
    private Button loginButton;
    private PageLabel fullUserName;
    private Button buttonOfFrame;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        userName = new PageTextField("HomePage.UserNameTextField", driver);
        userPassword = new PageTextField("HomePage.UserPasswordTextField", driver);
        fullUserName = new PageLabel("HomePage.FullUserName", driver);
        loginButton = new Button("HomePage.LoginButton", driver);
        buttonOfFrame = new Button("FramePage.Button", driver);
        headerMenu = new PageMenu("HomePage.HeaderMenu", driver);
        leftSideMenu = new PageMenu("HomePage.LeftSideMenu", driver);
        pageImages = new PageImages("HomePage.PageImages", driver);
        pageImagesText = new PageImagesText("HomePage.PageImagesText", driver);
        loginLink = new PageLink("HomePage.LoginLink", driver);
    }

    @Override
    public void open() {
        driver.navigate().to(Page.pageURL);
    }

    public void login(User user) {
        loginLink.getLink().click();
        userName.getPageTextField().sendKeys(user.getName());
        userPassword.getPageTextField().sendKeys(user.getPassword());
        loginButton.getButton().click();
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

    public PageMenu getHeaderMenu() {
        return headerMenu;
    }

    public String getFullUserName() {
        return fullUserName.getText();
    }

    public List<String> getTextOfImagesOnIndexPage() {
        return pageImagesText.getImagesText();
    }

    public PageMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public List<WebElement> getImagesOfPage() {
        return pageImages.getImages();
    }

    public Button getButtonOfFrame() {
        return buttonOfFrame;
    }
}
