package gmail.anastasiacoder.tests.browserstack;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
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

@Owner("AnotherQA")
@Story("Wikipedia")
@Tag("Browserstack")
public class WikipediaTest extends BrowserstackTestBase {

    @Test
    @DisplayName("Browserstack. Проверка результата поиска по значению 'BrowserStack'")
    @Microservice("Search")
    @Severity(SeverityLevel.CRITICAL)
    void searchBrowserStackInWikipedia() {
        step("Установка курсора в поле поиска", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Ввод значения 'BrowserStack' и инициация поиска", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack"));
        step("Проверка наличия результатов", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Browserstack. Проверка открытия Settings")
    @Microservice("Settings")
    @Severity(SeverityLevel.BLOCKER)
    void openSettingsTest() {
        step("Открыть приложение", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click()
        );

        step("Открыть меню Settings", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click()
        );

        step("Проверка: меню Settings открыто", () -> {
            $(MobileBy.xpath(("//*[@text='General']"))).shouldBe(visible);
            $(MobileBy.xpath(("//*[@text='Privacy']"))).shouldBe(visible);
        });
    }
}