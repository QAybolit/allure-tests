package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSteps {

    @Step("Открыть главную страницу GitHub")
    public void openMainPage() {
        open("");
    }

    @Step("Найти репозиторий '{repo}' через строку поиска")
    public void findRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Кликнуть по ссылке репозитория")
    public void clickRepositoryLink(String repo) {
        $(By.linkText(repo)).shouldBe(visible).click();
    }

    @Step("В открывшемся репозитории нажать на таб Issue")
    public void clickIssueTab() {
        $("#issues-tab").shouldBe(visible).click();
    }

    @Step("Проверить, что заголовок первого Issue во вклвдке равен '{issueTitle}")
    public void checkIssueTitle(String issueTitle) {
        $("[class*='IssueRow-module__row'] li").shouldBe(visible).shouldHave(text(issueTitle));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
