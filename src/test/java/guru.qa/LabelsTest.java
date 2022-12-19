package guru.qa;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {
    @Test
    @Feature("Pull-request в репозитории")
    @Story("Создание Pull-request")
    @Owner("dkolesnikova")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Pull-request для авторизованного пользователя")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Pull-request для авторизованного пользователя")
        );
        Allure.feature("Pull-request в репозитории");
        Allure.story("Создание Pull-request");
        Allure.label("owner", "dkolesnikova");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
