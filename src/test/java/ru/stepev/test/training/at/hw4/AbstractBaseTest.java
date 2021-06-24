package ru.stepev.test.training.at.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import ru.stepev.test.training.at.hw4.model.component.MenuItem;
import ru.stepev.test.training.at.hw4.model.page.FluentHomePage;
import ru.stepev.test.training.at.hw4.model.page.HomePage;
import ru.stepev.test.training.at.hw4.steps.ActionStep;
import ru.stepev.test.training.at.hw4.steps.AssertStep;
import ru.stepev.test.training.at.hw4.utils.WebDriverSingleton;

public abstract class AbstractBaseTest {


    protected ActionStep actionStep;
    protected AssertStep assertStep;
    protected WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest(ITestContext context) {
        this.driver = WebDriverSingleton.getDriver();
        this.driver.manage().window().maximize();
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            WebDriverSingleton.closeDriver();
        }
    }
}
