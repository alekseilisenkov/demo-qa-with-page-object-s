package com.alexlis;

import com.alexlis.pages.RegistrationPage;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Регистрация")
    @Test
    @Description("Тест на заполнение формы регистрации")
    void fillFormTest() {
        step("Открываем страницу для заполнения формы https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });
        step("Вводим имя: " + TestData.firstName, () -> {
            registrationPage.typeFirstName(TestData.firstName);
        });
        step("Вводим фамилию: " + TestData.lastName, () -> {
            registrationPage.typeLastName(TestData.lastName);
        });
        step("Вводим адрес почты: " + TestData.email, () -> {
            registrationPage.typeEmail(TestData.email);
        });
        step("Выбираем пол", () -> {
            registrationPage.chooseGender("Female");
        });
        step("Вводим номер телефона: " + TestData.phoneNumber, () -> {
            registrationPage.typePhoneNumber(TestData.phoneNumber);
        });
        step("Выбирает дату рождения", () -> {
            registrationPage.setBirthdayDate("2001", "February", "3");
        });
        step("Выбираем предмет", () -> {
            registrationPage.chooseSubject("Maths");
        });
        step("Выбираем хобби", () -> {
            registrationPage.setHobbies("Reading");
        });
        step("Загружаем фотографию", () -> {
            registrationPage.uploadPicture("test.jpg");
        });
        step("Вводим адрес" + TestData.address, () -> {
            registrationPage.typeAddress(TestData.address);
        });
        step("Выбираем штат и город", () -> {
            registrationPage.setState("NCR")
                    .setCity("Delhi");
        });
        step("Нажимаем на кнопку submit и отправляем данные", () -> {
            registrationPage.submitForm();
        });

        step("Сверяем заполненные данные с загруженными", () -> {
            registrationPage.checkResultsValue("Student Name", TestData.firstName + " " + TestData.lastName)
                    .checkResultsValue("Student Email", TestData.email)
                    .checkResultsValue("Gender", "Female")
                    .checkResultsValue("Mobile", TestData.phoneNumber)
                    .checkResultsValue("Date of Birth", "03 February,2001")
                    .checkResultsValue("Subjects", "Maths")
                    .checkResultsValue("Hobbies", "Reading")
                    .checkResultsValue("Picture", "test.jpg")
                    .checkResultsValue("Address", TestData.address)
                    .checkResultsValue("State and City", "NCR Delhi");
        });

    }
}
