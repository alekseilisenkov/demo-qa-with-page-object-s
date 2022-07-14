package com.alexlis.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

public class TestBase {

    @Disabled
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3840x2400";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
