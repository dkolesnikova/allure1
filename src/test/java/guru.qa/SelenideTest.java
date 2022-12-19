package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;



    public class SelenideTest {

        static final String REPOSITORY = "dkolesnikova/println";
        static final Integer PULL_REQUEST = 1;
        static final String URL = "https://github.com";

        @Test
        public void searchRepo() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            open("https://github.com");
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("dkolesnikova/println");
            $(".header-search-input").submit();

            $(linkText("dkolesnikova/println")).click();
            $("#pull-requests-tab").click();
            $(withText("#1")).should(Condition.visible);
        }


        @Test

        public void testLambdaStep() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            step("Открываем главную страницу", ()->{
                open("https://github.com");
            });
            step("Ищем репозиторий"+ REPOSITORY, ()->{
                $(".header-search-input").click();
                $(".header-search-input").sendKeys(REPOSITORY);
                $(".header-search-input").submit();
            });
            step("Кликаем по ссылке репозитория" + REPOSITORY, ()->{
                $(linkText(REPOSITORY)).click();
            });
            step("Открываем таб Pull-requests", ()->{
                $("#pull-requests-tab").click();
            });
            step("Проверяем наличие Pull-requests с номером" + PULL_REQUEST, ()->{
                $(withText("#"+ PULL_REQUEST )).should(Condition.visible);
            });

        }

        @Test
        public void testAnnotatedStep() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            WebSteps steps = new WebSteps();

            steps.openMainPage(URL);
            steps.searchForRepository(REPOSITORY);
            steps.clickOnRepositoryLink(REPOSITORY);
            steps.openPullRequestsTab();
            steps.shouldSeePullRequestsWithNumber(PULL_REQUEST);


        }
    }

