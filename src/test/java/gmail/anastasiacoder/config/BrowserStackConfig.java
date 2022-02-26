package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:mobile.properties"})
public interface BrowserStackConfig extends Config {

    @Config.Key("browserstack.user")
    String user();

    @Config.Key("browserstack.key")
    String key();

    @Config.Key("browserstack.app")
    String app();
}