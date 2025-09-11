package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSelenideTests extends BaseTest {

    @Test
    @Feature("GitHub репозиторий")
    @Story("Issue в репозитории")
    @DisplayName("Проверка наличия Issue в репозитории")
    public void searchGithubIssueInRepoTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).pressEnter();
        $(By.linkText(repo)).shouldBe(visible).click();
        $("#issues-tab").shouldBe(visible).click();
        $("[class*='IssueRow-module__row'] li").shouldBe(visible).shouldHave(text(issueTitle));
    }
}
