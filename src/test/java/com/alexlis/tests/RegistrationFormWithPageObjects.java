package com.alexlis.tests;

import com.alexlis.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void myFirstTest() {
        step("Открываем главную страницу", () -> {
        registrationPage.openPage();
        });

        step("Ввод первого блока персональной информации", () -> {
        registrationPage.typeFirstName("Alexei")
                .typeLastName("Lisenkov")
                .typeEmail("alexlis@mail.ru")
                .chooseGender("Male")
                .choosePhone("8999666555");
        });

        step("Ввод второго блока персональной информации", () -> {
        registrationPage.selectCalendar.setDate("15", "July", "2022");
        registrationPage.chooseSience("Physics")
                .chooseHobbies("Sports")
                .chooseHobbies("Music")
                .chooseHobbies("Reading")
                .uploadPicture("img/1.png")
                .typeAddress("Saint-Petersburg");
        registrationPage.stateComponent.setState("NCR");
        registrationPage.cityComponent.setCity("Delhi");
        registrationPage.clickButton();
        });

        step("Проверка формы создания пользователя", () -> {
        registrationPage.finalAssert();
        registrationPage.finalAssertOfTable();
        });
    }
}
