package gmail.anastasiacoder.drivers;

import com.codeborne.selenide.WebDriverProvider;
import gmail.anastasiacoder.config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class);

    private URL apkUrl() {
        try {
            return new URL(
                    "https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(
                    "https://" + selenoidConfig.selenoidUser() + ":" + selenoidConfig.selenoidPassword()
                            + "@selenoid.autotests.cloud/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", "8.1");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }
}