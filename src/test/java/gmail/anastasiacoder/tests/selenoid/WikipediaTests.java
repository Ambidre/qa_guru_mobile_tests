package gmail.anastasiacoder.tests.selenoid;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

import annotations.Layer;
import annotations.Microservice;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Layer("UI")
@Owner("Ambidre")
@Story("Wikipedia")
@Tags({@Tag("Selenoid"),@Tag("UI")})
public class WikipediaTests extends SelenoidTestBase {

    @Test
    @DisplayName("Selenoid. Проверка результата поиска по значению 'BrowserStack'")
    @Microservice("Search")
    @Feature("Поиск")
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