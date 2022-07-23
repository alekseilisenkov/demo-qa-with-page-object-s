package com.alexlis.properties;

import com.alexlis.config.CredentialsConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class OwnerTests {
public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login + password);

        String message = format("i login as %s with password %s", login, password);
        System.out.println(message);
    }
}
