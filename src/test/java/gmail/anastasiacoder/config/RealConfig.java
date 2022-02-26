package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})

public interface RealConfig extends Config {

    @Key("real.device.name")
    String deviceName();

    @Key("real.app.path")
    String appPath();
}