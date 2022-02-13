package gmail.anastasiacoder.tests.selenoid;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WikipediaTests extends SelenoidTestBase {

    @Tag("Selenoid")
    @Test
    @DisplayName("Selenoid. Проверка результата поиска по значению 'BrowserStack'")
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