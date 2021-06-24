package ru.stepev.test.training.at.hw4.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stepev.test.training.at.hw4.model.User;
import ru.stepev.test.training.at.hw4.model.component.Button;
import ru.stepev.test.training.at.hw4.model.component.HeaderMenuItem;
import ru.stepev.test.training.at.hw4.model.component.PageLabel;
import ru.stepev.test.training.at.hw4.model.component.PageLink;
import ru.stepev.test.training.at.hw4.model.component.PageTextField;

public class FluentHomePage implements BasePage {

    private WebDriver driver;
    private PageLink loginLink;
    private HeaderMenuItem headerMenuItemService;
    private PageLink itemDifferentElementsPage;
    private PageTextField userName;
    private PageTextField userPassword;
    private Button loginButton;
    private PageLabel fullUserName;

    public FluentHomePage(WebDriver driver) {
        this.driver = driver;
        userName = new PageTextField("HomePage.UserNameTextField", driver);
        userPassword = new PageTextField("HomePage.UserPasswordTextField", driver);
        fullUserName = new PageLabel("HomePage.FullUserName", driver);
        loginButton = new Button("HomePage.LoginButton", driver);
        loginLink = new PageLink("HomePage.LoginLink", driver);
        headerMenuItemService = new HeaderMenuItem("HomePage.HeaderMenuServiceItem", driver);
        itemDifferentElementsPage = new PageLink("HomePage.ItemDifferentElementsPage", driver);
    }

    @Override
    public void open() {
        driver.navigate().to(Page.pageURL);
    }

    public FluentHomePage login(User user) {
        loginLink.getLink().click();
        userName.getPageTextField().sendKeys(user.getName());
        userPassword.getPageTextField().sendKeys(user.getPassword());
        loginButton.getButton().click();
        return this;
    }

    public DifferentElementsPage clickDifferentElementsPage() {
        getHeaderMenuService().click();
        getItemDifferentElementsPage().click();
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

    public WebElement getHeaderMenuService() {
        return headerMenuItemService.getHeaderMenuItem();
    }

    public WebElement getItemDifferentElementsPage() {
        return itemDifferentElementsPage.getLink();
    }
}
