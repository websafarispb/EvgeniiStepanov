package ru.stepev.test.training.at.hw7.utils;

import static ru.stepev.test.training.at.hw7.utils.PropertyReader.pageProperty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import ru.stepev.test.training.at.hw7.model.pages.MetalAndColorPageDate;

public class JsonReader {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ClassLoader classLoader = JsonReader.class.getClassLoader();
    private static File file =
        new File(isWindows() ? pageProperty.getProperty("json.win.file") : pageProperty.getProperty("json.unix.file"));

    public static Map<String, MetalAndColorPageDate> readInMap() throws IOException {
        return objectMapper.readValue(file, new TypeReference<Map<String, MetalAndColorPageDate>>() {
        });
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }
}
