package ru.stepev.test.training.at.hw2.ex2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw2.AbstractBaseTest;
import ru.stepev.test.training.at.hw2.model.Page;

public class SecondExerciseTest extends AbstractBaseTest {

    @Test
    public void exercise2() {
        //1. Open test site by URL
        driver.navigate().to(Page.pageURL);

        //2. Assert Browser title
        assertEquals(driver.getTitle(), Page.expectedTitle);

        //3. Perform login
        driver.findElement(By.xpath(Page.loginLinkXpath)).click();
        driver.findElement(By.id(Page.nameId)).sendKeys(Page.userName);
        driver.findElement(By.id(Page.passwordId)).sendKeys(Page.password);
        driver.findElement(By.id(Page.loginButtonId)).click();

        assertTrue(driver.getCurrentUrl().endsWith(Page.endOfCurrentUrlPage));

        //4. Assert Username is logged
        actualUserName = driver.findElement(By.id(Page.userNameId)).getText();

        assertEquals(actualUserName, Page.expectedUserName);

        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.xpath(Page.headerMenuServiceXpath)).click();
        driver.findElement(By.xpath(Page.menuItemDifferentElementsPageXpath)).click();

        assertTrue(driver.getCurrentUrl().endsWith(Page.endOfDifferentElementUrlPage));

        //6. Select checkboxes
        checkbox = driver.findElements(By.xpath(Page.checkboxXpath));
        checkboxSelected = checkbox.stream()
                                   .filter(
                                       e -> e.getText().equals(Page.nameCheckboxWater) || e
                                           .getText().equals(Page.nameCheckboxWind))
                                   .peek(WebElement::click)
                                   .collect(Collectors.toList());
        //7. Select radio
        selenRadioButton = driver.findElement(By.xpath(Page.selenRadioButtonXpath));
        selenRadioButton.click();

        //8. Select in dropdown
        yellowDropDawnItem = driver.findElement(By.xpath(Page.yellowDropDownItemXpath));
        yellowDropDawnItem.click();

        //9. Assert Log rows
        logRows = driver.findElements(By.xpath(Page.logRowsXpath));
        actualLogRows = logRows.stream()
                               .map(e -> e.getText().replaceAll("[0-9]", ""))
                               .collect(Collectors.toList());

        assertEquals(actualLogRows, Page.expectedLogRows);
    }
}
