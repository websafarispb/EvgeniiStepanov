package ru.stepev.test.training.at.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stepev.test.training.at.hw6.steps.ActionStepFluentPage;
import ru.stepev.test.training.at.hw6.steps.ActionStepVoidPage;
import ru.stepev.test.training.at.hw6.steps.AssertStepFluentPage;
import ru.stepev.test.training.at.hw6.steps.AssertStepVoidPage;
import ru.stepev.test.training.at.hw6.utils.WebDriverSingleton;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected ActionStepVoidPage actionStepVoidPage;
    protected AssertStepVoidPage assertStepVoidPage;
    protected ActionStepFluentPage actionStepFluentPage;
    protected AssertStepFluentPage assertStepFluentPage;

    protected WebDriver actualFrameWithButton;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest(ITestContext context) {
        this.driver = WebDriverSingleton.getDriver();
        this.driver.manage().window().maximize();
        actionStepVoidPage = new ActionStepVoidPage(driver);
        assertStepVoidPage = new AssertStepVoidPage(driver);
        actionStepFluentPage = new ActionStepFluentPage(driver);
        assertStepFluentPage = new AssertStepFluentPage(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            WebDriverSingleton.closeDriver();
        }
    }
}
