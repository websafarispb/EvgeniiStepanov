package ru.stepev.test.training.at.hw5.utils;

public class Converter {

    public static String convertStringToEndUrlHtml(String endUrl) {
        String[] endUrlPage = endUrl.toLowerCase().split(" ");
        return String.format("%s-%s.html", endUrlPage[0], endUrlPage[1]);
    }
}
