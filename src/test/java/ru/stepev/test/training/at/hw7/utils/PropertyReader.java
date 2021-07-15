package ru.stepev.test.training.at.hw7.utils;

import java.io.InputStream;
import java.util.Properties;
import ru.stepev.test.training.at.hw7.dataprovider.PageDataProvider;

public class PropertyReader {

    public static final Properties pageProperty;

    static {
        pageProperty = new Properties();
        InputStream is = PageDataProvider.class.getResourceAsStream("/pages.properties");
        try {
            pageProperty.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
