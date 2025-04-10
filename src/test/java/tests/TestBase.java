package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser.version", "120.0");
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.remote = System.getProperty("REMOTE_URL", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        Configuration.timeout = 10000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    @SuppressWarnings("unused")
    void addAttachments() {
        byte[] _screenshot = Attach.screenshotAs("Last screenshot");
        byte[] _pageSource = Attach.pageSource();
        Attach.browserConsoleLogs();
        String _video = Attach.addVideo();
    }
}
