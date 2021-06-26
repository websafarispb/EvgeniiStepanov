package ru.stepev.test.training.at.hw3.dataprovider;

import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import ru.stepev.test.training.at.hw3.model.User;

public class PageDataProvider {

    private static final Properties pageProperty;

    static {
        pageProperty = new Properties();
        InputStream is = PageDataProvider.class.getResourceAsStream("/pages.properties");
        try {
            pageProperty.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DataProvider(name = "Page Data Provider")
    public Object[][] pageObjects() {
        return new Object[][] {
            {User.builder().name(pageProperty.getProperty("Page.userName"))
                 .password(pageProperty.getProperty("Page.userPassword")).build()}
        };
    }
}
