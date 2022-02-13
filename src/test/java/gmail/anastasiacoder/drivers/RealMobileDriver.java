package gmail.anastasiacoder.drivers;

import com.codeborne.selenide.WebDriverProvider;
import gmail.anastasiacoder.config.RealConfig;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static gmail.anastasiacoder.utils.FileUtils.getAbsolutePath;

public class RealMobileDriver implements WebDriverProvider {

    public static URL getLocalURL() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }
    RealConfig realMobileConfig = ConfigFactory.create(RealConfig.class, System.getProperties());
    String deviceName = realMobileConfig.deviceName();
    String appPath = realMobileConfig.appPath();

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath(
                        getAbsolutePath(appPath)));

        return new AndroidDriver(getLocalURL(), desiredCapabilities);
    }
}