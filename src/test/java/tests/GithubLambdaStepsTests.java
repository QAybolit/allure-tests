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
import static io.qameta.allure.Allure.step;

public class GithubLambdaStepsTests extends BaseTest {

    @Test
    @Feature("GitHub репозиторий")
    @Story("Issue в репозитории")
    @DisplayName("Проверка наличия Issue в репозитории")
    public void searchGithubIssueInRepoWithLambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу GitHub", () -> open(""));
        step("Найти репозиторий '%s' через строку поиска".formatted(repo), () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(repo).pressEnter();
        });
        step("Кликнуть по ссылке репозитория", () -> $(By.linkText(repo)).shouldBe(visible).click());
        step("В открывшемся репозитории нажать на таб Issue",
                () -> $("#issues-tab").shouldBe(visible).click());
        step("Проверить, что заголовок первого Issue во вклвдке равен " + issueTitle,
                () -> $("[class*='IssueRow-module__row'] li").shouldBe(visible).shouldHave(text(issueTitle)));
    }
}
