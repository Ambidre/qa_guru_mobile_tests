package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:browserstack.properties"})
public interface BrowserStackConfig extends Config {

    @Key("app")
    String app();

    @Key("user")
    String user();

    @Key("key")
    String key();

}