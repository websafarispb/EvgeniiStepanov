package ru.stepev.test.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw2.model.MenuItem;
import ru.stepev.test.training.at.hw2.model.Page;

public abstract class AbstractBaseTest {

    protected SoftAssert softAssertion;
    protected WebDriver driver;
    protected WebDriver actualFrameWithButton;
    protected WebElement actualButtonOfFrame;
    protected WebElement selenRadioButton;
    protected WebElement yellowDropDawnItem;
    protected List<WebElement> headerMenuItems;
    protected List<WebElement> leftSideMenuItems;
    protected List<WebElement> imagesOfIndexPage;
    protected List<WebElement> checkbox;
    protected List<WebElement> checkboxSelected;
    protected List<WebElement> logRows;
    protected String actualUserName;
    protected List<MenuItem> actualHeaderMenu;
    protected List<MenuItem> actualLeftSideMenu;
    protected List<String> actualImagesText;
    protected List<String> actualLogRows;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        softAssertion = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
