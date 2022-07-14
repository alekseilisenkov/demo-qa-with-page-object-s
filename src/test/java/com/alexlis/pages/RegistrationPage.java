package com.alexlis.pages;

import com.alexlis.pages.components.CalendarComponent;
import com.alexlis.pages.components.CityComponent;
import com.alexlis.pages.components.StateComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    public CalendarComponent selectCalendar = new CalendarComponent();
    public StateComponent stateComponent = new StateComponent();
    public CityComponent cityComponent = new CityComponent();

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            genderButton = $("#genterWrapper"),
            hobbiesButton = $("#hobbiesWrapper"),
            inputPhone = $("#userNumber"),
            inputSience = $("#subjectsInput"),
            uploadPicturepath = $("#uploadPicture"),
            clickPath = $("#submit"),
            assertPage = $(".modal-title"),
            assertTable = $(".table-responsive");


    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender(String value) {
        genderButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage chooseHobbies(String value) {
        hobbiesButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage choosePhone(String value) {
        inputPhone.setValue(value).click();
        return this;
    }

    public RegistrationPage chooseSience(String value) {
        inputSience.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicturepath.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage clickButton() {
        clickPath.click();
        return this;
    }

    public void finalAssert() {
        assertPage.shouldHave(text("Thanks for submitting the form"));
    }

    public void finalAssertOfTable() {
        assertTable.shouldHave(text("Alexei Lisenkov"), text("alexlis@mail.ru"), text("Male"), text("8999666555"),
                text("Saint-Petersburg"), text("NCR Delhi"));
    }
}
