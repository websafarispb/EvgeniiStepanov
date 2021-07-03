package ru.stepev.test.training.at.hw7.dataprovider;

import static ru.stepev.test.training.at.hw7.utils.PropertyReader.pageProperty;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.DataProvider;
import ru.stepev.test.training.at.hw7.model.User;
import ru.stepev.test.training.at.hw7.model.pages.MetalAndColorPageDate;
import ru.stepev.test.training.at.hw7.utils.JsonReader;

public class PageDataProvider {

    @DataProvider(name = "Page Data Provider")
    public Object[][] pageObjects() {
        Map<String, MetalAndColorPageDate> jsonDate = null;
        try {
            jsonDate = JsonReader.readInMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[][] {
            {User.builder().name(pageProperty.getProperty("Page.userName"))
                 .password(pageProperty.getProperty("Page.userPassword")).build(), jsonDate.get("data_1")},
            {User.builder().name(pageProperty.getProperty("Page.userName"))
                 .password(pageProperty.getProperty("Page.userPassword")).build(), jsonDate.get("data_2")},
            {User.builder().name(pageProperty.getProperty("Page.userName"))
                 .password(pageProperty.getProperty("Page.userPassword")).build(), jsonDate.get("data_3")},
            {User.builder().name(pageProperty.getProperty("Page.userName"))
                 .password(pageProperty.getProperty("Page.userPassword")).build(), jsonDate.get("data_4")},
            {User.builder().name(pageProperty.getProperty("Page.userName"))
                 .password(pageProperty.getProperty("Page.userPassword")).build(), jsonDate.get("data_5")}
        };
    }
}
