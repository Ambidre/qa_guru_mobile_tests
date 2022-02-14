package gmail.anastasiacoder.tests.real;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

import annotations.JiraIssue;
import annotations.JiraIssues;
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
@Feature("Real")
@JiraIssues({@JiraIssue("HOMEWORK-336")})
@Tags({@Tag("Real"),@Tag("UI")})
public class WikipediaTests extends RealTestBase {

    @Test
    @DisplayName("Проверка страниц getting started")
    @Microservice("Getting started")
    @Feature("Начало работы")
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