package gmail.anastasiacoder.tests.selenoid;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

import annotations.Microservice;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Owner("Ambidre")
@Story("Wikipedia")
@Tag("Selenoid")
public class WikipediaTests extends SelenoidTestBase {

    @Test
    @DisplayName("Selenoid. Проверка результата поиска по значению 'BrowserStack'")
    @Microservice("Search")
    @Severity(SeverityLevel.CRITICAL)
    void searchBrowserStackInWikipedia() {
        back();
        step("Установка курсора в поле поиска", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Ввод значения 'BrowserStack' и инициация поиска", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack"));
        step("Проверка наличия результатов", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }
}