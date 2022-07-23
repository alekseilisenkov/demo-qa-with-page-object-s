package com.alexlis.tests;

import com.alexlis.config.CredentialsConfig;
import com.alexlis.helpers.Attach;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {

    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {
 //       String selenoidUrl = System.getProperty("url", credentials.browserURL());        // clean properties_test -Durl={'JENKINS_VALUE'}
        String browserURL = System.getProperty("url", credentials.browserURL());
        String browserVersion = System.getProperty("browserVersion");

        String login = credentials.login();
        String password = credentials.password();

        String browserSize = System.getProperty("browserSize", "1280x1280");


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
//        Configuration.startMaximized = true;
//        Configuration.remote = format("https://%s:%s@%s" + login, password, selenoidUrl);
        Configuration.remote = format("https://%s:%s@%s", login, password, browserURL);
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


    }

    public static void main(String[] args) {
        String selenoidUrl = System.getProperty("browser", credentials.browserURL());
        String login = credentials.login();
        String password = credentials.password();
        Configuration.remote = format("https://%s:%s@%s" + login, password, selenoidUrl);
        System.out.println(format("https://%s:%s@%s" + login, password, selenoidUrl));
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
