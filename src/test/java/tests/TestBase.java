package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    public static void setup() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
        back();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.video(sessionId);
        step("Close driver", Selenide::closeWebDriver);
    }
}
