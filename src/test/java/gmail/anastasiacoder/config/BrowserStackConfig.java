package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:browserstack.properties"})
public interface BrowserStackConfig extends Config {

    String app();

    String user();

    String key();

}