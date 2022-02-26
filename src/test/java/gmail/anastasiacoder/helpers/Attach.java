package gmail.anastasiacoder.helpers;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import io.qameta.allure.Attachment;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Attach {

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static String getVideoUrl(String sessionId) {
        String deviceHost = System.getProperty("deviceHost");

        if(deviceHost.equals("browserstack")) {
            return Browserstack.videoUrl(sessionId);
        } else if(deviceHost.equals("selenoid")) {
            return getSelenoidVideoUrl(sessionId);
        }
        return null;
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(getSessionId())
                + "' type='video/mp4'></video></body></html>";
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static String getSelenoidVideoUrl(String sessionId) {
        try {
            return new URL("https://selenoid.autotests.cloud/video/" + sessionId + ".mp4") + "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}