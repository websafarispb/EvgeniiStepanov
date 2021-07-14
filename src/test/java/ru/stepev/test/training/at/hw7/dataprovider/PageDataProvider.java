package ru.stepev.test.training.at.hw7.dataprovider;

import static ru.stepev.test.training.at.hw7.utils.PropertyReader.pageProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.testng.annotations.DataProvider;
import ru.stepev.test.training.at.hw7.model.User;
import ru.stepev.test.training.at.hw7.model.pages.MetalAndColorPageDate;
import ru.stepev.test.training.at.hw7.utils.JsonReader;

public class PageDataProvider {

    private static final int mountOfDateIndex = 2;

    @DataProvider(name = "Page Data Provider")
    public Object[][] pageObjects() {
        Map<String, MetalAndColorPageDate> jsonDate = null;
        try {
            jsonDate = JsonReader.readInMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<MetalAndColorPageDate> dataOfPage = new ArrayList<MetalAndColorPageDate>(jsonDate.values());
        User user = User.builder().name(pageProperty.getProperty("Page.userName"))
                        .password(pageProperty.getProperty("Page.userPassword")).build();

        AtomicInteger index = new AtomicInteger(0);
        Object[][] pages = new Object[dataOfPage.size()][mountOfDateIndex];
        Arrays.stream(pages).forEach(o -> {
            o[0] = user;
            o[1] = dataOfPage.get(index.getAndIncrement());
        });
        return pages;
    }
}
