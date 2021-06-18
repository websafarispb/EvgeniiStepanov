package ru.stepev.test.training.at.hw2.ex1;

import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw2.AbstractBaseTest;
import ru.stepev.test.training.at.hw2.model.MenuItem;
import ru.stepev.test.training.at.hw2.model.Page;

public class FirstExerciseWithSoftAssertionTest extends AbstractBaseTest {

    @Test
    public void exercise1() {
        //1. Open test site by URL
        driver.navigate().to(Page.pageURL);

        // 2. Assert Browser title
        softAssertion.assertEquals(driver.getTitle(), Page.expectedTitle);

        // 3. Perform login
        driver.findElement(By.xpath(Page.loginLinkXpath)).click();
        driver.findElement(By.id(Page.nameId)).sendKeys(Page.userName);
        driver.findElement(By.id(Page.passwordId)).sendKeys(Page.password);
        driver.findElement(By.id(Page.loginButtonId)).click();

        softAssertion.assertTrue(driver.getCurrentUrl().endsWith(Page.endOfCurrentUrlPage));

        //4. Assert Username is logged
        actualUserName = driver.findElement(By.id(Page.userNameId)).getText();

        softAssertion.assertEquals(actualUserName, Page.expectedUserName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        headerMenuItems = driver.findElements(By.xpath(Page.headerMenuItemsXpath));
        actualHeaderMenu = headerMenuItems.stream()
                                          .map(e -> new MenuItem(e.getText(), e.isDisplayed()))
                                          .collect(Collectors.toList());
        softAssertion.assertEquals(actualHeaderMenu, Page.expectedHeaderMenu);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        imagesOfIndexPage = driver.findElements(By.xpath(Page.imagesTextOfIndexPageXpath));
        imagesOfIndexPage.stream().forEach(p -> softAssertion.assertTrue(p.isDisplayed()));

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        actualImagesText = driver.findElements(By.xpath(Page.imagesTextOfIndexPageXpath))
                                 .stream()
                                 .map(WebElement::getText)
                                 .collect(Collectors.toList());
        softAssertion.assertEquals(actualImagesText, Page.expectedImagesText);

        //8. Assert that there is the iframe with “Frame Button” exist
        actualFrameWithButton = driver.switchTo().frame(Page.frameId);
        softAssertion.assertEquals(actualFrameWithButton.getTitle(), Page.expectedTitle);

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actualButtonOfFrame = actualFrameWithButton.findElement(By.xpath(Page.actualButtonOfFrameXpath));
        softAssertion.assertTrue(actualButtonOfFrame.isDisplayed());

        //10. Switch to original window back
        actualFrameWithButton.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        leftSideMenuItems =
            driver.findElements(By.xpath(Page.leftSideMenuItemsXpath));
        actualLeftSideMenu = leftSideMenuItems.stream().map(e -> new MenuItem(e.getText(), e.isDisplayed())).collect(
            Collectors.toList());

        softAssertion.assertEquals(actualLeftSideMenu, Page.expectedLeftSideMenu);

        softAssertion.assertAll();
    }
}
