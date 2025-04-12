package tests;

import pages.PracticeFormPageWithFaker;
import pages.components.ResultTableComponent;
import org.junit.jupiter.api.Test;
import static tests.TestData.*;

public class TextBoxWithFakerTests extends TestBase {

    PracticeFormPageWithFaker practiceFormPage = new PracticeFormPageWithFaker();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender()
                .setPhoneNumber()
                .setDateOfBirth()
                .setSubject()
                .setHobby()
                .uploadPicture()
                .setCurrentAddress()
                .setStateAndCity()
                .submitForm();

        ResultTableComponent resultTable = practiceFormPage.getResultTable();
        resultTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture.substring(picture.lastIndexOf("/") + 1))
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}