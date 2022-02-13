package gmail.anastasiacoder.tests.local;

import com.codeborne.selenide.Configuration;
import gmail.anastasiacoder.drivers.LocalMobileDriver;
import gmail.anastasiacoder.helpers.Attach;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@ExtendWith({AllureJunit5.class})
public class LocalTestBase {

  @BeforeAll
  public static void setup() {
    addListener("AllureSelenide", new AllureSelenide());

    Configuration.browser = LocalMobileDriver.class.getName();
    Configuration.startMaximized = false;
    Configuration.browserSize = null;
    Configuration.timeout = 10000;
  }

  @BeforeEach
  public void startDriver() {
    open();
  }

  @AfterEach
  public void afterEach() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    closeWebDriver();
  }
}