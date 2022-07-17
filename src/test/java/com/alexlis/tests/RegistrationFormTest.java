package com.alexlis.tests;

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
        step("Открытие страницы для заполнения формы", () -> {
            registrationPage.openPage();
        });
        step("Ввод имени: " + TestData.firstName, () -> {
            registrationPage.typeFirstName(TestData.firstName);
        });
        step("Ввод фамилии: " + TestData.lastName, () -> {
            registrationPage.typeLastName(TestData.lastName);
        });
        step("Ввод адреса почты: " + TestData.email, () -> {
            registrationPage.typeEmail(TestData.email);
        });
        step("Выбор пола", () -> {
            registrationPage.chooseGender("Female");
        });
        step("Ввод номера телефона: " + TestData.phoneNumber, () -> {
            registrationPage.typePhoneNumber(TestData.phoneNumber);
        });
        step("Выбор даты", () -> {
            registrationPage.setBirthdayDate("2001", "February", "3");
        });
        step("Выбор предмета", () -> {
            registrationPage.chooseSubject("Maths");
        });
        step("Выбор хобби", () -> {
            registrationPage.setHobbies("Reading");
        });
        step("Загрузка фото", () -> {
            registrationPage.uploadPicture("image/test.jpg");
        });
        step("Ввод адреса: " + TestData.address, () -> {
            registrationPage.typeAddress(TestData.address);
        });
        step("Выбор штата и города", () -> {
            registrationPage.setState("NCR")
                    .setCity("Delhi");
        });
        step("Нажатие на кнопку submit", () -> {
            registrationPage.submitForm();
        });

        step("Проверка заполненных данных", () -> {
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
