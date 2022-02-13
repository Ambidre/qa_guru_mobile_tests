package gmail.anastasiacoder.tests.browserstack;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WikipediaTest extends BrowserstackTestBase {

    @Tag("Browserstack")
    @Test
    @DisplayName("Browserstack. Проверка результата поиска по значению 'BrowserStack'")
    void searchBrowserStackInWikipedia() {
        step("Установка курсора в поле поиска", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Ввод значения 'BrowserStack' и инициация поиска", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack"));
        step("Проверка наличия результатов", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Tag("Browserstack")
    @Test
    @DisplayName("Browserstack. Проверка открытия Settings")
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