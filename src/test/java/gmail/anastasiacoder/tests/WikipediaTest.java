package gmail.anastasiacoder.tests;


import gmail.anastasiacoder.annotations.JiraIssue;
import gmail.anastasiacoder.annotations.JiraIssues;
import gmail.anastasiacoder.annotations.Layer;
import gmail.anastasiacoder.annotations.Microservice;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("UI")
@Story("Wikipedia")
@Feature("Browserstack")
@JiraIssues({@JiraIssue("HOMEWORK-336")})
@Tags({@Tag("Browserstack"),@Tag("UI")})
public class WikipediaTest extends TestBase{

    @Test
    @DisplayName("Проверка результата поиска по значению 'BrowserStack'")
    @Microservice("Search")
    @Feature("Поиск")
    @Owner("AnotherQA")
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

    @Test
    @DisplayName("Проверка открытия настроек")
    @Microservice("Settings")
    @Feature("Настройки")
    @Owner("Ambidre")
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

    @Test
    @DisplayName("Проверка страниц getting started")
    @Microservice("Getting started")
    @Feature("Начало работы")
    @Owner("Ambidre")
    @Severity(SeverityLevel.CRITICAL)
    void gettingStartedWikipediaTest() {
        back();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("New ways to explore"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("Reading lists with sync"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("Send anonymous data"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_container"))
                .shouldBe(value(String.valueOf(visible)));
    }
}
