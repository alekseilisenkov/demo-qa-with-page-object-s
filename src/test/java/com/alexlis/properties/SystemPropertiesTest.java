package com.alexlis.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    void simpleTest() {
        System.setProperty("value", "another_value");
        String value = System.getProperty("value", "default_value");
        System.out.println(value);
    }


    // Для тренировки
    @Test
    void simpleTest2() {
        String value = System.getProperty("browser", "chrome");
        String size = System.getProperty("size", "300x300");

        System.out.println(value);
        System.out.println(size);
    }
}
