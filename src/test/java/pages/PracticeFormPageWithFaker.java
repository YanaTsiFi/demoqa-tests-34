package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class PracticeFormPageWithFaker {

    // Элементы формы
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");

    // Компоненты
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultTableComponent resultTableComponent = new ResultTableComponent();

    // Методы для заполнения формы
    public PracticeFormPageWithFaker openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPageWithFaker removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPageWithFaker setFirstName() {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPageWithFaker setLastName() {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPageWithFaker setEmail() {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public PracticeFormPageWithFaker setGender() {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPageWithFaker setPhoneNumber() {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public PracticeFormPageWithFaker setDateOfBirth() {
        dateOfBirthInput.click();
        calendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }

    public PracticeFormPageWithFaker setSubject() {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPageWithFaker setHobby() {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPageWithFaker uploadPicture() {
        uploadPictureInput.uploadFromClasspath(picture);
        return this;
    }

    public PracticeFormPageWithFaker setCurrentAddress() {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public PracticeFormPageWithFaker setStateAndCity() {
        stateInput.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        cityInput.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    // Метод для проверки результатов
    public ResultTableComponent getResultTable() {
        return resultTableComponent;
    }
}