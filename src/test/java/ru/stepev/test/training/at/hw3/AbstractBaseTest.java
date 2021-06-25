package ru.stepev.test.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw3.model.component.Image;
import ru.stepev.test.training.at.hw3.model.component.Item;
import ru.stepev.test.training.at.hw3.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw3.model.page.HomePage;
import ru.stepev.test.training.at.hw3.utils.WebDriverSingleton;

public abstract class AbstractBaseTest {

    protected HomePage homePage;
    protected FluentHomePage fluentHomePage;
    protected SoftAssert softAssertion;

    protected WebDriver actualFrameWithButton;
    protected List<Image> actualImagesOfIndexPage;
    protected String actualUserName;
    protected List<Item> actualHeaderMenu;
    protected List<Item> actualLeftSideMenu;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
