package tests;

import pages.PracticeFormPage;
import pages.components.ResultTableComponent;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import helpers.Attach;

public class TextBoxTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .removeBanners();
        practiceFormPage
                .setFirstName("Yana")
                .setLastName("TS")
                .setEmail("YanaT@example.com")
                .setGender("Female")
                .setPhoneNumber("1234567890")
                .setDateOfBirth("03", "September", "1990")
                .setSubject("Maths")
                .setHobby("Music")
                .uploadPicture("images/image.jpg")
                .setCurrentAddress("123 Main St")
                .setStateAndCity("NCR", "Delhi")
                .submitForm();

        //noinspection unused
        byte[] _screenshot = Attach.screenshotAs("FormScreenshot");
//noinspection unused
        byte[] _pageSource = Attach.pageSource();
        Attach.browserConsoleLogs();
//noinspection unused
        String _video = Attach.addVideo();


        ResultTableComponent resultTable = practiceFormPage.getResultTable();
        resultTable.checkResult("Student Name", "Yana TS")
                .checkResult("Student Email", "YanaT@example.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "03 September,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "image.jpg")
                .checkResult("Address", "123 Main St")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void minimalFormTest() {
        practiceFormPage.openPage()
                .removeBanners();

        practiceFormPage
                .setFirstName("Yana")
                .setLastName("TS")
                .setGender("Female")
                .setPhoneNumber("1234567890")
                .submitForm();

        //noinspection unused
        byte[] _screenshot = Attach.screenshotAs("FormScreenshot");
//noinspection unused
        byte[] _pageSource = Attach.pageSource();
        Attach.browserConsoleLogs();
//noinspection unused
        String _video = Attach.addVideo();


        ResultTableComponent resultTable = practiceFormPage.getResultTable();
        resultTable.checkResult("Student Name", "Yana TS")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890");
    }

    @Test
    void negativeTest() {
        practiceFormPage.openPage()
                .removeBanners();
        practiceFormPage
                .setFirstName("Yana")
                .setLastName("TS")
                .setGender("Female")
                .setPhoneNumber("123")
                .submitForm();

        Boolean isInvalid = executeJavaScript(
                "return document.querySelector('#userNumber').matches(':invalid');"
        );
        assertTrue(isInvalid != null && isInvalid, "Поле номера телефона должно быть невалидным");

        //noinspection unused
        byte[] _screenshot = Attach.screenshotAs("FormScreenshot");
//noinspection unused
        byte[] _pageSource = Attach.pageSource();
        Attach.browserConsoleLogs();
//noinspection unused
        String _video = Attach.addVideo();


        $(".modal-content").shouldNotBe(visible);
    }
}