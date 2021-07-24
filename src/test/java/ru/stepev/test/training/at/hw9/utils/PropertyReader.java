package ru.stepev.test.training.at.hw9.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static final Properties pageProperty;

    static {
        pageProperty = new Properties();
        InputStream is = PropertyReader.class.getResourceAsStream("/trello.properties");
        try {
            pageProperty.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
