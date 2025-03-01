package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Yana");
        $("#lastName").setValue("TS");
        $("#userEmail").setValue("YanaT@example.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/images/image.jpg"));
        $("#currentAddress").setValue("123 Main St");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Yana TS")).shouldBe(visible);
        $(".table-responsive").$(byText("YanaT@example.com")).shouldBe(visible);
        $(".table-responsive").$(byText("1234567890")).shouldBe(visible);
        $(".table-responsive").$(byText("03 September,1990")).shouldBe(visible);
        $(".table-responsive").$(byText("Maths")).shouldBe(visible);
        $(".table-responsive").$(byText("Music")).shouldBe(visible);
        $(".table-responsive").$(byText("image.jpg")).shouldBe(visible);
        $(".table-responsive").$(byText("123 Main St")).shouldBe(visible);
        $(".table-responsive").$(byText("NCR Delhi")).shouldBe(visible);
    }
}