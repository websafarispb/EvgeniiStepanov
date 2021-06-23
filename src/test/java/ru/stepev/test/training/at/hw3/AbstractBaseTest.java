package ru.stepev.test.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw3.model.component.MenuItem;
import ru.stepev.test.training.at.hw3.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw3.model.page.HomePage;
import ru.stepev.test.training.at.hw3.utils.WebDriverSingleton;

public abstract class AbstractBaseTest {

    protected HomePage homePage;
    protected FluentHomePage fluentHomePage;
    protected SoftAssert softAssertion;

    protected WebDriver actualFrameWithButton;
    protected List<WebElement> actualImagesOfIndexPage;
    protected List<WebElement> checkboxSelected;
    protected String actualUserName;
    protected List<MenuItem> actualHeaderMenu;
    protected List<MenuItem> actualLeftSideMenu;
    protected List<String> actualImagesText;
    protected List<String> actualLogRows;
    protected WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        this.driver = WebDriverSingleton.getDriver();
        this.driver.manage().window().maximize();
        homePage = new HomePage(driver);
        fluentHomePage = new FluentHomePage(driver);
        softAssertion = new SoftAssert();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            WebDriverSingleton.closeDriver();
        }
    }
}
