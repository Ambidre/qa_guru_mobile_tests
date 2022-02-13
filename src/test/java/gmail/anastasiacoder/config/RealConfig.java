package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:real.properties"})

public interface RealConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("appPath")
    String appPath();
}