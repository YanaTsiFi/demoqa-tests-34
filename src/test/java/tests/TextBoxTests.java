package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Yana");
        $("#lastName").setValue("TS");
        $("#userEmail").setValue("YanaT@example.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("images/image.jpg");
        $("#currentAddress").setValue("123 Main St");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $x("//td[text()='Yana TS']").shouldHave(text("Yana TS"));
        $x("//td[text()='YanaT@example.com']").shouldHave(text("YanaT@example.com"));
        $x("//td[text()='1234567890']").shouldHave(text("1234567890"));
        $x("//td[text()='03 September,1990']").shouldHave(text("03 September,1990"));
        $x("//td[text()='Maths']").shouldHave(text("Maths"));
        $x("//td[text()='Music']").shouldHave(text("Music"));
        $x("//td[text()='image.jpg']").shouldHave(text("image.jpg"));
        $x("//td[text()='123 Main St']").shouldHave(text("123 Main St"));
        $x("//td[text()='NCR Delhi']").shouldHave(text("NCR Delhi"));
    }
}