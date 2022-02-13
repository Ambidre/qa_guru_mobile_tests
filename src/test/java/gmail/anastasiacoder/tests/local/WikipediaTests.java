package gmail.anastasiacoder.tests.local;

import annotations.Layer;
import annotations.Microservice;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

@Layer("UI")
@Owner("Ambidre")
@Story("Wikipedia")
@Tag("Local")
public class WikipediaTests extends LocalTestBase {

  @Test
  @DisplayName("Проверка страниц getting started")
  @Microservice("Getting started")
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
