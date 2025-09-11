package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    String repo = "QAibolit/junit5-parameterized-tests";
    String issueTitle = "GitHub Actions";

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
