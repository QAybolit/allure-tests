package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.GithubSteps;

public class GithubStepsTest extends BaseTest {

    @Test
    @Feature("GitHub репозиторий")
    @Story("Issue в репозитории")
    @DisplayName("Проверка наличия Issue в репозитории")
    public void searchGithubIssueInRepoWithLambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        GithubSteps steps = new GithubSteps();

        steps.openMainPage();
        steps.findRepository(repo);
        steps.clickRepositoryLink(repo);
        steps.clickIssueTab();
        steps.checkIssueTitle(issueTitle);
    }
}
