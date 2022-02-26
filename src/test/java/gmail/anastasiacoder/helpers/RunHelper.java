package gmail.anastasiacoder.helpers;

import gmail.anastasiacoder.config.RunConfig;
import gmail.anastasiacoder.drivers.BrowserstackMobileDriver;
import gmail.anastasiacoder.drivers.LocalMobileDriver;
import gmail.anastasiacoder.drivers.RealMobileDriver;
import gmail.anastasiacoder.drivers.SelenoidMobileDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {
    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        if (config.deviceHost() == null) {
            throw new RuntimeException("Device host should not be null value");
        }

        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return LocalMobileDriver.class;
            case "real":
                return RealMobileDriver.class;
            case "selenoid":
                return SelenoidMobileDriver.class;
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
