package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.SelenideTest.URL;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу {URL}")
    public void openMainPage(String URL) {
        open(URL);
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Pull-requests")
    public void openPullRequestsTab() {
        $("#pull-requests-tab").click();
    }

    @Step("Проверяем наличие Pull-requests с номером {pull_requests")
    public void shouldSeePullRequestsWithNumber(int pull_requests) {
        $(withText("#" + pull_requests)).should(Condition.visible);
    }


}
